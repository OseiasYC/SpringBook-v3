package com.uu.bookingservice.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Lab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lami;

    private String description;

    private boolean status;

    private int desktops;

    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "lab", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings = new ArrayList<>();
}
