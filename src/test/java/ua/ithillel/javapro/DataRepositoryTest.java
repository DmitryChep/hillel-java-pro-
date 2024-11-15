package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataRepositoryTest {
    DataRepository dataRepository;

    @BeforeEach
    void setUp() {
        dataRepository = new DataRepository();
    }

    @Test
    void getData_ShouldReturnData() {
        assertNotNull(dataRepository.getData());
    }
}