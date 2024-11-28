package ua.ithillel.javapro;

public record Product(String name, String category, double price) {
    @Override
    public String toString() {
        return
                "name = \"" + name + "\"" +
                        ", category = " + category + " " +
                        ", price = " + price;
    }
}

