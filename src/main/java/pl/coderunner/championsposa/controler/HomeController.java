package pl.coderunner.championsposa.controler;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderunner.championsposa.domain.User;
import pl.coderunner.championsposa.dto.UserRegister;
import pl.coderunner.championsposa.exceptions.WrongPassword;
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
@PostMapping("/register")
    public String registered(UserRegister userRegister){
        User user=new User();
        if(userRegister.getPassword().equals(userRegister.getPassword2())){
            user.setUsername(userRegister.getUsername());
            user.setPassword(userRegister.getPassword());
            user.setFirstName(userRegister.getFirstName());
            user.setLastName(userRegister.getLastName());
            user.setStreet(userRegister.getStreet());
            user.setHouseNumber(userRegister.getHouseNumber());
            user.setApartmentNumber(userRegister.getApartmentNumber());
            user.setCountry(userRegister.getCountry());
            user.setCity(userRegister.getCity());
            user.setZipCode(userRegister.getZipCode());
            user.setPhoneNumber(userRegister.getPhoneNumber());
            userService.saveUser(user);
            return "redirect:/index";
        }else {
            throw new WrongPassword("różne hasła");
        }

    }

}

