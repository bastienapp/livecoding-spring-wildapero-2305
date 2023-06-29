package com.wildcodeschool.wildapero.controller;

import com.wildcodeschool.wildapero.model.Apero;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController // on crée un API : tout renvoi du JSON, on ne précise plus @ResponseBody
@RequestMapping("/api/aperos")
@CrossOrigin("http://localhost:4200") // CORS policies
public class AperoController {

    List<Apero> aperoList = new ArrayList<>();

    public AperoController() {
        aperoList.add(new Apero(0L, "Blue lagoon", List.of("Curacao", "Vodka", "Citron vert")));
        aperoList.add(new Apero(1L, "Whiskey sour", List.of("Whiskey", "Citron", "Citron vert", "Glace pilée")));
        aperoList.add(new Apero(2L, "Planteur", List.of("Rhum", "Jus de fruits exotiques")));
    }

    @GetMapping("")
    public List<Apero> getAll() {
        return aperoList;
    }

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

    @PostMapping("")
    public Apero create(@RequestBody Apero newApero) {
        newApero.setId((long) this.aperoList.size());
        this.aperoList.add(newApero);

        return newApero;
    }

    // rechercher avec PATCH
    @PutMapping("/{id}")
    public Apero update(
            @PathVariable Integer id,
            @RequestBody Apero aperoInfos
    ) {
        // récupérer l'apéritif existant grâce à son identifiant
        Apero aperoToUpdate = this.aperoList.get(id);

        // modifier les infos nécessaire dans l'apéro d'origine
        if (aperoInfos.getName() != null) {
            aperoToUpdate.setName(aperoInfos.getName());
        }
        if (aperoInfos.getIngredients() != null) {
            aperoToUpdate.setIngredients(aperoInfos.getIngredients());
        }

        // enregistrer les modifications

        // retourne l'apero modifié
        return aperoToUpdate;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if (id < 0 || id >= aperoList.size()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.aperoList.remove((int) id);
    }
}
