package pl.coderslab.gymproject.service;

import pl.coderslab.gymproject.Model.CurrentUser;
import pl.coderslab.gymproject.entity.Pass;
import pl.coderslab.gymproject.entity.User;

import java.util.List;

public interface UserService {

    User findByUserName(String name);
    void saveUser(User user);
    List<User> findAll();
    User findById(long id);
    void updateUser(User user);
    void delete(long id);
    void saveAdmin(User user);
    void saveTrainer(User user);
    List<User> findAllByRolesN_NameLike(String role);
    void changePassword(CurrentUser currentUser, User user);
    void extendPass(CurrentUser currentUser, long passId);
    Pass getPass(CurrentUser currentUser, long passId);
}
