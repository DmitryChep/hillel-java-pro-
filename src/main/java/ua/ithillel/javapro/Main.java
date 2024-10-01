package ua.ithillel.javapro;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        ScannerUserInput scannerUserInput = new ScannerUserInput();

        Printer.printTitle();
        Printer.printRequestForUser(1);

        scannerUserInput.setUserStringInput(scannerUserInput.getScannerString().nextLine());

        if (scannerUserInput.getUserStringInput().trim().equalsIgnoreCase("Fahrenheit")) {
            Printer.printRequestForUser(2);
            scannerUserInput.setUserDoubleInput(scannerUserInput.getScannerDouble().nextInt());

            converter.setFahrenheit(scannerUserInput.getUserDoubleInput());
            double resultConversionFahrenheitToCelsius = converter.convertFahrenheitToCelsius(converter.getFahrenheit());

            Printer.printResultsConversion("resultCelsius", resultConversionFahrenheitToCelsius);
        } else if (scannerUserInput.getUserStringInput().trim().equalsIgnoreCase("Celsius")) {
            Printer.printRequestForUser(3);
            scannerUserInput.setUserDoubleInput(scannerUserInput.getScannerDouble().nextInt());

            converter.setCelsius(scannerUserInput.getUserDoubleInput());
            double resultConversionCelsiusToFahrenheit = converter.convertCelsiusToFahrenheit(converter.getCelsius());

            Printer.printResultsConversion("resultFahrenheit", resultConversionCelsiusToFahrenheit);
        } else {
            System.out.println("Error: Incorrect temperature scale entry");
        }
    }
}

