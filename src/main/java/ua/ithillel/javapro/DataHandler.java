package ua.ithillel.javapro;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {
    public String formMapOutput(Map<Integer, String> map) {
        if (!map.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            AtomicInteger count = new AtomicInteger(0);
            map.forEach((id, name) -> stringBuilder.append(String.format("%d) %d, %s%n", count.incrementAndGet(), id, name)));
            return "ALL NAMES:\n" + stringBuilder;
        } else return "Map is empty";
    }

    public String getValueByKey(Map<Integer, String> map, int id) {
        if (map.containsKey(id)) {
            return String.format("NAME: id %d, %s", id, map.get(id));
        } else return "Key not found";
    }
}