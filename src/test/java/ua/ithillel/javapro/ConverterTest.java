package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTest {
    private Converter converter;

    @BeforeEach
    void setUp(){
        converter = new Converter();
        converter.setMiles(10);
        converter.setKilometers(10);
    }

    @Test
    void convertMilesToKilometers() {
        assertEquals( 16.09344,  converter.convertMilesToKilometers(converter.getMiles()));
    }

    @Test
    void convertKilometersToMiles() {
        assertEquals( 6.2137119223733395,  converter.convertKilometersToMiles(converter.getKilometers()));
    }
}
