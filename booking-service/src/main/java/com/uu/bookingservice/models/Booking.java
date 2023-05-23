package com.uu.bookingservice.models;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "lab_id")
    private Lab lab;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean approved;

    private LocalDateTime timeInit;

    private LocalDateTime timeFinal;

    @CreationTimestamp
    private LocalDateTime timeRequest;
}
