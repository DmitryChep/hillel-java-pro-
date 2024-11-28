package ua.ithillel.javapro;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UserRepository {
    List<User> users;

    public UserRepository(List<User> users) {
        this.users = users;
    }

    public Optional<User> findUserById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Invalid user id");
        }
        return users.stream()
                .filter(user -> user.id() == (id))
                .findFirst();
    }

    public Optional<User> findUserByEmail(String email) {
        if (email.isEmpty()) {
            throw new IllegalArgumentException("Email is empty");
        }
        return users.stream()
                .filter(user -> user.email().equals(email))
                .findFirst();
    }

    public Optional<List<User>> findAllUsers() {
        if (users.isEmpty()) {
            throw new NoSuchElementException("Users list is empty");
        }
        return Optional.of(users);
    }
}
