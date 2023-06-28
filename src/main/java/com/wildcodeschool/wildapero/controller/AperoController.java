package com.wildcodeschool.wildapero.controller;

import com.wildcodeschool.wildapero.model.Apero;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController // on crée un API : tout renvoi du JSON, on ne précise plus @ResponseBody
@RequestMapping("/api/aperos")
@CrossOrigin("http://localhost:4200")
public class AperoController {

    List<Apero> aperoList;

    public AperoController() {
        aperoList = List.of(
                new Apero(0L, "Blue lagoon", List.of("Curacao", "Vodka", "Citron vert")),
                new Apero(1L, "Whiskey sour", List.of("Whiskey", "Citron", "Citron vert", "Glace pilée")),
                new Apero(2L, "Planteur", List.of("Rhum", "Jus de fruits exotiques"))
        );
    }

    // READ ALL - GET
    @GetMapping("")
    public List<Apero> getAll() {
        return aperoList;
    }

    // READ ONE - GET
    @GetMapping("/{id}")
    public Apero getById(
            // @RequestParam Integer id // query param
            @PathVariable Integer id
    ) {
        if (id < 0 || id >= aperoList.size()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return aperoList.get(id);
    }

    // CREATE - POST

    // UPDATE - PUT/PATCH

    // DELETE - DELETE
}
