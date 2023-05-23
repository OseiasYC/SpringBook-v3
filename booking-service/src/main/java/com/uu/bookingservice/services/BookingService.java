package com.uu.bookingservice.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.uu.bookingservice.interfaces.BookingRepository;
import com.uu.bookingservice.models.Booking;

import jakarta.transaction.Transactional;

@Service
@EnableScheduling
@Transactional
public class BookingService {
    
    @Autowired
    BookingRepository bookingRepository;

    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    public ResponseEntity<String> approve(Long id){
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

    public List<Booking> findByProfessor(Long id){
        return bookingRepository.findByProfessor(id);
    }

    public List<Booking> findPending() {
        return bookingRepository.findPending();
    }

    public List<Booking> findApproved() {
        return bookingRepository.findApproved();
    }

    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }

    public Booking findById(Long id){
        return bookingRepository.findById(id).get();
    }

    public boolean isBusy(Optional<Booking> booking) {
        return booking.map(b -> {
            int count = bookingRepository.isBusy(b.getLab().getId(), b.getTimeInit(), b.getTimeFinal());
            return count > 0;
        }).orElse(false);
    }
}