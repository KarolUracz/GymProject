package pl.coderslab.gymproject.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.gymproject.Model.CurrentUser;
import pl.coderslab.gymproject.entity.Pass;
import pl.coderslab.gymproject.entity.PassType;
import pl.coderslab.gymproject.entity.Training;
import pl.coderslab.gymproject.entity.User;
import pl.coderslab.gymproject.fixture.InitDataFixture;
import pl.coderslab.gymproject.interfaces.PassService;
import pl.coderslab.gymproject.interfaces.PassTypeService;
import pl.coderslab.gymproject.interfaces.TrainingService;
import pl.coderslab.gymproject.interfaces.UserService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final InitDataFixture initDataFixture;
    private UserService userService;
    private PassService passService;
    private PassTypeService passTypeService;
    private TrainingService trainingService;

    public UserController(InitDataFixture initDataFixture, UserService userService, PassService passService, PassTypeService passTypeService, TrainingService trainingService) {
        this.initDataFixture = initDataFixture;
        this.userService = userService;
        this.passService = passService;
        this.passTypeService = passTypeService;
        this.trainingService = trainingService;
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
        currentUser.getUser().setPasses(new ArrayList<>(Arrays.asList(pass)));
        model.addAttribute("user", currentUser.getUser());
        return "redirect:/user/panel";
    }

    @ModelAttribute(name = "now")
    public LocalDate now(){
        return LocalDate.now();
    }

    @ModelAttribute(name = "trainings")
    public List<Training> trainings(){
        return trainingService.getAll();
    }

    @GetMapping("/participate/{userId}/{trainingId}")
    public String participateInTraining(@PathVariable long userId, @PathVariable long trainingId,
                                        @AuthenticationPrincipal CurrentUser currentUser, Model model) {
        trainingService.update(userService.findById(userId), trainingService.findById(trainingId));
        model.addAttribute("user", currentUser);
        model.addAttribute("userTrainings", trainingService.findByUser(userId));
        return "/user/panel";
    }

    @GetMapping("/extendPass")
    public String extendPass(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        model.addAttribute("passExtend", passTypeService.getAll());
        return "extendPass";
    }

    @GetMapping("/extendPass/{passId}")
    public String extendPass(@AuthenticationPrincipal CurrentUser currentUser, @PathVariable long passId){
        User user = currentUser.getUser();
        PassType byId = passTypeService.findById(passId);
        List<Pass> passes = user.getPasses();
        Pass pass = passes.get(passes.size() - 1);
        passes.remove(pass);
        pass.setEndDate(pass.getEndDate().plus(byId.getPeriod(), ChronoUnit.MONTHS));
        passes.add(pass);
        user.setPasses(passes);
        userService.updateUser(user);
        return "redirect:/user/panel";
    }

    @GetMapping("/changePassword")
    public String changePassword(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        model.addAttribute("user", currentUser.getUser());
        return "/user/changePassword";
    }

    @PostMapping("/changePassword")
    public String changePassword(@AuthenticationPrincipal CurrentUser currentUser, @ModelAttribute User user){
        userService.changePassword(currentUser, user);
        return "redirect:/user/panel";
    }
}
