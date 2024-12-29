package ua.ithillel.javapro;

public class Client {
    public static void run(String transportType) {
        switch (transportType.toLowerCase()) {
            case "car":
                new CarFactory().createTransport().move();
                break;
            case "plane":
                new PlaneFactory().createTransport().move();
                break;
            default:
                throw new IllegalStateException("Unexpected transport type: " + transportType.toLowerCase());
        }
    }
}
