package com.uu.professorservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uu.professorservice.models.Professor;
import com.uu.professorservice.services.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    
    @Autowired
    ProfessorService professorService;

    @PostMapping("/save")
    public void save(@RequestBody Professor professor){
        professorService.save(professor);
    }

    @PutMapping("/update")
    public void update(@RequestBody Professor professor){
        professorService.update(professor);
    }

    @PutMapping("/insert/{professor_id}/{subject_id}")
    public void insertProfessorSubject(@PathVariable("professor_id") Long professorId, @PathVariable("subject_id")Long subjectId){
        professorService.insertProfessorSubject(professorId, subjectId);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        professorService.deleteById(id);
    }

    @DeleteMapping("/delete/{professor_id}/{subject_id}")
    public void removeProfessorSubject(@PathVariable("professor_id") Long professorId, @PathVariable("subject_id")Long subjectId){
        professorService.removeProfessorSubject(professorId, subjectId);
    }

    @GetMapping("/findAll")
    public List<Professor> findAll(){
        return professorService.findAll();
    }

    @GetMapping("/{id}")
    public Professor find(@PathVariable Long id){
        return professorService.findById(id);
    }
}
