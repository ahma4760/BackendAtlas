/*package com.example.backendatlas;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.example.backendatlas.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.backendatlas.entity.User;
import com.example.backendatlas.repository.UserRepository;
import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    public void testFindAll() {
        Set<User> expectedUsers = new HashSet<>();
        expectedUsers.add(new User()); // Tilføj nogle mock-brugere
        when(userRepository.findAll()).thenReturn((List<User>) expectedUsers);

        Set<User> actualUsers = userService.findAll();

        assertEquals(expectedUsers, actualUsers);
        verify(userRepository).findAll();
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setPassword("rawPassword");

        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.save(user);

        assertEquals("encodedPassword", savedUser.getPassword());
        verify(passwordEncoder).encode("rawPassword");
        verify(userRepository).save(user);
    }
    @Test
    public void testDelete() {
        User user = new User();

        userService.delete(user);

        verify(userRepository).delete(user);
    }
    @Test
    public void testDeleteById() {
        Long userId = 1L;

        userService.deleteById(userId);

        verify(userRepository).deleteById(userId);
    }
    @Test
    public void testFindById() {
        Long userId = 1L;
        Optional<User> expectedUser = Optional.of(new User());

        when(userRepository.findById(userId)).thenReturn(expectedUser);

        Optional<User> actualUser = userService.findById(userId);

        assertEquals(expectedUser, actualUser);
        verify(userRepository).findById(userId);
    }
    @Test
    public void testFindByName() {
        String username = "testUser";
        List<User> expectedUsers = Arrays.asList(new User());

        when(userRepository.findByUsername(username)).thenReturn(expectedUsers);

        List<User> actualUsers = userService.findByName(username);

        assertEquals(expectedUsers, actualUsers);
        verify(userRepository).findByUsername(username);
    }




}

*/