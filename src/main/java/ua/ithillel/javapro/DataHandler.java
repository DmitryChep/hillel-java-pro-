package ua.ithillel.javapro;

import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {

    String[] fruits = new DataRepository().getData();

    public void getOutput() {
        // критичний блок коду
        synch (this) {
            StringBuilder sb = new StringBuilder();
            count = new AtomicInteger(1);
            for (String fruit : fruits) {
                sb.append(String.format("(%d) %s ",
                        count, fruit));
            }
            System.out.println(currentThread().getName() + ": " + sb);
        }
    }
}


