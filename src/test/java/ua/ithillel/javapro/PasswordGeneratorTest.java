package ua.ithillel.javapro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordGeneratorTest {

    @Test
    void generatePassword_couldReturnRandomPassword_whenLengthIsGreaterThan0() {
        String result = PasswordGenerator.generatePassword(10);
        assertFalse(result.isEmpty());
    }

    @Test
    void generatePassword_couldThrowIllegalArgumentException_whenLengthIsLessThan1() {
        assertThrows(IllegalArgumentException.class, () -> PasswordGenerator.generatePassword(0));
    }
}