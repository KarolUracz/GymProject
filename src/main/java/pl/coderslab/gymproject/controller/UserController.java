package pl.coderslab.gymproject.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.gymproject.Model.CurrentUser;
import pl.coderslab.gymproject.entity.Pass;
import pl.coderslab.gymproject.entity.PassType;
import pl.coderslab.gymproject.entity.User;
import pl.coderslab.gymproject.fixture.InitDataFixture;
import pl.coderslab.gymproject.interfaces.PassService;
import pl.coderslab.gymproject.interfaces.PassTypeService;
import pl.coderslab.gymproject.interfaces.UserService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final InitDataFixture initDataFixture;

    private UserService userService;
    private PassService passService;
    private PassTypeService passTypeService;

    public UserController(InitDataFixture initDataFixture, UserService userService, PassService passService, PassTypeService passTypeService) {
        this.initDataFixture = initDataFixture;
        this.userService = userService;
        this.passService = passService;
        this.passTypeService = passTypeService;
    }


    @GetMapping("/panel")
    public String panel(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        model.addAttribute("user",currentUser);
        return "/user/panel";
    }

    @PostMapping("/form")
    public String save(@ModelAttribute User user) {
        userService.saveUser(user);
        return "home";
    }

    @ModelAttribute(name = "passes")
    public List<PassType> passes(){
        return passTypeService.getAll();
    }

    @GetMapping("/getPass/{id}")
    public String getPass(@PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser, Model model){
        PassType byId = passTypeService.findById(id);
        LocalDate now = LocalDate.now();
        Pass pass = new Pass();
        pass.setPassType(byId);
        pass.setStartDate(now);
        pass.setEndDate(now.plus(byId.getPeriod(), ChronoUnit.MONTHS));
        pass.setUser(currentUser.getUser());
        passService.savePass(pass);
        currentUser.getUser().setPasses(new HashSet<>(Arrays.asList(pass)));
        model.addAttribute("user", currentUser.getUser());
        return "redirect:/user/panel";
    }

    @ModelAttribute(name = "now")
    public LocalDate now(){
        return LocalDate.now();
    }

    @GetMapping("/extendPass/{userId}/{passId}")
    public String extendPass(@PathVariable long userId, @PathVariable long passId) {


        return "";
    }

}
