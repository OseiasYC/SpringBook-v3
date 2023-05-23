package com.uu.bookingservice.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uu.bookingservice.models.Professor;
import com.uu.bookingservice.models.Subject;

@FeignClient(name = "professor-service", url = "http://localhost:8081")
public interface ProfessorClient {

    @GetMapping("/professor/{id}")
    Professor find(@PathVariable Long id);

    @GetMapping("/subject/{id}")
    Subject findSubject(@PathVariable Long id);
}
