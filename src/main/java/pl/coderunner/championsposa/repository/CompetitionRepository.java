package pl.coderunner.championsposa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderunner.championsposa.domain.Competition;
import pl.coderunner.championsposa.domain.Competition_;

public interface CompetitionRepository extends JpaRepository<Competition,Long> {
Competition findById(long id);
}
