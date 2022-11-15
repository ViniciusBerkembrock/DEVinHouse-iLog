package tech.devinhouse.m01s06exercicio03a06.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.m01s06exercicio03a06.services.TutorService;
import tech.devinhouse.m01s06exercicio03a06.models.Tutor;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "tutor")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping
    public List<Tutor> get() {
        return tutorService.findAll();
    }

    @PostMapping
    public Tutor post(@RequestBody Tutor tutor) {
        return tutorService.save(tutor);
    }

    @PutMapping
    public Tutor put(@RequestBody Tutor tutor) {
        return tutorService.save(tutor);
    }

    @DeleteMapping
    public boolean delete(Integer id) {
        return tutorService.delete(id);
    }
}