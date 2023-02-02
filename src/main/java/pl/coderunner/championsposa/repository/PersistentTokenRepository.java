package pl.coderunner.championsposa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderunner.championsposa.domain.PersistentToken;
import pl.coderunner.championsposa.domain.User;

import java.time.LocalDate;
import java.util.List;

public interface PersistentTokenRepository extends JpaRepository<PersistentToken,String> {
    List<PersistentToken> findByUser(User user);
    List<PersistentToken> findByTokenDateBefore(LocalDate localDate);


}
