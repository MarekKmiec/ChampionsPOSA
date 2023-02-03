//package pl.coderunner.championsposa.controler;
//
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import pl.coderunner.championsposa.service.SpringDataUserDetailsService;
//import pl.coderunner.championsposa.service.UserService;
//import pl.coderunner.championsposa.service.UserServiceImpl;
//
//@Controller
//@Secured("ROLE_ADMIN")
//@RequestMapping("/admin")
//public class AdminController {
//    private final UserService userService;
//    private final SpringDataUserDetailsService springDataUserDetailsService;
//    private final UserServiceImpl userServiceImpl;
//
//    public AdminController(UserService userService, SpringDataUserDetailsService springDataUserDetailsService, UserServiceImpl userServiceImpl) {
//        this.userService = userService;
//        this.springDataUserDetailsService = springDataUserDetailsService;
//        this.userServiceImpl = userServiceImpl;
//    }
//
//    @RequestMapping("/userlist")
//    public String userList(Model model) {
//        model.addAttribute("user",userServiceImpl.findAll());
//        return "allRegister";
//    }
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable long id,Model model){
//        model.addAttribute("user",userServiceImpl.findById(id));
//        return "register";
//    }
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable long id){
//        userServiceImpl.deleteUser(id);
//        return "redirect:/admin/userlist";
//    }
//}
