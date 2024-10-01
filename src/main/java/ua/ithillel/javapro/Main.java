package ua.ithillel.javapro;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        ScannerUserInput scannerUserInput = new ScannerUserInput();

        Printer.printTitle();
        Printer.printRequestForUser(1);

        scannerUserInput.setUserStringInput(scannerUserInput.getScannerString().nextLine());

    }
}
