package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ByteIOFileHandlerTest {
        private ByteIOFileHandler byteIOFileHandler;
        private final String TEST_FILE_PATH = "files/testfile.txt";
        private final String TEST_FILE_CONTENT = "This is a test text. ";

        @BeforeEach
        void setUp() {
            byteIOFileHandler = new ByteIOFileHandler();
            new File(TEST_FILE_PATH);
        }

    @Test
    void writeFileByBytes_shouldWriteFileContentByBytes_whenPathAndFileContentIsRight() throws IOException {
        Files.writeString(Path.of(TEST_FILE_PATH), ""); //Delete previous record for FileOutputStream append: true
        String result = byteIOFileHandler.writeFile(TEST_FILE_PATH, TEST_FILE_CONTENT);
        String fileContent = Files.readString(Path.of(TEST_FILE_PATH));

        assertEquals(TEST_FILE_CONTENT, fileContent);
        assertEquals("Success.", result);
    }

    @Test
    void readFileByBytes_shouldReadFileByBytes_whenPathIsRight() throws IOException {
        Files.writeString(Path.of(TEST_FILE_PATH), TEST_FILE_CONTENT); //custom method isn't used for independent tests
        String result = byteIOFileHandler.readFile(TEST_FILE_PATH);

        assertEquals(TEST_FILE_CONTENT, result);
    }
}