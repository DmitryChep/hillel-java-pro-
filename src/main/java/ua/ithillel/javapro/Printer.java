package ua.ithillel.javapro;

public class Printer {

    public static void printTitle() {
        System.out.println("Metric Units Conversion Calculator\nChoose metric unit: \"Fahrenheit, Celsius\"");
    }

    public static void printRequestForUser(int step) {
        System.out.print("From: ");

    }

    public static void printResultsConversion(String results, double resultUnits) {
        switch (results) {
            case "resultFahrenheit":
                System.out.print( "Result: " + resultUnits+ " °F");
                break;
            case "resultCelsius" :
                System.out.print( "Result: " + resultUnits+ " °C");
                break;
        }
    }
}


