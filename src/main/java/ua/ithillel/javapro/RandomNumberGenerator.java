package ua.ithillel.javapro;

public class RandomNumberGenerator {
    public static int generateRandomNumber(int min, int max) {
        if (min > max || min < 0) {
            throw new IllegalArgumentException();
        }
        return (int) (Math.random() * (max - min) + min);
    }
}
