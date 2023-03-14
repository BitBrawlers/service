package ro.bitbrawlers.parking.data;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.bitbrawlers.parking.entity.ParkingSpot;

import java.util.List;


@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer> {

    /*
    @Query()
    List<ParkingSpot> findAll();


    @Query(value = "")
    ParkingSpot findSpotById (Integer id);

    @Query(value = "")
    Integer totalSpots();

    @Query(value = "")
    Integer countEmptySpots();
    //Integer countByReservation();

    //Integer countByReservationNull();


     */
    //@Query(value = "select count(*) from parkingSpot where reservationID is null ",nativeQuery = true)

    //List<ParkingSpot> findAll();
    Integer countByReservationNull(); //count empty spots

    Integer countBy();

}