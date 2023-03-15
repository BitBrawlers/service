package ro.bitbrawlers.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.bitbrawlers.parking.data.ReservationRepository;
import ro.bitbrawlers.parking.dto.ReservationCredentials;
import ro.bitbrawlers.parking.entity.ParkingSpot;
import ro.bitbrawlers.parking.data.ParkingSpotRepository;
import ro.bitbrawlers.parking.dto.CountDto;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingSpotService {
    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ParkingSpot> findBy() {
        return parkingSpotRepository.findAll();
    }

    public Optional<ParkingSpot> findById(Integer id) {
        return parkingSpotRepository.findById(id);
    }
    public CountDto countSpots() {
        return new CountDto(parkingSpotRepository.countByReservationNull(), parkingSpotRepository.countBy());
    }

    public int deleteReservation (String licensePlate) {
        int updatedRows=parkingSpotRepository.emptyParkingSpot(licensePlate);
        parkingSpotRepository.deleteReservation(licensePlate);
        return updatedRows;
    }

    public String addReservation (ReservationCredentials reservationCredentials) {
        if(parkingSpotRepository.countByReservationNull() == 0)
            return "Parking is already full.";

        else if(parkingSpotRepository.countByReservationNull() > 0 && reservationRepository.countByLicensePlate(reservationCredentials.getLicensePlate()) > 0)
            return "There is already a car with the given license plate.";

        else {
            parkingSpotRepository.addReservation(reservationCredentials.getFirstName(), reservationCredentials.getLastName(), reservationCredentials.getLicensePlate());
            parkingSpotRepository.updateParkingSpotRow(reservationCredentials.getLicensePlate());
            return "The reservation was made successfully.";
        }
    }



}
