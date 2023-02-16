package pl.coderunner.championsposa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderunner.championsposa.domain.User;
import pl.coderunner.championsposa.repository.PersistentTokenRepository;
import pl.coderunner.championsposa.repository.UserRepository;

import java.util.Optional;

@RestController

@RequestMapping("/api")
public class AccountResource {

    private final Logger log = LoggerFactory.getLogger(AccountResource.class);
    private final UserRepository userRepository;
    private final UserService userService;

    private final MailService mailService;

    private final PersistentTokenRepository persistentTokenRepository;

    public AccountResource(UserRepository userRepository, UserService userService, MailService mailService, PersistentTokenRepository persistentTokenRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.mailService = mailService;
        this.persistentTokenRepository = persistentTokenRepository;
    }

    @GetMapping("/activate")
    public String activateAccount(@RequestParam(value = "key") String key) {
        Optional<User> user = userService.activeRegistration(key);
        if (user.isEmpty()) {
            throw new RuntimeException("rejestracja nie powiodła się ");
        }else {
            return "Użutkownik zarejstrowany";
        }


    }
}
