package pl.coderunner.championsposa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderunner.championsposa.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
