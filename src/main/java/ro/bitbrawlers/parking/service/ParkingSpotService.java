package ro.bitbrawlers.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.bitbrawlers.parking.repository.ReservationRepository;
import ro.bitbrawlers.parking.dto.ReservationCredentialsDTO;
import ro.bitbrawlers.parking.entity.ParkingSpot;
import ro.bitbrawlers.parking.repository.ParkingSpotRepository;
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

    public Integer deleteReservation (String licensePlate) {
        int updatedRows=parkingSpotRepository.emptyParkingSpot(licensePlate);
        parkingSpotRepository.deleteReservation(licensePlate);
        return updatedRows;
    }

    /*public ReservationCredentialsDTO addReservation (ReservationCredentialsDTO reservationCredentialsDTO) {
        return reservationCredentialsDTO;

    }*/

}
