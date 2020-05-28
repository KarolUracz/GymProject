package pl.coderslab.gymproject.interfaces;

import pl.coderslab.gymproject.entity.User;

import java.util.List;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
    List<User> findAll();
}
