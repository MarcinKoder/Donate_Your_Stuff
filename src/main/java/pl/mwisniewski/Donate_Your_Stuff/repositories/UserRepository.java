package pl.mwisniewski.Donate_Your_Stuff.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mwisniewski.Donate_Your_Stuff.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail (String email);
}
