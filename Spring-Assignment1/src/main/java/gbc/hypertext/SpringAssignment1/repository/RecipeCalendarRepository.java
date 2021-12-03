package gbc.hypertext.SpringAssignment1.repository;

import gbc.hypertext.SpringAssignment1.model.RecipeCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeCalendarRepository extends JpaRepository<RecipeCalendar, Long> {
}
