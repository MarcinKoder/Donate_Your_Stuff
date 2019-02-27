package pl.mwisniewski.Donate_Your_Stuff.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.mwisniewski.Donate_Your_Stuff.model.Donate;
import pl.mwisniewski.Donate_Your_Stuff.model.User;

import java.util.List;

public interface DonateRepository extends JpaRepository<Donate, Long> {
    List<Donate> findAllByUser(User user);
}
