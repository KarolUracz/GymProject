package pl.coderslab.gymproject.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.gymproject.Model.CurrentUser;
import pl.coderslab.gymproject.entity.User;
import pl.coderslab.gymproject.fixture.InitDataFixture;
import pl.coderslab.gymproject.interfaces.RoleService;
import pl.coderslab.gymproject.interfaces.UserService;

@Controller
public class HomeController {

    private InitDataFixture initDataFixture;
    private UserService userService;
    private RoleService roleService;

    public HomeController(InitDataFixture initDataFixture, UserService userService, RoleService roleService) {
        this.initDataFixture = initDataFixture;
        this.userService = userService;
        this.roleService = roleService;
    }

//    @GetMapping("/initData")
//    @ResponseBody
//    public String createUser() {
//
//        this.initDataFixture.initRoles();
//        this.initDataFixture.initUsers();
//        return "initialized";
//    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/form")
    public String save(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/form")
    public String save(@ModelAttribute User user) {
        user.setEnabled(1);
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/panel")
    public String panelRedirection(
            @AuthenticationPrincipal CurrentUser currentUser
    ) {
        if (currentUser.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/admin/panel";
        } else if (currentUser.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TRAINER"))) {
            return "redirect:/trainer/panel";
        } else {
            return "redirect:/user/panel";
        }
    }
}
