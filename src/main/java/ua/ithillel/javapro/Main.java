package ua.ithillel.javapro;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        ScannerUserInput scannerUserInput = new ScannerUserInput();

        Printer.printTitle();
        Printer.printRequestForUser();

        scannerUserInput.setUserDoubleInput(scannerUserInput.getScannerDouble().nextInt());
        converter.setMiles(scannerUserInput.getUserDoubleInput());
        double resultConversion = converter.convertMilesToKilometers(converter.getMiles());
        Printer.printResultsConversion( resultConversion);
    }
}

