package ua.ithillel.javapro;

public interface IOStreamer {
     String writeFile(String filePath, String fileContent) ;
     String readFile(String filePath);
}