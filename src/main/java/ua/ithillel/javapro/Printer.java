package ua.ithillel.javapro;

public class Printer {

    public static void printTitle(){
        System.out.println("Metric Units Conversion Calculator\nChoose metric unit: \"Mile, kilometer\"");
    }

    public static void printRequestForUser(int step) {
        switch (step) {
            case 1:
                System.out.print("From: ");
                break;
            case 2:
                System.out.print("Enter the number of miles: ");
                break;
            case 3:
                System.out.print("Enter the number of kilometers: ");
                break;
        }
    }

    public static void printResultsConversion(String results, double resultUnits) {
        switch (results) {
            case "resultMiles":
                System.out.print( "Result: " + resultUnits+ " mi");
                break;
            case "resultKilometers" :
                System.out.print( "Result: " + resultUnits+ " km");
                break;
        }
    }
}

