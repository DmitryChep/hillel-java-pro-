package ua.ithillel.javapro;

public class Printer {

    public static void printTitle() {
        System.out.println("Metric Units Conversion Calculator\nChoose4 temperature scale: \"Fahrenheit, Celsius\"");
    }

    public static void printRequestForUser(int step) {
        switch (step) {
            case 1:
                System.out.print("From: ");
                break;
            case 2:
                System.out.print("Enter the number of Fahrenheit: ");
                break;
            case 3:
                System.out.print("Enter the number of Celsius: ");
                break;
        }
    }

    public static void printResultsConversion(String results, double resultUnits) {
        switch (results) {
            case "resultFahrenheit":
                System.out.printf("Result: %.1f°F" , resultUnits);
                break;
            case "resultCelsius" :
                System.out.printf("Result: %.1f°C" , resultUnits);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + results);
        }
    }
}



