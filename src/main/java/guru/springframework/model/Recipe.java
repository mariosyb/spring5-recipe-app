/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author msulbara
 */
@Getter
@Setter
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob
    private String directions;

    @Lob
    private Byte[] image;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category", // creando una tabla confunta para la relacion
            joinColumns = @JoinColumn(name = "recipe_id"), // RECIPE/CATEGORIA
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);  // relaciona el ingrediente con su recipe
        this.ingredients.add(ingredient);
        return this;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this); // relaciona notas con su Recipe, relacion bidireccional
    }

}
