package ua.ithillel.javapro;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UiOperatorTest {
    private static PrintStream old;
    private ByteArrayOutputStream output;

    @BeforeEach
    public void setUpStreams() {
        old = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));// swapping the console output stream for your own
    }

    @AfterEach
    void cleanUpStreams() {
        System.setOut(old);
    }

    @Test
    public void testString() {
        UiOperator uiOperator = new UiOperator();
        uiOperator.getOutput("test");
        assertEquals("test\n", output.toString());
    }
}