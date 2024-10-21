package ua.ithillel.javapro;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        validateAmount(getBalance(), getAmount());
    }

    public static double getBalance() {
        return 1000.00; // Наявні кошти на рахунку
    }

    public static double getAmount() {
        System.out.printf("Balance is USD %.2f.%n" + "Enter purchase amount, USD: ", getBalance());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    // Метод валідації наявних коштів
    public static void validateAmount(double balance, double withdrawal) {
        if (withdrawal > getBalance()) {
            try {
                throw new FoundException("Insufficient funds!");
            } catch (FoundException exception) {
                System.out.println(exception.getMessage());
            }
        } else {
            System.out.printf("Funds are OK. Purchase paid." + "%nBalance is USD %.2f", getBalance(balance, withdrawal));
        }
    }

    // Метод розрахунку наявних коштів на рахунку
    // після зняття певної суми коштів
    public static double getBalance(double balance, double withdrawal) {
        return balance - withdrawal;
    }
}
