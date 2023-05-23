package com.uu.bookingservice.interfaces;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "lab-service", url = "http://localhost:8082")
public interface LabClient {
    
    @GetMapping("/lab/{id}")
    Map<String, Object> find(@PathVariable Long id);
}
