package ua.ithillel.javapro;

public class Main {

    private final static String BASE_PATH = "files/";

    public static void main(String[] args) {
        IOStreamer charIOFileHandler = new CharIOFileHandler();
        IOStreamer byteIOFileHandler = new ByteIOFileHandler();

        // content for writing to file. both type of IO streams
        String fileContent = "I can write and read in English!";
        String fileContentByBytes = " Og også på norsk!"; // "And also in Norwegian!"

        // create path for file
        String fileName = "myfile";
        String filePath = BASE_PATH + fileName + ".txt";

        // character type IO
        String writeFileResult = charIOFileHandler.writeFile(filePath, fileContent);
        String readFileContent = charIOFileHandler.readFile(filePath);

        // byte type IO
        String writeFileResultByBytes = byteIOFileHandler.writeFile(filePath, fileContentByBytes);
        String readFileContentByBytes = byteIOFileHandler.readFile(filePath);

        getOutput(String.format("RESULT: %s\nFILE CONTENT: %s\nRESULT IN BYTES: %s \nFILE CONTENT: %s ",
                writeFileResult, readFileContent, writeFileResultByBytes, readFileContentByBytes));
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}

