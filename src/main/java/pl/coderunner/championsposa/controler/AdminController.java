package pl.coderunner.championsposa.controler;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderunner.championsposa.service.SpringDataUserDetailsService;
import pl.coderunner.championsposa.service.UserService;
import pl.coderunner.championsposa.service.UserServiceImpl;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final SpringDataUserDetailsService springDataUserDetailsService;
    private final UserServiceImpl userServiceImpl;

    public AdminController(UserService userService, SpringDataUserDetailsService springDataUserDetailsService, UserServiceImpl userServiceImpl) {
        this.userService = userService;
        this.springDataUserDetailsService = springDataUserDetailsService;
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping("/userlist")
    public String userList(Model model) {
        model.addAttribute("user",userServiceImpl.findAll());
        return "allRegister";
    }
}
