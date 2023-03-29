package ro.bitbrawlers.parking.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReservationCredentialsDtoTest  {
    ReservationCredentialsDto reservationCredentialsDto = new ReservationCredentialsDto("Marian", "Halasag", "GL23VHA");
    ReservationCredentialsDto reservationCredentialsDtoEmpty = new ReservationCredentialsDto();

    @Test
    void fistName() {
        Assertions.assertEquals("Marian", reservationCredentialsDto.getFirstName());
    }

    @Test
    void lastName() {
        Assertions.assertEquals("Halasag", reservationCredentialsDto.getLastName());
    }

    @Test
    void licensePlate() {
        Assertions.assertEquals("GL23VHA", reservationCredentialsDto.getLicensePlate());
    }
    @Test
    void firstNameSetter() {
        reservationCredentialsDtoEmpty.setFirstName("Paul");
        Assertions.assertEquals("Paul", reservationCredentialsDtoEmpty.getFirstName());
    }
    @Test
    void lastNameSetter() {
        reservationCredentialsDtoEmpty.setLastName("Perju");
        Assertions.assertEquals("Perju", reservationCredentialsDtoEmpty.getLastName());
    }

    @Test
    void licensePlateSetter() {
        reservationCredentialsDtoEmpty.setLicensePlate("B18PPU");
        Assertions.assertEquals("B18PPU", reservationCredentialsDtoEmpty.getLicensePlate());
    }
}
