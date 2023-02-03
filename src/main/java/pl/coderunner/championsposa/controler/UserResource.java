package pl.coderunner.championsposa.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderunner.championsposa.domain.User;
import pl.coderunner.championsposa.exceptions.CreatedExceptions;
import pl.coderunner.championsposa.repository.UserRepository;
import pl.coderunner.championsposa.service.MailService;
import pl.coderunner.championsposa.service.UserService;
import pl.coderunner.championsposa.service.dto.UserDto;

import javax.validation.Valid;

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
    public User createUser(@Valid UserDto userDto){
        User newUser;
        if(userDto.getId() !=null){
            throw new CreatedExceptions(" nowy uzytkownik nie moze mniec nadanego ID");
        } else if (userRepository.findByUsernameIgnoreCase(userDto.getUsername()).isPresent()) {
            throw new CreatedExceptions("uzytkownik o tym adresie email istnieje");
        }else {
             newUser=userService.createUser(userDto);
        }

        return newUser;
    }
}
