package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharIOFileHandlerTest {
    private CharIOFileHandler fileHandler;
    private final String TEST_FILE_PATH = "files/testfile.txt";
    private final String TEST_FILE_CONTENT = "This is a test text. ";

    @BeforeEach
    void setUp() {
        fileHandler = new CharIOFileHandler();
        new File(TEST_FILE_PATH);
    }

    @Test
    void writeFile_shouldWriteFileContent_whenPathAndFileContentIsRight() throws IOException {
        String result = fileHandler.writeFile(TEST_FILE_PATH, TEST_FILE_CONTENT);
        String fileContent = Files.readString(Path.of(TEST_FILE_PATH));

        assertEquals(TEST_FILE_CONTENT, fileContent);
        assertEquals("Success.", result);
    }

    @Test
    void readFile_shouldReadFile_whenPathIsRight() throws IOException {
        Files.writeString(Path.of(TEST_FILE_PATH), TEST_FILE_CONTENT); //custom method isn't used for independent tests
        String result = fileHandler.readFile(TEST_FILE_PATH);


        assertEquals(TEST_FILE_CONTENT, result);
    }
}