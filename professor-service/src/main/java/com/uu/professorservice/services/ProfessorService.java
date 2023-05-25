package com.uu.professorservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uu.professorservice.interfaces.ProfessorRepository;
import com.uu.professorservice.interfaces.SubjectRepository;
import com.uu.professorservice.models.Professor;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired 
    SubjectRepository subjectRepository;

    public void save(Professor professor) {
        professorRepository.save(professor);
    }

    public void update(Professor newProfessor){
        Professor oldProfessor = professorRepository.findById(newProfessor.getId()).get();
        List<Long> subjectsId = new ArrayList<>();

        professorRepository.save(newProfessor);

        for (int i = 0; i < newProfessor.getSubjects().size(); i++) {
            subjectsId.add(subjectRepository.findById(newProfessor.getSubjects().get(i).getId()).get().getId());
        }

        for (int i = 0; i < oldProfessor.getSubjects().size(); i++) {
            professorRepository.removeProfessorSubject(oldProfessor.getId(), oldProfessor.getSubjects().get(i).getId());;
        }

        for (Long id : subjectsId) {
            professorRepository.insertProfessorSubject(newProfessor.getId(), id);
        }
    }

    public void deleteById(Long id){
        professorRepository.deleteById(id);
    }

    public Professor findById(Long id){
        return professorRepository.findById(id).get();
    }

    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

    public void removeProfessorSubject(Long professorId, Long subjectId) {
        professorRepository.removeProfessorSubject(professorId, subjectId);
    }

    public void insertProfessorSubject(Long professorId, Long subjectId) {
        professorRepository.insertProfessorSubject(professorId, subjectId);
    }
}