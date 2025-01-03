package ua.ithillel.javapro;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
public class User {
    private int id;
    private String name;
    private String surname;
    @Getter
    private Address address;

    public void setAddress(int buildingNumber, String street, String city, String postCode, String country) {
        address.setBuildingNumber(buildingNumber);
        address.setStreet(street);
        address.setCity(city);
        address.setPostCode(postCode);
        address.setCountry(country);
    }
}

