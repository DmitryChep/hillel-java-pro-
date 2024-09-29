package ua.ithillel.javapro;

public class Main {
    private static final double CONV_K = 2.20462;

    public static void main(String[] args) {
        System.out.println("Converter App.");
        System.out.println("App for measures converting.");

        double kgs = 10;
        double pounds = convKgsToPounds(kgs);
        System.out.println("Result is " + pounds + " pounds.");

    }

    private static double convKgsToPounds(double kgs){
        return  kgs * CONV_K;
    }
}