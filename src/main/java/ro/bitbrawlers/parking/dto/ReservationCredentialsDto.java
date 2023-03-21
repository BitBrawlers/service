package ro.bitbrawlers.parking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationCredentialsDto {
    private String firstName;
    private String lastName;
    private String licensePlate;
}
