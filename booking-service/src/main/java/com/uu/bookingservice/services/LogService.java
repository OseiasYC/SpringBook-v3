package com.uu.bookingservice.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.uu.bookingservice.models.Booking;

@Service
public class LogService {
    
    private static final Logger log = LogManager.getLogger(LogService.class);

    public void deletedPending(Booking booking) {
        log.info("Pending deleted: {}", booking.toString());
    }

    public void deletedApproved(Booking booking) {
        log.info("Approved deleted: {}", booking.toString());
    }
    
    public void Pending(Booking booking) {
        log.info("Pending added: {}", booking.toString());
    }

    public void Approved(Booking booking) {
        log.info("Approved added: {}", booking.toString());
    }

    public void updatedPending(Booking booking) {
        log.info("Pending updated: {}", booking.toString());
    }

    public void updatedApproved(Booking booking) {
        log.info("Approved updated: {}", booking.toString());
    }
}
