package ua.ithillel.javapro;

import java.util.Scanner;

public class ScannerUserInput {
    Scanner scannerString = new Scanner(System.in);
    Scanner scannerDouble = new Scanner(System.in);

    private String userStringInput;
    private double userDoubleInput;

    public Scanner getScannerDouble() {
        return scannerDouble;
    }

    public void setScannerDouble(Scanner scannerDouble) {
        this.scannerDouble = scannerDouble;
    }

    public Scanner getScannerString() {
        return scannerString;
    }

    public void setScannerString(Scanner scannerString) {
        this.scannerString = scannerString;
    }

    public double getUserDoubleInput() {
        return userDoubleInput;
    }

    public void setUserDoubleInput(double userDoubleInput) {
        this.userDoubleInput = userDoubleInput;
    }

    public String getUserStringInput() {
        return userStringInput;
    }

    public void setUserStringInput(String userStringInput) {
        this.userStringInput = userStringInput;
    }
}


