/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.repositories;

import guru.springframework.model.UnitOfMeasure;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author msulbara
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    // Spring Data Query Methods
    // findBy<PropertyName> spring creara el query por debajo
    // se pueden buscar varias con And
    Optional<UnitOfMeasure> findByDescription(String description);
}
