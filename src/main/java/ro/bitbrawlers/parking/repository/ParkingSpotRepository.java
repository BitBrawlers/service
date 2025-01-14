package ro.bitbrawlers.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.bitbrawlers.parking.entity.ParkingSpot;

import javax.transaction.Transactional;


@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer> {
    Integer countByReservationNull(); //count empty spots

    Integer countBy();



    @Transactional
    @Modifying
    @Query(value="update parkingSpot\n" +
            "\tset reservationId=null where reservationId = \n" +
            "\t(select id  from reservation where licensePlate = ?1);", nativeQuery = true)
    Integer emptyParkingSpot (String licensePlate);

    @Transactional
    @Modifying
    @Query(value="delete from reservation where licensePlate= ?1", nativeQuery=true)
    void deleteReservation (String licensePlate);

    @Transactional
    @Modifying
    @Query(value="insert into reservation(firstName, lastName, licensePlate) values(?1, ?2, ?3)", nativeQuery = true )
    void addReservation(String firstName, String lastName, String licensePlate);

    @Transactional
    @Modifying
    @Query(value="update parkingSpot set reservationID = (select reservation.id from reservation where licensePlate=?1) where parkingSpot.id = (select id from parkingSpot where parkingSpot.reservationID is null limit 1)", nativeQuery = true )
    void updateParkingSpotRow (String licensePlate);
}