package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerTest {
    private DataHandler dataHandler;
    private DataRepository dataRepository;

    @BeforeEach
    void setUp() {
        dataHandler = new DataHandler();
        dataRepository = new DataRepository();
    }

    @Test
    void modify() {
     assertEquals(21, dataHandler.modify(dataRepository.getData()[0]));

    }
}