package gbc.hypertext.SpringAssignment1.repository;

import gbc.hypertext.SpringAssignment1.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{
    Set<Recipe> findByIngredients(String[] ingredients);
}
