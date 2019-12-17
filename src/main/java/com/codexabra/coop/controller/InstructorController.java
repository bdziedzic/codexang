package com.codexabra.coop.controller;


import com.codexabra.coop.entity.Instructor;
import com.codexabra.coop.service.impl.InstructorSrvImpl;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Getter
public class InstructorController {

    private InstructorSrvImpl instructorSrv;

    public InstructorController(InstructorSrvImpl instructorSrv) {
        this.instructorSrv = instructorSrv;
    }

    @GetMapping("/instructors")
    public List<Instructor> getAll(Model model) {
        List<Instructor> instructors = instructorSrv.findAll();
        model.addAttribute("instructors", instructors);
        for (Instructor instructor : instructors){
            System.out.println(instructor.getFirstName());
        }
        return instructors;
    }

    @GetMapping(value = "/instructors", params = "id")
    public String getOne(@RequestParam("id") int id, Model model){
        Instructor instructor = instructorSrv.getById(id);
        model.addAttribute("instructor", instructor);
        return "/";
    }



    }



