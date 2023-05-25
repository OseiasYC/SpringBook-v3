package com.uu.bookingservice.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.uu.bookingservice.models.Booking;

@Service
public class LogService {
    
    private static final Logger log = LogManager.getLogger(LogService.class);

    public void deletedPending(Booking booking) {
        log.info("Pending removed: {}", booking.toString());
    }

    public void deletedApproved(Booking booking) {
        log.info("Approved removed: {}", booking.toString());
    }
    
    public void insertedPending(Booking booking) {
        log.info("Pending inserted: {}", booking.toString());
    }

    public void insertedApproved(Booking booking) {
        log.info("Approved inserted: {}", booking.toString());
    }

    public void updatedPending(Booking booking) {
        log.info("Pending updated: {}", booking.toString());
    }

    public void updatedApproved(Booking booking) {
        log.info("Approved updated: {}", booking.toString());
    }
}
