package com.uu.bookingservice.interfaces;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "professor-service", url = "http://localhost:8081")
public interface ProfessorClient {

    @GetMapping("/professor/{id}")
    Map<String, Object> find(@PathVariable Long id);

    @GetMapping("/subject/{id}")
    Map<String, Object> findSubject(@PathVariable Long id);
}
