package com.codexabra.coop.service.impl;

import com.codexabra.coop.dao.CourseRepository;
import com.codexabra.coop.entity.Course;
import com.sun.xml.bind.v2.schemagen.xmlschema.LocalAttribute;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CourseSrvImpl {

    private CourseRepository courseRepository;

    public CourseSrvImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public static final DayOfWeek[] DAY_OF_WEEKS = DayOfWeek.values();

    public Course getOne(int id) {
        return courseRepository.getOne(id);
    }

    private List<Course> findAllByDay(DayOfWeek day) {
        return courseRepository.findAllByDay(day.name());
    }



    public Map<String, List<Course>> getCoursesByDays() {
        Map<String, List<Course>> coursesPerDayMap = new HashMap<>();
        for (DayOfWeek day : DayOfWeek.values()) {
            addToMap(coursesPerDayMap,day);
        }
        return coursesPerDayMap;
    }

    private void addToMap(Map<String, List<Course>> coursesPerDayMap, DayOfWeek day) {
        if(this.findAllByDay(day) != null){
            coursesPerDayMap.put(day.name(), courseRepository.findAllByDay(day.name()));
        }
    }
}
