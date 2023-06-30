package com.wildcodeschool.wildapero.repository;

import com.wildcodeschool.wildapero.model.Apero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// JDBC > ORM Hibernate
@Repository
public class AperoRepository implements CrudDAO<Apero, Long> {

    List<Apero> aperoList = new ArrayList<>();

    public AperoRepository() {
        aperoList.add(new Apero(0L, "Blue lagoon", List.of("Curacao", "Vodka", "Citron vert")));
        aperoList.add(new Apero(1L, "Whiskey sour", List.of("Whiskey", "Citron", "Citron vert", "Glace pilée")));
        aperoList.add(new Apero(2L, "Planteur", List.of("Rhum", "Jus de fruits exotiques")));
    }

    @Override
    public List<Apero> findAll() {
        return this.aperoList;
    }

    @Override
    public Optional<Apero> findById(Long id) {
        Apero aperoFound = null;
        for (var apero : aperoList) {
            if (apero.getId().equals(id)) {
                aperoFound = apero;
                break;
            }
        }
        if (aperoFound == null) {
            return Optional.empty();
        }
        return Optional.of(aperoFound);
    }

    @Override
    public Apero save(Apero aperoDetails) {
        if (aperoDetails.getId() != null) {
            aperoDetails.setId((long) this.aperoList.size());
            this.aperoList.add(aperoDetails);
            return aperoDetails;
        } else {
            Optional<Apero> optionalApero = this.findById(aperoDetails.getId());
            if (optionalApero.isPresent()) {
                Apero aperoToUpdate = optionalApero.get();
                if (aperoDetails.getName() != null) {
                    aperoToUpdate.setName(aperoDetails.getName());
                }
                if (aperoDetails.getIngredients() != null) {
                    aperoToUpdate.setIngredients(aperoDetails.getIngredients());
                }
                return aperoToUpdate;
            } else {
                return null;
            }
        }
    }

    @Override
    public void deleteById(Long id) {
        Optional<Apero> optionalApero = this.findById(id);
        if (optionalApero.isPresent()) {
            this.aperoList.remove(id.intValue());
        } else {
            // TODO: throw exception
        }
    }
}
