import java.io.*;

public class Complaint implements Serializable {
    private String name;
    private String address;
    private String phoneNumber;
    private String complain;
    private String location;
    private String dateTime;

    public Complaint(String name, String address, String phoneNumber, String complain, String location, String dateTime) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.complain = complain;
        this.location = location;
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getComplain() {
        return complain;
    }

    public String getLocation() {
        return location;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String toString() {
        return name + " - " + address + " - " + phoneNumber + " - " + complain + " - " + location + " - " + dateTime;
    }
}

