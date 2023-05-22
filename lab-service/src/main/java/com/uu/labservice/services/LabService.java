package com.uu.labservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uu.labservice.interfaces.LabRepository;
import com.uu.labservice.models.Lab;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LabService {
    
    @Autowired
    LabRepository labRepository;

    public void save(Lab lab){
        labRepository.save(lab);
    }

    public void update(Lab lab){
        labRepository.update(lab);
    }

    public void updateStatus(Long labId, boolean status){
        labRepository.updateStatus(labId, status);
    }

    public void deleteById(Long id){
        labRepository.deleteById(id);
    }

    public List<Lab> findAll(){
        return labRepository.findAll();
    }

    public Lab findById(Long id){
        return labRepository.findById(id).get();
    }
}
