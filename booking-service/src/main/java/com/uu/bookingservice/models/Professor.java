package com.uu.bookingservice.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    private List<Booking> bookings;

    @ManyToMany
    @JoinTable(name = "professor_subject", 
    joinColumns = @JoinColumn(name = "professor_id"), 
    inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects;
}
