package com.uu.bookingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uu.bookingservice.models.Booking;
import com.uu.bookingservice.services.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;
    
    @PostMapping("/save")
    public void save(@RequestBody Booking booking){
        bookingService.save(booking);
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<String> approve(@PathVariable Long id){
        return bookingService.approve(id);
    }

    @GetMapping("/findAll")
    public List<Booking> findAll() {
        return bookingService.findAll();
    }

    @GetMapping("/findByProfessor/{id}")
    public List<Booking> findByProfessor(@PathVariable Long id){
        return bookingService.findByProfessor(id);
    }
}
