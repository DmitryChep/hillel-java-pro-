package ua.ithillel.javapro;

public class Converter {
    private final double MILE = 1.609344;
    private double kilometers;
    private double miles;

    public double getKilometers() {
        return kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public double convertMilesToKilometers(double kilometers) {
        return  kilometers * MILE;
    }

    public double convertKilometersToMiles(double miles ) {
        return  miles / MILE;
    }
}


