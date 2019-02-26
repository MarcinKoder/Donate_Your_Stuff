package pl.mwisniewski.Donate_Your_Stuff.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mwisniewski.Donate_Your_Stuff.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
