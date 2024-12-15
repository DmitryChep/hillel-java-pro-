package ua.ithillel.javapro;


public class Application {
    public static void main(String[] args) {
        String resultGeneratorPassword = PasswordGenerator.generatePassword(10);
        System.out.println("The generated password is: " + resultGeneratorPassword);
    }
}
