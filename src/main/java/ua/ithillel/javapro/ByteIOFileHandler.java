package ua.ithillel.javapro;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ByteIOFileHandler implements IOStreamer {
    @Override
    public String writeFile(String filePath, String fileContent) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath, true)) {
            fileOutputStream.write(fileContent.getBytes(StandardCharsets.UTF_8));
            return "Success.";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String readFile(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            InputStreamReader inputStream = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            int symbol;
            StringBuilder stringBuilder = new StringBuilder();
            while ((symbol = inputStream.read()) != -1) {
                stringBuilder.append((char) symbol);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
