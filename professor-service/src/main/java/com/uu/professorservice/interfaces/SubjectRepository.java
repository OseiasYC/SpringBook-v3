package com.uu.professorservice.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uu.professorservice.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{
    
}
