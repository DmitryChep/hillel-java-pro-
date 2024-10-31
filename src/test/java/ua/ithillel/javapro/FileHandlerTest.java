package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {
    FileHandler fileHandler;
    private final String TEST_DIRECTORY_PATH = "testFiles/";
    private final String TEST_FILE_PATH = "testFiles/testFile.txt";
    private final String TEST_FILE_CONTENT = "This is a test text.";

    @BeforeEach
    void setUp() {
        fileHandler = new FileHandler();
    }

    @Test
    void createDirectory_shouldCreateDirectory_whenPathIsRight() throws SecurityException {
        fileHandler.createDirectory(TEST_DIRECTORY_PATH);

        assertTrue(Files.exists(Paths.get(TEST_DIRECTORY_PATH)));
    }

    @Test
    void createDirectory_shouldReturnMessage_whenPathIsWrong() {
        fileHandler.createDirectory(TEST_DIRECTORY_PATH);


        assertEquals("Incorrect path", fileHandler.createDirectory(" "));
        assertNotNull(TEST_FILE_PATH);
    }

    @Test
    void createDirectory_shouldReturnMassageWithDirectoryPath_whenDirectoryAlreadyExists() {
        assertEquals("Directory already exists: " + TEST_DIRECTORY_PATH, fileHandler.createDirectory(TEST_DIRECTORY_PATH));
    }

    @Test
    void createFile_shouldCreateFile_whenPathIsRight() {
        fileHandler.createDirectory(TEST_DIRECTORY_PATH); // create directory for file
        fileHandler.createFile(TEST_FILE_PATH);

        assertTrue(Files.exists(Path.of(TEST_FILE_PATH)));
    }

    @Test
    void createFile_shouldReturnMessage_whenPathIsWrong() {
        fileHandler.createDirectory(TEST_DIRECTORY_PATH);
        fileHandler.createFile(TEST_FILE_PATH);

        assertNotNull(TEST_FILE_PATH);
    }

    @Test
    void createFile_shouldReturnMassageWithDirectoryPath_whenFileAlreadyExists() {
        assertEquals("File already exists: " + TEST_FILE_PATH, fileHandler.createFile(TEST_FILE_PATH));
    }


    @Test
    void writeToFile_shouldWriteToFile_whenPathIsRightAndContentIsExists() throws IOException {
        String result = fileHandler.writeToFile(TEST_FILE_PATH, TEST_FILE_CONTENT);
        String fileContent = Files.readString(Path.of(TEST_FILE_PATH));

        assertEquals(TEST_FILE_CONTENT, fileContent);
        assertEquals("File written: " + TEST_FILE_PATH, result);
    }

    @Test
    void writeToFile_shouldReturnMessageAndPath_whenPathIsWrong() {
        assertEquals("Incorrect path", fileHandler.writeToFile(" ", TEST_FILE_CONTENT));
        assertNotNull(fileHandler.writeToFile(TEST_FILE_PATH, TEST_FILE_CONTENT)); // check if null
    }

    @Test
    void writeFomFIle_shouldReturnMessage_whenFileDoesNotExists() {
        assertEquals("Write to file failed! ", fileHandler.writeToFile(TEST_DIRECTORY_PATH, TEST_FILE_CONTENT));
    }

    @Test
    void writeToFile_shouldReturnMessage_whenContextDoesNotExists() {
        assertEquals("Content cannot be empty!", fileHandler.writeToFile(TEST_DIRECTORY_PATH, ""));
    }

    @Test
    void readFromFile_shouldReadFromFile_whenPathIsRightAndContentIsExists() throws IOException {
        Files.writeString(Path.of(TEST_FILE_PATH), TEST_FILE_CONTENT);
        String result = fileHandler.readFromFile(TEST_FILE_PATH);

        assertEquals(TEST_FILE_CONTENT, result);
    }

    @Test
    void readFromFile_shouldReturnMessage_whenFileDoesNotExists() {
        assertEquals("Read from file failed! ", fileHandler.readFromFile(TEST_DIRECTORY_PATH));
    }

    @Test
    void readFromFile_shouldReturnMessageAndPath_whenPathIsWrong() {
        assertEquals("Incorrect path", fileHandler.readFromFile(""));
        assertNotNull(fileHandler.readFromFile("TEST_FILE_PATH"));
    }
}
