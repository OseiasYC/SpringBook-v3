package com.uu.bookingservice.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long professorId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long labId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long subjectId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean approved;

    private LocalDateTime timeInit;

    private LocalDateTime timeFinal;

    @CreationTimestamp
    private LocalDateTime timeRequest;
}
