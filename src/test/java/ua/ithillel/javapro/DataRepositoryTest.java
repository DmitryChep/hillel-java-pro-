package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DataRepositoryTest {
    private DataRepository dataRepository;

    @BeforeEach
    void setUp() {
        dataRepository = new DataRepository();
    }

    @Test
    void getData() {
        assertNotNull(dataRepository.getData());
    }
}