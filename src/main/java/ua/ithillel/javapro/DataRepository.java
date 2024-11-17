package ua.ithillel.javapro;

import java.util.HashMap;
import java.util.Map;

public class DataRepository {
    public Map<Integer, String> getData(){
        Map<Integer, String> map = new HashMap<>();
        map.put(123, "Lucy");
        map.put(234, "Alice");
        map.put(345, "Bob");
        map.put(456, "Tom");
        return map;
    }
}




