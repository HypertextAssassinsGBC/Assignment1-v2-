package security;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public String register(security.RegistrationRequest request){
        return "works";
    }
}
