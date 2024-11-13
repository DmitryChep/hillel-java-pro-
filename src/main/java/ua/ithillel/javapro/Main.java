package ua.ithillel.javapro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] numbers = new DataRepository().getData();
        DataHandler dataHandler = new DataHandler();
        ArrayList<Callable<Integer>> tasks = new ArrayList<>();
        for (int number : numbers) {
            tasks.add(() -> number);
            tasks.add(() -> dataHandler.modify(number));
            tasks.add(() -> dataHandler.increment(number));
            tasks.add(() -> dataHandler.increment(dataHandler.modify(number)));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(numbers.length);
        List<Future<Integer>> result = executorService.invokeAll(tasks);

        Iterator<Future<Integer>> iterator = result.iterator();
        while (iterator.hasNext()) {

            Future<Integer> nextInitialValue = iterator.next();
            if (nextInitialValue.isDone()) {
                System.out.println("Initial value is " + nextInitialValue.get());
                iterator.remove();
            }

            Future<Integer> nextNewValue = iterator.next();
            if (nextNewValue.isDone()) {
                System.out.println("New value is " + nextNewValue.get());
                iterator.remove();
            }

            Future<Integer> nextIncrementInitialValue = iterator.next();
            if (nextIncrementInitialValue.isDone()) {
                System.out.println("Increment initial value is " + nextIncrementInitialValue.get());
                iterator.remove();
            }

            Future<Integer> nextIncrementNewValue = iterator.next();
            if (nextIncrementNewValue.isDone()) {
                System.out.println("Increment new value is " + nextIncrementNewValue.get() + "\n________________________");
                iterator.remove();
            }
        }
        executorService.shutdown();
    }
}
