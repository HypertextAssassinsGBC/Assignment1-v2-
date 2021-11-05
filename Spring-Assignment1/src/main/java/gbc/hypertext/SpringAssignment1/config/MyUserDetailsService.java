package gbc.hypertext.SpringAssignment1.config;

import gbc.hypertext.SpringAssignment1.model.User;
import gbc.hypertext.SpringAssignment1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.getUserByEmail(s);
        if(user == null){
            throw new UsernameNotFoundException("User not found");

        }
        return new UserDetailsImpl(user);
    }

}
