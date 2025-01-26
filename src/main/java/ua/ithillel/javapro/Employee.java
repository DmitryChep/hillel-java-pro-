package ua.ithillel.javapro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String name = "";
    private int age = 1;
    private String position = "";
    private double salary = 0.0;
}
