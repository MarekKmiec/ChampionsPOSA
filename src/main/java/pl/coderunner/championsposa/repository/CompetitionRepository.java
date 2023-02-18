package pl.coderunner.championsposa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderunner.championsposa.domain.Competition;

public interface CompetitionRepository extends JpaRepository<Competition,Long> {

}
