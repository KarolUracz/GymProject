package pl.coderslab.gymproject.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.gymproject.Model.CurrentUser;
import pl.coderslab.gymproject.entity.User;
import pl.coderslab.gymproject.interfaces.RoleService;
import pl.coderslab.gymproject.interfaces.UserService;

@Controller
public class HomeController {

    private UserService userService;
    private RoleService roleService;

    public HomeController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String home(){ return "home"; }

    @GetMapping("/form")
    public String save(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/form")
    public String save(@ModelAttribute User user){
        user.setEnabled(1);
        userService.saveUser(user);
        return "redirect:/user/panel";
    }

    @GetMapping("/panel")
    public String panelRedirection(
            @AuthenticationPrincipal CurrentUser currentUser
    ) {
        if (currentUser.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
            return "redirect:/admin/panel";
        } else if (currentUser.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TRAINER"))) {
            return "redirect:/trainer/panel";
        } else {
            return "redirect:/user/panel";
        }
    }
}
