package pl.coderslab.gymproject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.gymproject.entity.User;
import pl.coderslab.gymproject.repository.UserRepository;

public class UserConverter implements Converter<String, User> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User convert(String s) {
        return userRepository.getOne(Long.parseLong(s));
    }
}
