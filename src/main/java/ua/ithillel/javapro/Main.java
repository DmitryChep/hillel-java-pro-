package ua.ithillel.javapro;

import java.nio.file.Path;

public class Main {

    private static final String BASE_PATH = "files/";

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        String content = "Yeah! It's working.";
        String fileName = "myFile";
        String path = BASE_PATH + fileName + ".txt";
        getOutput(fileHandler.createDirectory(BASE_PATH));
        getOutput(fileHandler.createFile(path));
        getOutput(fileHandler.writeToFile(path, content));
        getOutput("Content: " + fileHandler.readFromFile(path));
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}