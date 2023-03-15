package ro.bitbrawlers.parking.data;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.bitbrawlers.parking.entity.ParkingSpot;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer> {
    Integer countByReservationNull(); //count empty spots

    Integer countBy();



    @Transactional
    @Modifying
    @Query(value="update parkingSpot\n" +
            "\tset reservationId=null where reservationId = \n" +
            "\t(select id  from reservation where licensePlate = ?1);", nativeQuery = true)
    int emptyParkingSpot (String licensePlate);

    @Transactional
    @Modifying
    @Query(value="delete from reservation where licensePlate= ?1", nativeQuery=true)
    void deleteReservation (String licensePlate);
}