package pl.coderslab.gymproject.interfaces;

import org.springframework.stereotype.Service;
import pl.coderslab.gymproject.entity.Role;

public interface RoleService {
    void save(Role role);
    Role findOneByName(String roleName);
}
