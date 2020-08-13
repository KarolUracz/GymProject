package pl.coderslab.gymproject.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.coderslab.gymproject.entity.User;
import pl.coderslab.gymproject.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
class UserServiceImplTest {

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void findByUserName() {
        User user = new User();
        user.setUsername("test@test");
        user.setFirstName("test");
        user.setLastName("test");
        user.setAddress("testAddress");
        user.setEmail(user.getUsername());
        user.setEnabled(1);
        user.setId(1L);
        user.setPassword("pass");
        Mockito.when(userRepository.findByUsername("test@test")).thenReturn(user);

        User userTest = userService.findByUserName("test@test");

        assertThat(userTest.getUsername()).isSameAs(user.getUsername());
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

    @Test
    void extendPass() {
    }

    @Test
    void getPass() {
    }
}