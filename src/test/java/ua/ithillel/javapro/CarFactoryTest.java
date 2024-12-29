package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {
    private CarFactory carFactory;

    @BeforeEach
    void setUp() {
        carFactory = new CarFactory();
    }

    @Test
    void createTransport() {
        carFactory.createTransport();
        assertInstanceOf(Car.class, carFactory.createTransport());
    }
}