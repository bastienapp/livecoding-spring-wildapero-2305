package com.wildcodeschool.wildapero.controller;

import com.wildcodeschool.wildapero.model.Apero;
import com.wildcodeschool.wildapero.repository.AperoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // on crée un API : tout renvoi du JSON, on ne précise plus @ResponseBody
@RequestMapping("/api/aperos")
@CrossOrigin("http://localhost:4200") // CORS policies
public class AperoController {

    private AperoRepository aperoRepository;

    AperoController(AperoRepository aperoRepositoryInjected) {
        this.aperoRepository = aperoRepositoryInjected;
    }

    @GetMapping("")
    public List<Apero> getAll() {
        return this.aperoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Apero getById(
            // @RequestParam Integer id // query param
            @PathVariable Integer id
    ) {
        return null;
    }

    @PostMapping("")
    public Apero create(@RequestBody Apero newApero) {
        return null;
    }

    // rechercher avec PATCH
    @PutMapping("/{id}")
    public Apero update(
            @PathVariable Integer id,
            @RequestBody Apero aperoInfos
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

    }
}
