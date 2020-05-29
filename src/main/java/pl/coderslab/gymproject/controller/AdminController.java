package pl.coderslab.gymproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.gymproject.entity.Pass;
import pl.coderslab.gymproject.entity.PassType;
import pl.coderslab.gymproject.entity.Role;
import pl.coderslab.gymproject.entity.User;
import pl.coderslab.gymproject.interfaces.PassService;
import pl.coderslab.gymproject.interfaces.PassTypeService;
import pl.coderslab.gymproject.interfaces.RoleService;
import pl.coderslab.gymproject.interfaces.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;
    private PassService passService;
    private PassTypeService passTypeService;

    public AdminController(UserService userService, RoleService roleService, PassService passService, PassTypeService passTypeService) {
        this.userService = userService;
        this.roleService = roleService;
        this.passService = passService;
        this.passTypeService = passTypeService;
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

    @PostMapping("/addUser")
    public String save(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/admin/panel";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "/editUser";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute User user){
        userService.updateUser(user);
        return "redirect:/admin/panel";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        userService.delete(id);
        return "redirect:/admin/panel";
    }

    @GetMapping("/addPass")
    public String addPass(Model model){
        model.addAttribute("passType", new PassType());
        return "/admin/addPass";
    }

    @PostMapping("/addPass")
    public String addPass(@ModelAttribute PassType passType) {
        passTypeService.savePass(passType);
        return "redirect:/admin/panel";
    }

    @GetMapping("/addAdmin")
    public String addAdmin(Model model){
        model.addAttribute("user", new User());
        return "/admin/addAdmin";
    }

    @PostMapping("/addAdmin")
    public String addAdmin(@ModelAttribute User user) {
        userService.saveAdmin(user);
        return "redirect:/admin/panel";
    }

    @GetMapping("/addTrainer")
    public String addTrainer(Model model) {
        model.addAttribute("trainer", new User());
        return "/admin/addTrainer";
    }

    @PostMapping("/addTrainer")
    public String addTrainer(@ModelAttribute User user){
        userService.saveTrainer(user);
        return "redirect:/admin/panel";
    }

    @ModelAttribute(name = "passes")
    public List<Pass> getAll(){
        return passService.getAll();
    }

    @GetMapping("/passDelete/{id}")
    public String deletePass(@PathVariable long id){
        passService.delete(id);
        return "redirect:/admin/panel";
    }

    @ModelAttribute(name = "passTypes")
    public List<PassType> passTypes(){
        return passTypeService.getAll();
    }
}
