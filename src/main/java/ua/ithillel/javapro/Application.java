package ua.ithillel.javapro;

public class Application {
    public static void main(String[] args) {
        Address address = new Address();
        User user = User.builder()
                .id(1)
                .name("John")
                .surname("Doe")
                .address(address)
                .build();

        user.setAddress(45, "Thomas Road", "London", "E14 7AP", "UK");
        System.out.println(user.getAddress());
    }
}
