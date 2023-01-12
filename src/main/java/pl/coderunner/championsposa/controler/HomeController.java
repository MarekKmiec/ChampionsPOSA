package pl.coderunner.championsposa.controler;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderunner.championsposa.domain.User;
import pl.coderunner.championsposa.dto.UserRegister;
import pl.coderunner.championsposa.service.SpringDataUserDetailsService;
import pl.coderunner.championsposa.service.UserService;


@Controller
public class HomeController {

    private final SpringDataUserDetailsService springDataUserDetailsService;
    private final UserService userService;

    public HomeController(SpringDataUserDetailsService springDataUserDetailsService, UserService userService) {
        this.springDataUserDetailsService = springDataUserDetailsService;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("login")
    public String logged(User user) {
        String user1 = user.getUsername();
        springDataUserDetailsService.loadUserByUsername(user1);
        return "redirect:/index";
    }
//    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
//    public String register(){
//        return"registerTest";
//    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("userregister",new UserRegister());
        return "register";
    }

}

