package pl.coderslab.gymproject.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.gymproject.entity.Role;
import pl.coderslab.gymproject.entity.User;
import pl.coderslab.gymproject.interfaces.RoleService;
import pl.coderslab.gymproject.interfaces.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
public class InitDataFixture {

    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    public InitDataFixture(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    public void initRoles() {
        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleService.save(roleAdmin);

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleService.save(roleUser);

        Role roleTrainer = new Role();
        roleTrainer.setName("ROLE_TRAINER");
        roleService.save(roleTrainer);
    }

    public void initUsers() {

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(roleService.findOneByName("ROLE_ADMIN"));

        User admin = new User();
        admin.setUsername("admin@admin");
        admin.setPassword("admin");
        admin.setFirstName("admin");
        admin.setLastName("admin");
        admin.setAddress("admin");
        admin.setRoles(adminRoles);
        userService.saveUser(admin);

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleService.findOneByName("ROLE_USER"));

        User user = new User();
        user.setUsername("user@user");
        user.setPassword("user");
        user.setFirstName("user");
        user.setLastName("user");
        user.setAddress("user");
        user.setRoles(userRoles);

        userService.saveUser(user);

        Set<Role> trainerRoles = new HashSet<>();
        trainerRoles.add(roleService.findOneByName("ROLE_TRAINER"));

        User trainer = new User();
        trainer.setUsername("trainer@trainer");
        trainer.setPassword("trainer");
        trainer.setFirstName("trainer");
        trainer.setLastName("trainer");
        trainer.setAddress("trainer");
        trainer.setRoles(trainerRoles);

        userService.saveUser(trainer);

        user.getRoles().forEach(e -> System.out.println(e.getName()));
    }
}
