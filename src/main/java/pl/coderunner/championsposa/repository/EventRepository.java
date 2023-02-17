package pl.coderunner.championsposa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderunner.championsposa.domain.Event;

public interface EventRepository extends JpaRepository<Event,Long> {
    Event findById(long id);
}
