package config;

import model.User;
import model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class RegistrationService {
    @Autowired
    private UserRepository repository;
    public User register(RegistrationRequest request){
        User user = new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setUserRoles(UserRole.USER);
        return repository.save(user);
    }
}
