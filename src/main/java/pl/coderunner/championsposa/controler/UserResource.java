package pl.coderunner.championsposa.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderunner.championsposa.domain.User;
import pl.coderunner.championsposa.exceptions.CreatedExceptions;
import pl.coderunner.championsposa.repository.UserRepository;
import pl.coderunner.championsposa.security.AuthoritiesConstants;
import pl.coderunner.championsposa.service.MailService;
import pl.coderunner.championsposa.service.UserService;
import pl.coderunner.championsposa.service.dto.UserDto;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class UserResource {


    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    private final UserService userService;

    private final UserRepository userRepository;

    private final MailService mailService;

    public UserResource(UserService userService, UserRepository userRepository, MailService mailService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.mailService = mailService;
    }



    @PostMapping("/users")

//    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public User createUser(@RequestBody UserDto userDto) throws MessagingException, URISyntaxException {
        User newUser;
        if (userDto.getId() != null) {
            throw new CreatedExceptions(" nowy uzytkownik nie moze mniec nadanego ID");
        } else if (userRepository.findByUsernameIgnoreCase(userDto.getUsername()).isPresent()) {
            throw new CreatedExceptions("uzytkownik o tym adresie email istnieje");
        } else {
            newUser = userService.createUser(userDto);
            mailService.sendActivationEmail(newUser);
        }

        return newUser;
    }
    @GetMapping("/users/{username}")
    public User getUser(@PathVariable String username){
        return userService.findUser(username);
    }
}
