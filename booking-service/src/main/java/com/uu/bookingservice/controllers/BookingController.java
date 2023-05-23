package com.uu.bookingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uu.bookingservice.dto.BookingDTO;
import com.uu.bookingservice.models.Booking;
import com.uu.bookingservice.services.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;
    
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Booking booking){
        return bookingService.save(booking);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        bookingService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Booking booking) {
        bookingService.update(booking);
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<String> approve(@PathVariable Long id){
        return bookingService.approve(id);
    }

    @GetMapping("/findAll")
    public List<BookingDTO> findAll() {
        return bookingService.findAll();
    }

    @GetMapping("/{id}")
    public List<BookingDTO> findById(@PathVariable Long id) {
        return bookingService.findById(id);
    }

    @GetMapping("/findPending")
    public List<BookingDTO> findPending() {
        return bookingService.findPending();
    }

    @GetMapping("/findApproved")
    public List<BookingDTO> findApproved(){
        return bookingService.findApproved();
    }

    @GetMapping("/findByProfessor/{id}")
    public List<BookingDTO> findByProfessor(@PathVariable Long id){
        return bookingService.findByProfessor(id);
    }
}
