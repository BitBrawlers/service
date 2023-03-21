package ro.bitbrawlers.parking.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
