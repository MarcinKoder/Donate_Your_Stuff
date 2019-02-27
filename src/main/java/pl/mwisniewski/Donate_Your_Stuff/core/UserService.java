package pl.mwisniewski.Donate_Your_Stuff.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mwisniewski.Donate_Your_Stuff.dto.UserPasswordFormDTO;
import pl.mwisniewski.Donate_Your_Stuff.model.User;
import pl.mwisniewski.Donate_Your_Stuff.repositories.UserRepository;
import pl.mwisniewski.Donate_Your_Stuff.repositories.UserRoleRepository;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Transactional
    public boolean changeUserPassword(UserPasswordFormDTO passwordChangeForm) {
        User user = new User();
        if (!passwordChangeForm.getPassword().equals(passwordChangeForm.getConfirmedPassword())) {
            return false;
        } else {
            user.setId(passwordChangeForm.getId());
            user.setEmail(passwordChangeForm.getEmail());
            user.setName(passwordChangeForm.getName());
            user.setSurname(passwordChangeForm.getSurname());
            String encodedPassword = passwordEncoder.encode(passwordChangeForm.getPassword());
            user.setPassword(encodedPassword);
            userRepository.save(user);

            return true;
        }
    }

    @Transactional
    public UserPasswordFormDTO userToEditPassword(Long id) {
        UserPasswordFormDTO user = new UserPasswordFormDTO();
        User user1 = userRepository.findById(id).orElse(null);

        if (user1 != null){
            user.setId(user1.getId());
            user.setEmail(user1.getEmail());
            user.setName(user1.getName());
            user.setSurname(user1.getSurname());
        }
        return user;
    }
}
