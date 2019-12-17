package com.codexabra.coop.dao;

import com.codexabra.coop.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findAllByDay(String day);

    Course findById(int id);
}
