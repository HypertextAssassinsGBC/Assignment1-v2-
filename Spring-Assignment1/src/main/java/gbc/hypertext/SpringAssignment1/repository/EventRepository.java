package gbc.hypertext.SpringAssignment1.repository;

import gbc.hypertext.SpringAssignment1.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
