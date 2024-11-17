package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class DataRepositoryTest {
    DataRepository dataRepository;

    @BeforeEach
    void setUp() {
        dataRepository = new DataRepository();
    }

    @Test
    void getData_shouldReturnData() {
        Map<Integer, String> map = dataRepository.getData();
        map.put(1, "test");
    }
}