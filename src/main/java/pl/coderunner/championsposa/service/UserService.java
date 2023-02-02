package pl.coderunner.championsposa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderunner.championsposa.domain.Role;
import pl.coderunner.championsposa.domain.User;
import pl.coderunner.championsposa.repository.AuthorityRepository;
import pl.coderunner.championsposa.repository.PersistentTokenRepository;
import pl.coderunner.championsposa.repository.UserRepository;
import pl.coderunner.championsposa.security.RandomUtil;
import pl.coderunner.championsposa.service.dto.AdminUserDto;

import java.time.LocalDate;
import java.util.Set;

@Transactional
@Service
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PersistentTokenRepository persistentTokenRepository;
    private final AuthorityRepository authorityRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, PersistentTokenRepository persistentTokenRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.persistentTokenRepository = persistentTokenRepository;
        this.authorityRepository = authorityRepository;
    }

    public User createUser(AdminUserDto adminUserDto){
        User user=new User();
        if(adminUserDto.getUsername() !=null){
            user.setUsername(adminUserDto.getUsername().toLowerCase());
        }
        user.setImageUrl(adminUserDto.getImageUrl());
        String encryptedPassword=passwordEncoder.encode(RandomUtil.generatePassword());
        user.setPassword(encryptedPassword);
        user.setResetKey(RandomUtil.generateResetKey());
        user.setLocalDate(LocalDate.now());
        user.setActivated(true);
        if(adminUserDto.getRoles() !=null){

        }



return user;
    }
}
