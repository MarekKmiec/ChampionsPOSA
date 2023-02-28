package pl.coderunner.championsposa.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderunner.championsposa.domain.User;
import pl.coderunner.championsposa.domain.UserAddress;
import pl.coderunner.championsposa.domain.UserData;
import pl.coderunner.championsposa.repository.PersistentTokenRepository;
import pl.coderunner.championsposa.repository.RoleRepository;
import pl.coderunner.championsposa.repository.UserRepository;
import pl.coderunner.championsposa.service.dto.UserAddressDto;
import pl.coderunner.championsposa.service.dto.UserDataDto;
import pl.coderunner.championsposa.service.dto.UserDto;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Transactional
@Service
//@RequiredArgsConstructor
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PersistentTokenRepository persistentTokenRepository;
    private final RoleRepository roleRepository;
    private final MailService mailService;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, PersistentTokenRepository persistentTokenRepository, RoleRepository roleRepository, MailService mailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.persistentTokenRepository = persistentTokenRepository;
        this.roleRepository = roleRepository;

        this.mailService = mailService;
    }



    @Transactional
    public User createUser(UserDto userDto) throws MessagingException {
        User user = new User();
        if (userDto.getUsername() != null) {
            user.setUsername(userDto.getUsername().toLowerCase());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setLocalDate(LocalDate.now());
            user.setActivationKey(UUID.randomUUID().toString());
            user.setActivated(false);
            user.setRoles(Set.of(roleRepository.findByName("ROLE_USER")));

            log.debug("Created Information for User: {}", user);
        }



        if(userDto.getUserDataDto()!=null){
            UserDataDto userDataDto=userDto.getUserDataDto();
            UserData userData =new UserData();

            userData.setFirstName(userDataDto.getFirstName());
            userData.setLastName(userDataDto.getLastName());
            userData.setPhoneNumber(userDataDto.getPhoneNumber());
            userData.setDataOfBirth(userDataDto.getDataOfBirth());
            userData.setSex(userDataDto.getSex());

            user.setUserData(userData);

        }

        if(userDto.getUserAddressDto()!=null){
            UserAddressDto userAddressDto =userDto.getUserAddressDto();
            UserAddress userAddress=new UserAddress();

            userAddress.setStreet(userAddressDto.getStreet());
            userAddress.setHouseNumber(userAddressDto.getHouseNumber());
            userAddress.setApartmentNumber(userAddressDto.getApartmentNumber());
            userAddress.setCountry(userAddressDto.getCountry());
            userAddress.setCity(userAddressDto.getCity());
            userAddress.setZipCode(userAddressDto.getZipCode());

            user.setUserAddress(List.of(userAddress));
        }

        userRepository.save(user);
        mailService.sendActivationEmail(user);

        return user;
    }

    public Optional<User> activeRegistration(String key) {
        return userRepository.findOneByActivationKey(key)
                .map(user -> {
                    user.setActivated(true);
                    user.setActivationKey(null);
                    return user;
                });
    }

    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }
}
