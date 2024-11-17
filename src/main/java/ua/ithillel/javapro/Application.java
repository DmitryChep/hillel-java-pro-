package ua.ithillel.javapro;

public class Application {
    public static void main(String[] args) {
        DataHandler handler = new DataHandler();
        UIOperator uiOperator = new UIOperator();
        DataRepository dataRepository = new DataRepository();
        uiOperator.getOutput(handler.formMapOutput(dataRepository.getData()));
        uiOperator.getOutput(handler.getValueByKey(dataRepository.getData(), 345));
    }
}




