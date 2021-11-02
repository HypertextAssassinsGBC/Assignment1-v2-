package repository;

import model.Cookbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookBookRepository extends JpaRepository<Cookbook, Long> {

}
