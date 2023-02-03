//package pl.coderunner.championsposa.controler;
//
//
//import org.springframework.stereotype.Controller;
//
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import pl.coderunner.championsposa.domain.User;
//
//import pl.coderunner.championsposa.exceptions.WrongPassword;
//import pl.coderunner.championsposa.service.SpringDataUserDetailsService;
//import pl.coderunner.championsposa.service.UserService;
//
//import javax.validation.Valid;
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//
//@Controller
//public class HomeController {
//
//    private final SpringDataUserDetailsService springDataUserDetailsService;
//    private final UserService userService;
//
//    public HomeController(SpringDataUserDetailsService springDataUserDetailsService, UserService userService) {
//        this.springDataUserDetailsService = springDataUserDetailsService;
//        this.userService = userService;
//    }
//
//    @RequestMapping("/")
//    public String home() {
//        return "home";
//    }
//
//    @RequestMapping("/logged")
//    public String logged() {
//        return "logged";
//    }
//
//    @RequestMapping("/index")
//    public String index() {
//        return "index";
//    }
//
//
//    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
//    public String login(Model model) {
//        model.addAttribute("user", new User());
//        return "login";
//    }
//
//    @PostMapping("login")
//    public String logged(User user) {
//        String user1 = user.getUsername();
//        springDataUserDetailsService.loadUserByUsername(user1);
//        return "redirect:/index";
//    }
//
//    @RequestMapping("/register")
//    public String register(Model model) {
//        model.addAttribute("user", new User());
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String registered(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            model.addAttribute("user", user);
//            return "register";
//        }
//        if(userService.findByUserName(user.getUsername()) !=null ) {
//            result.rejectValue("email","error.user","Taki Email już istnieje w bazie daych");
//            model.addAttribute("user",user);
//            return "register";
//
//
//        }
//        if (!user.getPassword().equals(user.getMatchingPassword())) {
//            result.rejectValue("passowrd", "error.user", "Podane hasła są różne");
//            model.addAttribute("user", user);
//            return "register";
//        }
//        user.setLocalDate(LocalDate.now());
//        user.setLocalTime(LocalTime.now());
//        userService.saveUser(user);
//        return "redirect:/index";
//    }
//}
//
//
//
