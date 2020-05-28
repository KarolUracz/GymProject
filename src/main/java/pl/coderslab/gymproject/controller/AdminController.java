package pl.coderslab.gymproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.gymproject.entity.Role;
import pl.coderslab.gymproject.entity.User;
import pl.coderslab.gymproject.interfaces.RoleService;
import pl.coderslab.gymproject.interfaces.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/panel")
    public String adminPanel(){
        return "/admin/panel";
    }

    @ModelAttribute(name = "users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "/admin/adduser";
    }

    @ModelAttribute(name = "roles")
    public List<Role> getRoles(){
        return roleService.findAll();
    }
}
