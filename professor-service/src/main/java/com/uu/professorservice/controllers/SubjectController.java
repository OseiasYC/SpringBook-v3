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

import com.uu.professorservice.models.Subject;
import com.uu.professorservice.services.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    
    @Autowired
    SubjectService subjectService;

    @PostMapping("/save")
    public void save(@RequestBody Subject subject) {
        subjectService.save(subject);
    }

    @PutMapping("/update")
    public void update(@RequestBody Subject subject){
        subjectService.update(subject);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        subjectService.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<Subject> findAll(){
        return subjectService.findAll();
    }

    @GetMapping("/findSubjectsByProfessor/{id}")
    public List<Subject> findSubjectsByProfessorId(@PathVariable Long id){
        return subjectService.findSubjectsByProfessorId(id);
    }

    @GetMapping("/{id}")
    public Subject find(@PathVariable long id){
        return subjectService.findById(id);
    }
}
