package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerTest {
    private DataHandler dataHandler;
    private Map<Integer, String> map;


    @BeforeEach
    void setUp() {
        dataHandler = new DataHandler();
        map = new HashMap<>();
    }

    @Test
    void formatMapOutput_shouldReturnValueByIndex_whenMapHasElementsAndIndexCorrect() {
        map.put(321, "John");

        assertEquals("ALL NAMES:\n1) 321, John\n", dataHandler.formMapOutput(map));
    }

    @Test
    void formatMapOutput_shouldReturnMessage_whenMapIsEmpty() {
        assertEquals("Map is empty", dataHandler.formMapOutput(map));
    }

    @Test
    void getValueByKey_shouldReturnElementsForOutput_whenMapContainsKey() {
        map.put(321, "John");
        assertEquals("ALL NAMES:\n1) 321, John\n", dataHandler.formMapOutput(map));
    }

    @Test
    void getValueByKey_shouldReturnMessage_whenMapDoesNotContainKey() {
        map.put(321, "John");
        assertEquals("Key not found", dataHandler.getValueByKey(map, -1), "Key not found");
    }
}
