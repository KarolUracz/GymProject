package pl.coderslab.gymproject.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.gymproject.entity.User;
import pl.coderslab.gymproject.fixture.InitDataFixture;
import pl.coderslab.gymproject.interfaces.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final InitDataFixture initDataFixture;

    private UserService userService;

    public UserController(InitDataFixture initDataFixture, UserService userService) {
        this.initDataFixture = initDataFixture;
        this.userService = userService;
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(
            @AuthenticationPrincipal UserDetails customUser
    ) {
        return "You are logged as " + customUser;
    }

    @GetMapping("/about")
    public String about() {
        return "user/panel";
    }

//    @GetMapping("/initData")
//    @ResponseBody
//    public String createUser() {
//
//        this.initDataFixture.initRoles();
//        this.initDataFixture.initUsers();
//        return "initialized";
//    }

    @GetMapping("/panel")
    public String panel(){
        return "/user/panel";
    }

    @PostMapping("/form")
    public String save(@ModelAttribute User user) {
        userService.saveUser(user);
        return "/user/panel";
    }

}
