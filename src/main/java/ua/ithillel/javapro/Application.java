package ua.ithillel.javapro;

public class Application {

    public static void main(String[] args) {
        Logger.getInstance().info("Application started");
        Logger.getInstance().debug("Debug info ");
        Logger.getInstance().info("Application ended");
        Logger.getInstance().showLogs();

        // creates only one instance of the logger class
        System.out.println(Logger.getInstance().toString());
        System.out.println(Logger.getInstance().toString());
        System.out.println(Logger.getInstance().toString());
    }
}
