package ua.ithillel.javapro;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        ScannerUserInput scannerUserInput = new ScannerUserInput();

        Printer.printTitle();
        Printer.printRequestForUser(1);
        scannerUserInput.setUserStringInput(scannerUserInput.getScannerString().nextLine());
        //
        if (scannerUserInput.getUserStringInput().trim().equalsIgnoreCase("mile")) {
            Printer.printRequestForUser(2);
            scannerUserInput.setUserDoubleInput(scannerUserInput.getScannerDouble().nextInt());
            converter.setMiles(scannerUserInput.getUserDoubleInput());
            double resultConversion = converter.convertMilesToKilometers(converter.getMiles());
            Printer.printResultsConversion("resultKilometers", resultConversion);
            //
        } else if (scannerUserInput.getUserStringInput().trim().equalsIgnoreCase("kilometer")) {
            Printer.printRequestForUser(3);
            scannerUserInput.setUserDoubleInput(scannerUserInput.getScannerDouble().nextInt());
            converter.setKilometers(scannerUserInput.getUserDoubleInput());
            double resultConversion = converter.convertKilometersToMiles(converter.getKilometers());
            Printer.printResultsConversion("resultMiles", resultConversion);
        } else {
            System.out.println("Error: Incorrect metric unit entry");
        }
    }
}


