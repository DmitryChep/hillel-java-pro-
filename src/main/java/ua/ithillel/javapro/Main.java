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
            double resultConversion = converter.convertFahrenheitToCelsius(converter.getFahrenheit());

            Printer.printResultsConversion("resultCelsius", resultConversion);
        } else {
            System.out.println("Error: Incorrect temperature scale entry");
        }
    }
}

