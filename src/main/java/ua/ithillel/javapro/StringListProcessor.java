package ua.ithillel.javapro;

public class StringListProcessor {
    public static int countUpperCase(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("String is null or empty");
        }
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
