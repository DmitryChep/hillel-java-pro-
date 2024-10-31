package ua.ithillel.javapro;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileHandler {
    public String createDirectory(String path) {
        if (path == null || path.trim().isEmpty()) {
            return "Incorrect path";
        }
        try {
            if (Files.exists(Path.of(path))) { // Check if the directory exists, if not, create it
                return ("Directory already exists: " + path);
            } else {
                File file = new File(path);
                file.mkdir();
                return "Directory created: " + path;
            }
        } catch (SecurityException e) {
            return "Directory not accessible!" + e.getMessage();
        }
    }


    public String createFile(String path) {
        if (path == null || path.trim().isEmpty()) {
            return "Incorrect path";
        }
        Path newFile;
        try {
            newFile = Files.createFile(Path.of(path));
            return "Created file: " + newFile;
        } catch (FileAlreadyExistsException e) {
            return "File already exists: " + path;
        } catch (IOException e) {
            return "File cannot be created!";
        }
    }

    public String writeToFile(String path, String content) {
        if (path == null || path.trim().isEmpty()) {
            return "Incorrect path";
        } else if (content == null || content.isEmpty()) {
            return "Content cannot be empty!";
        }
        try {
            Files.writeString(Path.of(path), content);
            return "File written: " + path;
        } catch (IOException e) {
            return "Write to file failed! ";
        }
    }

    public String readFromFile(String path) {
        if (path == null || path.trim().isEmpty()) {
            return "Incorrect path";
        } else if (!Files.exists(Path.of(path))) {
            return ("File exists: " + path);
        }
        try {
            return Files.readString(Path.of(path));
        }catch (IOException e) {
            return "Read from file failed! ";
        }
    }
}