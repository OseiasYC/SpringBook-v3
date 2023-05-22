package com.uu.labservice.controllers;

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

import com.uu.labservice.models.Lab;
import com.uu.labservice.services.LabService;

@RestController
@RequestMapping("/lab")
public class LabController {
    
    @Autowired
    LabService labService;

    @PostMapping("/save")
    public void save(@RequestBody Lab lab) {
        labService.save(lab);
    }

    @PutMapping("/update")
    public void update(@RequestBody Lab lab){
        labService.update(lab);
    }

    @PutMapping("/updateStatus/{lab_id}/{status}")
    public void updateStatus(@PathVariable("lab_id") Long labId, @PathVariable("status") boolean status){
        labService.updateStatus(labId, status);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        labService.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<Lab> findAll(){
        return labService.findAll();
    }

    @GetMapping("/{id}")
    public Lab find(@PathVariable Long id){
        return labService.findById(id);
    }
}