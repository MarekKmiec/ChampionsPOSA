package pl.coderunner.championsposa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderunner.championsposa.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority,String> {
}
