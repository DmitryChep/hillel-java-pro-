package ua.ithillel.javapro;

import org.junit.jupiter.api.Test;
import ua.ithillel.javapro.util.RandomNumberGeneratorUtil;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    @Test
    void getRandomNumberRange_shouldReturnRandomNumberInRange() {
        int result = RandomNumberGeneratorUtil.getRandomNumber(
                () -> RandomNumberGenerator.generateRandomNumber(1, 5));
        assertTrue(result > 0);
    }
}