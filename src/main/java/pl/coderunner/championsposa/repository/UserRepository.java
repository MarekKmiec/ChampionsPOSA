package pl.coderunner.championsposa.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderunner.championsposa.domain.User;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByActivationKey(String activationKey);
    Optional<User> findOneByResetKey(String resetKey);

    Optional<User> findByUsernameIgnoreCase(String username);

    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUsernameIgnoreCase(String username);

    User findByUsername(String username);
    User findById(long id);
    @Modifying
    @Query("delete from User u where u.Id=:id")
    void deleteUser(long id);

}