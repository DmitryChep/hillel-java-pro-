package ua.ithillel.javapro.exception;

public class DatabaseOperationException extends Exception {
    public DatabaseOperationException(String message) {
        super(message);
    }
    public DatabaseOperationException(Throwable cause) {
        super(cause);
    }
}
