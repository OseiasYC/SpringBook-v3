package com.uu.bookingservice.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uu.bookingservice.models.Lab;

@FeignClient(name = "lab-service", url = "http://localhost:8082")
public interface LabClient {
    
    @GetMapping("/lab/{id}")
    Lab find(@PathVariable Long id);
}
