package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerTest {
    private DataHandler dataHandler;
    private DataRepository dataRepository;
    private ArrayList<Callable<Integer>> tasks;


    @BeforeEach
    void setUp() {
        dataHandler = new DataHandler();
        dataRepository = new DataRepository();
        tasks = new ArrayList<>();
    }

    @Test
    void modify_shouldModifyData_whenDataDoesNotZero() throws Exception {
        for (int number : dataRepository.getData()) {
            tasks.add(() -> number);
            tasks.add(() -> dataHandler.modify(number));
        }
        assertEquals(7, tasks.getFirst().call().byteValue());
        assertEquals(6, tasks.getLast().call().byteValue());
    }

    @Test
    void modify_shouldModifyData_whenDataIsZero()  {
        assertThrows(IllegalArgumentException.class, () -> dataHandler.modify(0));
    }


    @Test
    void increment_shouldIncrementData_whenDataExist() throws Exception {
        for (int number : dataRepository.getData()) {
            tasks.add(() -> dataHandler.increment(number));
        }
        assertEquals(8, tasks.getFirst().call().byteValue());
    }
}