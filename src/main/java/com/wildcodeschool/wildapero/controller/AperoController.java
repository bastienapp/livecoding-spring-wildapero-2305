package com.wildcodeschool.wildapero.controller;

import com.wildcodeschool.wildapero.entity.Apero;
import com.wildcodeschool.wildapero.repository.AperoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
            @PathVariable Long id
    ) {
        return this.aperoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{nameValue}")
    public Apero getByName(@PathVariable("nameValue") String name) {
        return this.aperoRepository
                .findAperoByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/containing/{nameValue}")
    public List<Apero> getByNameContaining(@PathVariable("nameValue") String name) {
        return this.aperoRepository
                .findAperosByNameContaining(name);
    }

    @PostMapping("")
    public Apero create(@RequestBody Apero newApero) {
        return this.aperoRepository.save(newApero);
    }

    // rechercher avec PATCH
    @PutMapping("")
    public Apero update(@RequestBody Apero aperoInfos) {
        return this.aperoRepository.save(aperoInfos);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.aperoRepository.deleteById(id);
    }
}
