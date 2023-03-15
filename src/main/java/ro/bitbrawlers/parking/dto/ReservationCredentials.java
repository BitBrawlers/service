package ro.bitbrawlers.parking.dto;
public class ReservationCredentials {
    String firstName;
    String lastName;
    String licensePlate;

    public ReservationCredentials() {
    }

    public ReservationCredentials(String firstName, String lastName, String licensePlate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.licensePlate = licensePlate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}