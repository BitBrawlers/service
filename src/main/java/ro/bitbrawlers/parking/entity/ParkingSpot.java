package ro.bitbrawlers.parking.entity;

import javax.persistence.*;

@Entity()
@Table(name = "parkingSpot")
public class ParkingSpot {
    @Id
    @Column
    public Integer id;

    @OneToOne
    @JoinColumn(name = "reservationID",referencedColumnName = "id")
    public Reservation reservation;

    public ParkingSpot() {
    }

    public ParkingSpot(Integer id, Reservation reservation) {
        this.id = id;
        this.reservation = reservation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

}
