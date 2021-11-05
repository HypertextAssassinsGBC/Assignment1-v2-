package gbc.hypertext.SpringAssignment1.repository;

import gbc.hypertext.SpringAssignment1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT u from User u WHERE u.username = :email")
    public User getUserByEmail(@Param("email") String email);


}
