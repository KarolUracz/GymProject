package pl.coderslab.gymproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.gymproject.entity.*;
import pl.coderslab.gymproject.interfaces.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
    private final PassService passService;
    private final PassTypeService passTypeService;
    private final TrainingService trainingService;

    public AdminController(UserService userService, RoleService roleService, PassService passService, PassTypeService passTypeService, TrainingService trainingService) {
        this.userService = userService;
        this.roleService = roleService;
        this.passService = passService;
        this.passTypeService = passTypeService;
        this.trainingService = trainingService;
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

    @GetMapping("/showTrainers")
    public String showTrainers(){
        return "/admin/trainers";
    }

    @ModelAttribute(name = "trainers")
    public List<User> trainers(){
        return userService.findAllByRolesN_NameLike("ROLE_TRAINER");
    }

    @GetMapping("/addTraining")
    public String addTraining(Model model){
        model.addAttribute("training", new Training());
        return "/admin/addTraining";
    }

    @PostMapping("/addTraining")
    public String addTraining(@ModelAttribute Training training){
        trainingService.save(training);
        return "redirect:/admin/panel";
    }

    @ModelAttribute(name = "days")
    public List<DayOfWeek> getDays(){
        return new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,DayOfWeek.THURSDAY,
                DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY));
    }

    @GetMapping("/trainings")
    public String showTrainings(){
        return "/admin/trainings";
    }

    @ModelAttribute(name = "trainings")
    public List<Training> trainings(){
        return trainingService.getAll();
    }

    @GetMapping("/deleteTraining/{id}")
    public String deleteTraining(@PathVariable long id) {
        trainingService.delete(id);
        return "redirect:/admin/trainings";
    }
}
