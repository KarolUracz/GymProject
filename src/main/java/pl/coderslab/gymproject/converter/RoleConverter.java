package pl.coderslab.gymproject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.gymproject.entity.Role;
import pl.coderslab.gymproject.repository.RoleRepository;

public class RoleConverter implements Converter<String, Role> {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role convert(String s) {
        return roleRepository.findById(Long.parseLong(s)).orElse(null);
    }
}
