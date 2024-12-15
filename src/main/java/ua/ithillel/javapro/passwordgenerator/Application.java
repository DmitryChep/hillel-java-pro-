package ua.ithillel.javapro.passwordgenerator;

import ua.ithillel.javapro.PasswordGenerator;

public class Application {
    public static void main(String[] args) {
        String resultPasswordGenerator = PasswordGenerator.generatePassword(10);
        System.out.println("The generated password in the new project is: " + resultPasswordGenerator);
    }
}
