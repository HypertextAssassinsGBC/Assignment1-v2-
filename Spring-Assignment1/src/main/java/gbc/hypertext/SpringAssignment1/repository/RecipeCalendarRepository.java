/*********************************************************************************
 * Project: HypertextAssassinsGBC
 * Assignment: Assignment #1
 * Author(s): Duncan Wardlaw, Oliver Kmiec, Paolo Tous
 * Student Number: 101247506, 101247765, 101325245
 * Date: November 7th, 2021
 * Description: persists recipe entity's to the db
 *********************************************************************************/

package gbc.hypertext.SpringAssignment1.repository;

import gbc.hypertext.SpringAssignment1.model.RecipeCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeCalendarRepository extends JpaRepository<RecipeCalendar, Long> {

}