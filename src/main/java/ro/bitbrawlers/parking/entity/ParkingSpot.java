package ro.bitbrawlers.parking.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parkingSpot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpot {
    @Id
    @Column
    public Integer id;

    @OneToOne
    @JoinColumn(name = "reservationID",referencedColumnName = "id")
    public Reservation reservation;

}
