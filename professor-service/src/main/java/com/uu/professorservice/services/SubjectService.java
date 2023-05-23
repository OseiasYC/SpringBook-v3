package com.uu.professorservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uu.professorservice.interfaces.SubjectRepository;
import com.uu.professorservice.models.Subject;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SubjectService {
    
    @Autowired
    SubjectRepository subjectRepository;

    public void save(Subject subject){
        subjectRepository.save(subject);
    }

    public void deleteById(Long id){
        subjectRepository.deleteRelated(id);
        subjectRepository.deleteById(id);
    }

    public List<Subject> findAll(){
        return subjectRepository.findAll();
    }

    public Subject findById(Long id){
        return subjectRepository.findById(id).get();
    }

    public List<Subject> findSubjectsByProfessorId(Long id) {
        return subjectRepository.findSubjectsByProfessorId(id);
    }

    public void update(Subject subject) {
        subjectRepository.update(subject);
    }
}
