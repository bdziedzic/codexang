package com.codexabra.coop.dao;

import com.codexabra.coop.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

        Optional<List<Instructor>> findAllBySex(char sex) throws  RuntimeException;
    }
