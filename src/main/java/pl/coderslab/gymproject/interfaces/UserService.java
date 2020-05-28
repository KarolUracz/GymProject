package pl.coderslab.gymproject.interfaces;


import org.springframework.stereotype.Service;
import pl.coderslab.gymproject.entity.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
}
