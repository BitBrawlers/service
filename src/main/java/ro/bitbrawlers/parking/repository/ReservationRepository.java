package ro.bitbrawlers.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.bitbrawlers.parking.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query(value="select count(*) from reservation where licensePlate = ?1", nativeQuery=true)
    Integer countByLicensePlate (String licensePlate);
}
