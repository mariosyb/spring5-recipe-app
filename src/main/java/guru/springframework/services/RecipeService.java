/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.services;

import guru.springframework.model.Recipe;

import java.util.Set;

/**
 * @author msulbara
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);
}
