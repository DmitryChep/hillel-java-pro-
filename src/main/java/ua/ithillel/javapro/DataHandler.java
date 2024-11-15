package ua.ithillel.javapro;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {
    public String formListOutput(List<String> list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        StringBuilder stringBuilder = new StringBuilder();
        AtomicInteger counter = new AtomicInteger(1);
        try {
            int index = 0;
            for (String name : list) {
                if (list.get(index) == null) {
                    throw new NullPointerException("Element is null in index " + index);
                }
                stringBuilder.append(String.format("%d) %s%n", counter.getAndIncrement(), name));
                index++;
            }
            return "Names:\n" + stringBuilder;
        } catch (NullPointerException e) {
            return (e.getMessage());
        }
    }

    public String getValueByIndex(List<String> list, int index) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        try {
            if (list.get(index) == null) {
                throw new NullPointerException("Element is null in index " + index);
            }
            String name = list.get(index);
            return String.format("Name: %s is in index %d", name, index);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return (e.getMessage());
        }
    }
}
