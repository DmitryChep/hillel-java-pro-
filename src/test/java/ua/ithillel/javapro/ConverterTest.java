package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTest {
    private Converter converter;

    @BeforeEach
    void setUp(){
        converter = new Converter();
        converter.setFahrenheit(50);
        converter.setCelsius(10);
    }

    @Test
    void convertMilesToKilometers() {
        assertEquals(10 , converter.convertFahrenheitToCelsius(converter.getFahrenheit()));
    }

    @Test
    void convertKilometersToMiles() {
        assertEquals( 50,  converter.convertCelsiusToFahrenheit(converter.getCelsius()));
    }
}
