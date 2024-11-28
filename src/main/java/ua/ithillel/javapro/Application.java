package ua.ithillel.javapro;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    private static final int ID_JOHNNY = 1;
    private static final String EMAIL_MADONNA = "Madonna@wbr.com";

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository(new ArrayList<>(Arrays.asList(new User(1, "Johnny", "johnnydepp@insider-connect.com"),
                                                                                        new User(2, "Clint", "rowdiyates@aol.com"),
                                                                                        new User(3, "Demi", "Demim2@aol.com"),
                                                                                        new User(4, "Madonna", "Madonna@wbr.com"),
                                                                                        new User(5, "Oprah", "harpo@interaccess.com"))));
        // Find a user by ID
        userRepository.findUserById(ID_JOHNNY).ifPresentOrElse(user -> System.out.println("User by Id: " + user + "\n"),
                () -> System.err.println("User not found by Id: " + ID_JOHNNY));
        // Find a user by email
        userRepository.findUserByEmail(EMAIL_MADONNA).ifPresentOrElse(user -> System.out.println("User by email: " + user + "\n"),
                () -> System.err.println("User not found by email: " + EMAIL_MADONNA));
        // Find all users
        userRepository.findAllUsers().ifPresentOrElse(user -> System.out.println("All users: " + user), () -> System.err.println("All users not found"));
    }
}
