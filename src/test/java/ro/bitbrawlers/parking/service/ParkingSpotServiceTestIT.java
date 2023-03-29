package ro.bitbrawlers.parking.service;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.bitbrawlers.parking.dto.CountDto;
import ro.bitbrawlers.parking.entity.ParkingSpot;
import ro.bitbrawlers.parking.repository.ParkingSpotRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Tag("IT")
public class ParkingSpotServiceTestIT {

    @Autowired
    ParkingSpotRepository parkingSpotRepository;

    @Autowired
    ParkingSpotService parkingSpotService;

    @Test
    public void test_countSpots_returnsCountDto(){
        CountDto countDto=parkingSpotService.countSpots();

        assertEquals((Integer) 3, countDto.getEmptySpotCount());
        assertEquals((Integer) 8, countDto.getTotalSpotCount());
    }

    @Test
    public void test_findById_returnsEmpty() {
        CountDto countDto = parkingSpotService.countSpots();
        Integer id = countDto.getTotalSpotCount() + 1;
        assertEquals(Optional.empty(), parkingSpotService.findById(id));
    }


}
