package com.codexabra.coop.controller;


import com.codexabra.coop.entity.Course;
import com.codexabra.coop.service.impl.CourseSrvImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    private CourseSrvImpl courseSrv;

    public CourseController(CourseSrvImpl courseSrv) {
        this.courseSrv = courseSrv;
    }

    @GetMapping(value = "/courses")
    public Map<String, List<Course>> getCoursesByDays(){
        return courseSrv.getCoursesByDays();
    }

    @GetMapping(value = "/courses/course")
    public Course getCourse(@RequestParam("id") int id){
        return courseSrv.getOne(id);
    }


}

