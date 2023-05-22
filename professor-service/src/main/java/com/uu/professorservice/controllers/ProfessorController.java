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

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        professorService.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<Professor> findAll(){
        return professorService.findAll();
    }

    @GetMapping("/get/{id}")
    public Professor get(@PathVariable Long id){
        return professorService.findById(id);
    }
}
