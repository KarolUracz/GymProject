package pl.coderslab.gymproject.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.gymproject.Model.CurrentUser;
import pl.coderslab.gymproject.entity.Pass;
import pl.coderslab.gymproject.entity.PassType;
import pl.coderslab.gymproject.entity.Role;
import pl.coderslab.gymproject.entity.User;
import pl.coderslab.gymproject.interfaces.UserService;
import pl.coderslab.gymproject.repository.PassRepository;
import pl.coderslab.gymproject.repository.PassTypeRepository;
import pl.coderslab.gymproject.repository.RoleRepository;
import pl.coderslab.gymproject.repository.UserRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final PassRepository passRepository;
    private final PassTypeRepository passTypeRepository;

    public UserServiceImpl(
            UserRepository userRepository,
            RoleRepository roleRepository,
            BCryptPasswordEncoder passwordEncoder,
            PassRepository passRepository, PassTypeRepository passTypeRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passRepository = passRepository;
        this.passTypeRepository = passTypeRepository;
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        if (user.getRoles() == null || user.getRoles().size() == 0) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findOneByName("ROLE_USER"));
            user.setRoles(roles);
        }
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void updateUser(User user) {
        User userFromDb = userRepository.getOne(user.getId());
        user.setPassword(userFromDb.getPassword());
        user.setRoles(userFromDb.getRoles());
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        User fromDb = userRepository.getOne(id);
        fromDb.setEnabled(0);
        userRepository.save(fromDb);
    }

    @Override
    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        if (user.getRoles() == null || user.getRoles().size() == 0) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findOneByName("ROLE_ADMIN"));
            user.setRoles(roles);
        }
        userRepository.save(user);
    }

    @Override
    public void saveTrainer(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        if (user.getRoles() == null || user.getRoles().size() == 0) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findOneByName("ROLE_TRAINER"));
            user.setRoles(roles);
        }
        userRepository.save(user);
    }

    @Override
    public List<User> findAllByRolesN_NameLike(String role) {
        return findAll().stream().filter(user -> user.getRoles().contains(roleRepository.findOneByName("ROLE_TRAINER"))).collect(Collectors.toList());
    }

    @Override
    public void changePassword(CurrentUser currentUser,User user) {
        User currUser = currentUser.getUser();
        User userFromDb = userRepository.getOne(currUser.getId());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setFirstName(currentUser.getUser().getFirstName());
        user.setUsername(currentUser.getUser().getEmail());
        user.setLastName(currentUser.getUser().getLastName());
        user.setAddress(currentUser.getUser().getAddress());
        user.setEmail(currentUser.getUser().getEmail());
        user.setEnabled(1);
        user.setPasses(userFromDb.getPasses());
        user.setRoles(userFromDb.getRoles());
        userRepository.save(user);
    }

    @Override
    public void extendPass(CurrentUser currentUser, long passId) {
        User user = currentUser.getUser();
        PassType byId = passTypeRepository.findById(passId);
        List<Pass> passes = user.getPasses();
        Pass pass = passes.get(passes.size() - 1);
        passes.remove(pass);
        pass.setEndDate(pass.getEndDate().plus(byId.getPeriod(), ChronoUnit.MONTHS));
        passes.add(pass);
        passRepository.save(pass);
        user.setPasses(passes);
        userRepository.save(user);
    }

    @Override
    public Pass getPass(CurrentUser currentUser, long passId) {
        PassType byId = passTypeRepository.findById(passId);
        LocalDate now = LocalDate.now();
        Pass pass = new Pass();
        pass.setPassType(byId);
        pass.setStartDate(now);
        pass.setEndDate(now.plus(byId.getPeriod(), ChronoUnit.MONTHS));
        pass.setUser(currentUser.getUser());
        passRepository.save(pass);
        return pass;
    }
}
