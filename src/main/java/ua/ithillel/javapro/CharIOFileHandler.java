package ua.ithillel.javapro;

import java.io.*;

public class CharIOFileHandler implements IOStreamer {
    @Override
    public String writeFile(String filePath, String fileContent) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(fileContent);
            return "Success.";
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    public String readFile(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            int symbol;
            StringBuilder stringBuilder = new StringBuilder();
            while ((symbol = reader.read()) != -1) {
                stringBuilder.append((char) symbol);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }


}

