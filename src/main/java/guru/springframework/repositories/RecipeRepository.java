/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.repositories;

import guru.springframework.model.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author msulbara
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
