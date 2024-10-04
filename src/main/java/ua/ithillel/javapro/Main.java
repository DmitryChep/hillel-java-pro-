package ua.ithillel.javapro;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Customer customer = getCustomer(getData());
        String output = """ 
                            Customer: %s
                            Phone: %s
                            Date and time: %s
                            Class name: %s"""
                .formatted(customer.getName(), customer.getPhone(), getDateTime(new Date()), customer.getClass());
        getOutput(output);
    }

    public static String getDateTime(Date date){
        SimpleDateFormat dateTime = new SimpleDateFormat("d MMMM yyyy, H:mm", Locale.US);
        return dateTime.format(date);
    }

    public static String[] getData() {
        return new String[]{"Tom", "+491724235530"};
    }

    public static Customer getCustomer(String[] data) {
        return new Customer(data[0], data[1]);
    }

    public static void getOutput(String output) {
        System.out.print(output);
    }
}