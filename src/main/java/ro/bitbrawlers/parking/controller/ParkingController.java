package ro.bitbrawlers.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import ro.bitbrawlers.parking.entity.ParkingSpot;
import ro.bitbrawlers.parking.dto.CountDto;
import ro.bitbrawlers.parking.service.ParkingSpotService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller
public class ParkingController {

    @Autowired
    private ParkingSpotService parkingSpotService;

    /*
    @GetMapping("/spots")
    @ResponseBody
    public List<ParkingSpot> findAll() {
        return parkingSpotService.findAll();
    }


    */

    @GetMapping("/count")
    @ResponseBody
    public CountDto countByReservationNull(){
        return parkingSpotService.countSpots();
    }

    @GetMapping("/spots")
    @ResponseBody
    public List<ParkingSpot> findBy(){
        return parkingSpotService.findBy();
    }

    @GetMapping("/spots/{id}")
    @ResponseBody
    public Optional<ParkingSpot> findById(@PathVariable Integer id) {
        return parkingSpotService.findById(id);
    }

    @GetMapping("/delete-reservation/{licensePlate}")
    @ResponseBody
    public String deleteReservation(@PathVariable String licensePlate) {
        int updatedRows=parkingSpotService.deleteReservation(licensePlate);
        if(updatedRows > 0)
            return String.format("The reservation for %s was removed successfully.", licensePlate);
        else
            return String.format("There is no reservation for %s.", licensePlate);

    }
}
