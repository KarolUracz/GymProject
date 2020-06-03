package pl.coderslab.gymproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import pl.coderslab.gymproject.interfaces.UserService;

class UserServiceImplTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserService userService;

    @Test
    void findByUserName() {
    }

    @Test
    void saveUser() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void delete() {
    }

    @Test
    void saveAdmin() {
    }

    @Test
    void saveTrainer() {
    }

    @Test
    void findAllByRolesN_NameLike() {
    }

    @Test
    void changePassword() {
    }
}