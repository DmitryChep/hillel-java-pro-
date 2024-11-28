package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    private UserRepository userRepository;
    private List<User> users;


    @BeforeEach
    void setUp() {
        users = new ArrayList<>();
        userRepository = new UserRepository(users);
    }

    @Test
    void findUserById_shouldReturnUser_whenIdIsCorrect() {
        users.add(new User(1, "John", "JohnDoe@gmail.com"));
        assertEquals("Optional[\n[id: 1, name: John, email: JohnDoe@gmail.com]]", userRepository.findUserById(1).toString());
    }

    @Test
    void findUserById_shouldThrowIllegalArgumentException_whenIDIsIncorrect() {
        assertThrows(IllegalArgumentException.class, () -> userRepository.findUserById(-1));
    }

    @Test
    void findUserByEmail_shouldReturnUser_whenAndEmailIsCorrect() {
        users.add(new User(1, "John", "JohnDoe@gmail.com"));
        assertEquals("Optional[\n[id: 1, name: John, email: JohnDoe@gmail.com]]", userRepository.findUserByEmail("JohnDoe@gmail.com").toString());
    }

    @Test
    void findUserByEmail_shouldThrowIllegalArgumentException_whenEmailIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> userRepository.findUserByEmail(""));

    }

    @Test
    void findAllUsers_shouldReturnAllUsers_whenAllUsersExists() {
        users.add(new User(1, "John", "JohnDoe@gmail.com"));
        assertTrue(userRepository.findAllUsers().isPresent());
    }

    @Test
    void findAllUsers_shouldThrowNoSuchElementException_whenAllUsersDoesNotExist() {
        assertThrows(NoSuchElementException.class, () -> userRepository.findAllUsers().orElseThrow());
    }
}