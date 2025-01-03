package ua.ithillel.javapro;

import lombok.Data;

@Data
public class Address {
    private int buildingNumber;
    private String street;
    private String city;
    private String postCode;
    private String country;
}
