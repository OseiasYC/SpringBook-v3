package com.uu.bookingservice.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uu.bookingservice.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT * FROM booking WHERE approved = false", nativeQuery = true)
    List<Booking> findPending();

    @Query(value = "SELECT * FROM booking WHERE approved = true", nativeQuery = true)
    List<Booking> findApproved();

    @Query(value = "SELECT * FROM booking WHERE professor_id = ?1", nativeQuery = true)
    List<Booking> findByProfessor(Long id);

    @Query(value = "SELECT COUNT(*) FROM booking b WHERE b.lab_id = ?1 AND ((b.time_init <= ?2 AND b.time_final >= ?2) OR (b.time_init <= ?3 AND b.time_final >= ?3)) AND b.approved = true", nativeQuery = true)
    int isBusy(Long lab, LocalDateTime timeInit, LocalDateTime timeFinal);

    @Query(value = "SELECT * FROM booking WHERE lab_id = ?1", nativeQuery = true)
    List<Booking> findBookingsByLabId(Long id);

    @Modifying
    @Query(value = "UPDATE booking SET professor_id = :#{#booking.professorId}, subject_id = :#{#booking.subjectId}, lab_id = :#{#booking.labId}, time_init = :#{#booking.timeInit}, time_final = :#{#booking.timeFinal}", nativeQuery = true)
    void update(@Param("booking") Booking booking);

    @Modifying
    @Query(value = "UPDATE booking SET approved = true WHERE id = ?1", nativeQuery = true)
    void approve(Long id);

    @Modifying
    @Query(value = "DELETE FROM booking WHERE time_final < ?1", nativeQuery = true)
    void deleteByTimeFinalBefore(LocalDateTime now);
}
