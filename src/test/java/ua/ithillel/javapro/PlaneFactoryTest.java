package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneFactoryTest {
    private PlaneFactory planeFactory;

    @BeforeEach
    void setUp() {
        planeFactory = new PlaneFactory();
    }

    @Test
    void createTransport() {
        planeFactory.createTransport();
        assertInstanceOf(Plane.class, planeFactory.createTransport());
    }
}