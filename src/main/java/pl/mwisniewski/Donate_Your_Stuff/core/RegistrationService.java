package pl.mwisniewski.Donate_Your_Stuff.core;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mwisniewski.Donate_Your_Stuff.dto.RegistrationFormDTO;
import pl.mwisniewski.Donate_Your_Stuff.model.User;
import pl.mwisniewski.Donate_Your_Stuff.model.UserRole;
import pl.mwisniewski.Donate_Your_Stuff.repositories.UserRepository;
import pl.mwisniewski.Donate_Your_Stuff.repositories.UserRoleRepository;

import javax.transaction.Transactional;

@Transactional
@Service
public class RegistrationService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private UserRoleRepository userRoleRepository;

    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }
    public boolean register(RegistrationFormDTO registrationFormDTO){
        User user = new User();
        user.setEmail(registrationFormDTO.getEmail());
        user.setName(registrationFormDTO.getName());
        user.setSurname(registrationFormDTO.getSurname());
        String encodedPassword = passwordEncoder.encode(registrationFormDTO.getPassword());
        user.setPassword(encodedPassword);
        user = userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole("ROLE_USER");
        userRoleRepository.save(userRole);
        return true;
    }
}
