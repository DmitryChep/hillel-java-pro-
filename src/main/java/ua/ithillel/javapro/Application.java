package ua.ithillel.javapro;

public class Application {
    public static void main(String[] args) {
        DataRepository dataRepository = new DataRepository();
        DataHandler dataHandler = new DataHandler();
        UiOperator uiOperator = new UiOperator();
        uiOperator.getOutput(dataHandler.formListOutput(dataRepository.getData()));
        uiOperator.getOutput(dataHandler.getValueByIndex(dataRepository.getData(), 2));
    }
}