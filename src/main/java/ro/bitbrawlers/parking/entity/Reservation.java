package ro.bitbrawlers.parking.entity;


import javax.persistence.*;

@Entity()
@Table(name = "reservation")
public class Reservation {
    @Id
    @Column
    public Integer id;

    @Column
    public String firstName;

    @Column
    public String lastName;

    @Column
    public String licensePlate;

    public Reservation() {
    }

    public Reservation(Integer id, String firstName, String lastName, String licensePlate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.licensePlate = licensePlate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
