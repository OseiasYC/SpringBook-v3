package com.uu.bookingservice.dto;

import java.util.Map;

import com.uu.bookingservice.models.Booking;

public record BookingDTO(Booking booking, Map<String, Object> professor, Map<String, Object> lab, Map<String, Object> subject) {
}
