package ro.bitbrawlers.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ro.bitbrawlers.parking.dto.ReservationCredentialsDto;
import ro.bitbrawlers.parking.entity.ParkingSpot;
import ro.bitbrawlers.parking.dto.CountDto;
import ro.bitbrawlers.parking.repository.ParkingSpotRepository;
import ro.bitbrawlers.parking.repository.ReservationRepository;
import ro.bitbrawlers.parking.service.ParkingSpotService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller
public class ParkingController {

    @Autowired
    private ParkingSpotService parkingSpotService;

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/count")
    @ResponseBody
    public CountDto countSpots(){
        return parkingSpotService.countSpots();
    }

    @GetMapping("/spots")
    @ResponseBody
    public List<ParkingSpot> findAll(){
        return parkingSpotService.findAll();
    }

    @GetMapping("/spots/{id}")
    public ResponseEntity<Optional<ParkingSpot>> findById(@PathVariable Integer id) {
        Optional<ParkingSpot> parkingSpot = parkingSpotService.findById(id);
        if(!parkingSpot.isPresent())
            return new ResponseEntity<>(parkingSpot,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(parkingSpot,HttpStatus.OK);
    }

    @DeleteMapping("/delete-reservation/{licensePlate}")
    public ResponseEntity<String> deleteReservation(@PathVariable String licensePlate) {
        int updatedRows=parkingSpotService.deleteReservation(licensePlate);
        if(updatedRows > 0)
            return new ResponseEntity<>(String.format("The reservation for %s was removed successfully.", licensePlate), HttpStatus.OK);
        else
            return new ResponseEntity<>(String.format("There is no reservation for %s.", licensePlate),HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add-reservation")
    public ResponseEntity<String> addReservation(@RequestBody ReservationCredentialsDto reservationCredentialsDto) {
        if(parkingSpotRepository.countByReservationNull() == 0)
            return new ResponseEntity<>("Parking is already full.",HttpStatus.BAD_REQUEST);

        else if(parkingSpotRepository.countByReservationNull() > 0 && reservationRepository.countByLicensePlate(reservationCredentialsDto.getLicensePlate()) > 0)
            return new ResponseEntity<>(String.format("There is already a car with the license plate %s.", reservationCredentialsDto.getLicensePlate()),HttpStatus.BAD_REQUEST);

        else {
            parkingSpotRepository.addReservation(reservationCredentialsDto.getFirstName(), reservationCredentialsDto.getLastName(), reservationCredentialsDto.getLicensePlate());
            parkingSpotRepository.updateParkingSpotRow(reservationCredentialsDto.getLicensePlate());
            return new ResponseEntity<>(String.format("The reservation for the car with the license plate %s was made successfully.", reservationCredentialsDto.getLicensePlate()),HttpStatus.OK);
        }
    }
}
