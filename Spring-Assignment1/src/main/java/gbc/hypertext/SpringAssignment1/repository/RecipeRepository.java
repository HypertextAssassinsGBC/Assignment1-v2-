/*********************************************************************************
 * Project: HypertextAssassinsGBC
 * Assignment: Assignment #1
 * Author(s): Duncan Wardlaw, Oliver Kmiec, Paolo Tous
 * Student Number: 101247506, 101247765, 101325245
 * Date: November 7th, 2021
 * Description: persists recipe entity's to the db
 *********************************************************************************/

package gbc.hypertext.SpringAssignment1.repository;

import gbc.hypertext.SpringAssignment1.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{



    public List<Recipe> findAllByIngredientsLikeIgnoreCase(String keyword);

}
