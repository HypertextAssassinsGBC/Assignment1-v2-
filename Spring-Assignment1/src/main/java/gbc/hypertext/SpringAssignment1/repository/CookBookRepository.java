package gbc.hypertext.SpringAssignment1.repository;

import gbc.hypertext.SpringAssignment1.model.Cookbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookBookRepository extends JpaRepository<Cookbook, Long> {

}
