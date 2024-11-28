package ua.ithillel.javapro;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(new Product("Jabra Evolve 75", "Headphones", 250.0),
                new Product("Google Pixel 8 Pro", "Phone", 850.0),
                new Product("MacBook Pro", "Laptop", 4000.0),
                new Product("Iphone 15 Pro ", "Phone", 1300.0),
                new Product("Lenovo ThinkPad ", "Laptop", 2000.0),
                new Product("DELL UltraSharp ", "Monitor", 3000.0),
                new Product("Apple AirPods Pro", "Headphones", 200.0),
                new Product("HP E27m G4 ", "Monitor", 450.0));

        // Group by category
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::category));


        // Find the average price by category
        Map<String, Double> averagePriceByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::category, Collectors.averagingDouble(Product::price)));

        //Print the category with the average price
        productsByCategory.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(System.out::println);
            if (averagePriceByCategory.containsKey(key)) {
                System.out.println("Average price: " + averagePriceByCategory.get(key));
            }
            System.out.println();
        });

        // Find the category with the highest average price
        Optional<Map.Entry<String, Double>> maxAveragePriceOfCategory = averagePriceByCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        maxAveragePriceOfCategory.ifPresent(p -> System.out.printf("The category with the highest average price: %s %s \n", p.getKey(), p.getValue()));
    }
}



