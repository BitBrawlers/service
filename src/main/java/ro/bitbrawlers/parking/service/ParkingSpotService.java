package ro.bitbrawlers.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.bitbrawlers.parking.entity.ParkingSpot;
import ro.bitbrawlers.parking.data.ParkingSpotRepository;
import ro.bitbrawlers.parking.dto.CountDto;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingSpotService {
    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    /*public List<ParkingSpot> findAll() {
        return parkingSpotRepository.findAll();
    }

    public ParkingSpot findSpotById(Integer id) {
        return parkingSpotRepository.findSpotById(id);
    }
    public CountDto countSpots() {
        return new CountDto(parkingSpotRepository.countEmptySpots(), parkingSpotRepository.totalSpots());
    }
    */
    public List<ParkingSpot> findBy() {
        //return parkingSpotRepository.findBy();
        return parkingSpotRepository.findAll();
    }

    public Optional<ParkingSpot> findById(Integer id) {
        //return parkingSpotRepository.findBy();
        return parkingSpotRepository.findById(id);
    }
    public CountDto countSpots() {
        return new CountDto(parkingSpotRepository.countByReservationNull(), parkingSpotRepository.countBy());
    }


}
