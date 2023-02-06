package pl.coderunner.championsposa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderunner.championsposa.domain.User;
import pl.coderunner.championsposa.repository.PersistentTokenRepository;
import pl.coderunner.championsposa.repository.RoleRepository;
import pl.coderunner.championsposa.repository.UserRepository;
import pl.coderunner.championsposa.service.dto.UserDto;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Transactional
@Service
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PersistentTokenRepository persistentTokenRepository;
    private final RoleRepository roleRepository;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, PersistentTokenRepository persistentTokenRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.persistentTokenRepository = persistentTokenRepository;
        this.roleRepository = roleRepository;

    }

    public User createUser(UserDto userDto) {
        User user = new User();
        if (userDto.getUsername() != null) {
            user.setUsername(userDto.getUsername().toLowerCase());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setLocalDate(LocalDate.now());
            user.setActivationKey(UUID.randomUUID().toString());
            user.setActivated(false);
            user.setRoles(Set.of(roleRepository.findByName("ROLE_USER")));
            userRepository.save(user);
            log.debug("Created Information for User: {}", user);
        }

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
