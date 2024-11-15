package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerTest {
    private DataHandler dataHandler;
    private List<String> list;

    @BeforeEach
    void setUp() {
        dataHandler = new DataHandler();
        list = new ArrayList<>();
    }

    @Test
    void getValueByIndex_shouldReturnValueByIndex_whenListHasElementsAndIndexCorrect() {
        list.add("John");
        assertEquals("Name: John is in index 0", dataHandler.getValueByIndex(list, 0));
    }

    @Test
    void getValueByIndex_shouldThrowNoSuchElementException_whenListIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> dataHandler.getValueByIndex(list, 1), "List is empty");
    }

    @Test
    void getValueByIndex_shouldPrintErrorMessage_whenValueIsNull() {
        list.add(null);
        int index = 0;
        assertEquals("Element is null in index 0", dataHandler.getValueByIndex(list, index));

    }

    @Test
    void getValueByIndex_shouldPrintErrorMessage_whenIndexOutOfBounds() {
        list.add("John");
        String expected = String.format("Index %d out of bounds for length %d", 2, list.size());
        assertEquals(expected, dataHandler.getValueByIndex(list, 2));
    }

    @Test
    void formatListOutput_shouldReturnElementsForOutput_whenListHasElement() {
        list.add("John");
        assertEquals("Names:\n1) John\n", dataHandler.formListOutput(list));
    }

    @Test
    void formatListOutput_shouldThrowNoSuchElementException_whenListIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> dataHandler.formListOutput(list), "List is empty");

    }

    @Test
    void formatListOutput_shouldPrintErrorMessage_whenValueIsNull() {
        list.add(null);
        int index = 0;
        assertEquals("Element is null in index " + index, dataHandler.getValueByIndex(list, index));
    }
}