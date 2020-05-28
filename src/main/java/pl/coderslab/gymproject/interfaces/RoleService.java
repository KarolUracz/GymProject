package pl.coderslab.gymproject.interfaces;


import pl.coderslab.gymproject.entity.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);
    Role findOneByName(String roleName);
    List<Role> findAll();
}
