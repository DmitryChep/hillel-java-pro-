package ua.ithillel.javapro;

public class Main {
    public static void main(String[] args) {

        DataProvider provider = new DataProvider();
        DataHandler<String> dataHandlerString = new DataHandler<>();
        DataHandler<Double> dataHandlerDouble = new DataHandler<>();

        // Обробка масиву даних найменувань товарів
        String namesOutput = dataHandlerString.handleData(provider.getProductNames());
        getOutput("Products: " + namesOutput);

        // Обробка масиву даних про суми продажів
        String salesOutput = dataHandlerDouble.handleData(provider.getSalesAmounts());
        getOutput("Sales, EUR: " + salesOutput);
    }

    // Виведення результату роботи програми
    private static void getOutput(String output) {
        System.out.println(output);
    }
}