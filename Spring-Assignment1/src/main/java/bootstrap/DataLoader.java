package bootstrap;

import model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import repository.UserRepository;
@Component
public class DataLoader implements CommandLineRunner {
    private UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User admin = new User("Duncan", "Wardlaw", "duncan@gmail.com", "pass");
        userRepository.save(admin);
        System.out.println("Admin loaded");
    }
}
