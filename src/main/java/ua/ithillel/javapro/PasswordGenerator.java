package ua.ithillel.javapro;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String CHAR_POOL = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*()_+-=[]?";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generatePassword(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomCharIndex = RANDOM.nextInt(CHAR_POOL.length());
            password.append(CHAR_POOL.charAt(randomCharIndex));
        }
        return password.toString();
    }
}
