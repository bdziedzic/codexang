package com.codexabra.coop.service.impl;

import com.codexabra.coop.dao.InstructorRepository;
import com.codexabra.coop.entity.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InstructorSrvImpl{

    private InstructorRepository instructorRepository;

    public InstructorSrvImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> findAll(){
        return instructorRepository.findAll();
    }

    public Optional<List<Instructor>> getAllBySex(char sex) {
        Optional<List<Instructor>> instructors = instructorRepository.findAllBySex(sex);
        if (instructors.isPresent()){
            return instructors;
        }
        return null;
        }

    public Instructor getById(int id) throws RuntimeException{
        return instructorRepository.findById(id).
                orElseThrow(() -> new RuntimeException("No data about single instructor!"));

    }

}
