package com.uu.bookingservice.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.uu.bookingservice.dto.BookingDTO;
import com.uu.bookingservice.interfaces.BookingRepository;
import com.uu.bookingservice.interfaces.LabClient;
import com.uu.bookingservice.interfaces.ProfessorClient;
import com.uu.bookingservice.models.Booking;

import jakarta.transaction.Transactional;

@Service
@EnableScheduling
@Transactional
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ProfessorClient professorClient;

    @Autowired
    LabClient labClient;

    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }

    public void update(Booking booking) {
        bookingRepository.update(booking);
    }

    public ResponseEntity<String> approve(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);

        if (isBusy(booking)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This lab is busy between " +
                    booking.get().getTimeInit() + " and " + booking.get().getTimeFinal());
        } else {
            bookingRepository.approve(id);
            return ResponseEntity.ok("Approved.");
        }
    }

    @Async
    @Scheduled(fixedDelay = 60000)
    void deleteByTimeFinalBefore() {
        bookingRepository.deleteByTimeFinalBefore(LocalDateTime.now());
    }

    public List<BookingDTO> findByProfessor(Long id) {
        List<Booking> bookings = bookingRepository.findByProfessor(id);
        return createBookingDTO(bookings);
    }

    public List<BookingDTO> findPending() {
        List<Booking> bookings = bookingRepository.findPending();
        return createBookingDTO(bookings);
    }

    public List<BookingDTO> findApproved() {
        List<Booking> bookings = bookingRepository.findApproved();
        return createBookingDTO(bookings);
    }

    public List<BookingDTO> findAll() {
        List<Booking> bookings = bookingRepository.findAll();
        return createBookingDTO(bookings);
    }

    public List<BookingDTO> findById(Long id) {
        List<Booking> bookings = new ArrayList<>();
        bookings.add(bookingRepository.findById(id).get());
        return createBookingDTO(bookings);
    }

    public boolean isBusy(Optional<Booking> booking) {
        return booking.map(b -> {
            int count = bookingRepository.isBusy(b.getLabId(), b.getTimeInit(), b.getTimeFinal());
            return count > 0;
        }).orElse(false);
    }

    private List<BookingDTO> createBookingDTO(List<Booking> bookings) {
        List<BookingDTO> bookingsDTO = new ArrayList<>();

        for (Booking booking : bookings) {
            Map<String, Object> professor = professorClient.find(booking.getProfessorId());
            Map<String, Object> lab = labClient.find(booking.getLabId());
            Map<String, Object> subject = professorClient.findSubject(booking.getSubjectId());
        
            professor.remove("subjects");
        
            BookingDTO bookingDTO = new BookingDTO(booking, professor, lab, subject);
            bookingsDTO.add(bookingDTO);
        }
        
        return bookingsDTO;
    }
}
