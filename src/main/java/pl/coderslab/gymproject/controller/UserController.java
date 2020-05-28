package pl.coderslab.gymproject.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.gymproject.Model.CurrentUser;
import pl.coderslab.gymproject.entity.Pass;
import pl.coderslab.gymproject.entity.User;
import pl.coderslab.gymproject.fixture.InitDataFixture;
import pl.coderslab.gymproject.interfaces.PassService;
import pl.coderslab.gymproject.interfaces.UserService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

//    private final InitDataFixture initDataFixture;

    private UserService userService;
    private PassService passService;

    public UserController(UserService userService, PassService passService) {
        this.userService = userService;
        this.passService = passService;
    }

//    @GetMapping("/admin")
//    @ResponseBody
//    public String admin(
//            @AuthenticationPrincipal UserDetails customUser
//    ) {
//        return "You are logged as " + customUser;
//    }
//
//    @GetMapping("/about")
//    public String about() {
//        return "user/panel";
//    }

//    @GetMapping("/initData")
//    @ResponseBody
//    public String createUser() {
//
//        this.initDataFixture.initRoles();
//        this.initDataFixture.initUsers();
//        return "initialized";
//    }

    @GetMapping("/panel")
    public String panel(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        model.addAttribute("user",currentUser);
        return "/user/panel";
    }

    @PostMapping("/form")
    public String save(@ModelAttribute User user) {
        userService.saveUser(user);
        return "/user/panel";
    }

    @ModelAttribute(name = "passes")
    public List<Pass> passes(){
        return passService.getAll();
    }

    @GetMapping("/getPass/{id}")
    public String getPass(@PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser){
        Pass byId = passService.findById(id);
        currentUser.getUser().getPass().add(byId);
        return "/user/panel";
    }

}
