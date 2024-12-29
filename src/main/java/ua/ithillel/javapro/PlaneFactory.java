package ua.ithillel.javapro;

public class PlaneFactory extends TransportFactory {
    @Override
    public Transport createTransport() {
        return new Plane();
    }
}
