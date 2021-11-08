package gbc.hypertext.SpringAssignment1;

import static org.assertj.core.api.Assertions.assertThat;

import gbc.hypertext.SpringAssignment1.model.User;
import gbc.hypertext.SpringAssignment1.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    // test methods go below
    @Test
    public void testCreateUser() {
        User user = new User();

        user.setUsername("ravikumar@gmail.com");
        user.setPassword("ravi2020");
        user.setFirstname("Ravi");
        user.setLastname("Kumar");

        repo.save(user);

        UserDetails existUser = repo.getUserByUsername(user.getUsername());

        assertThat(user.getUsername()).isEqualTo(existUser.getUsername());

    }
}
