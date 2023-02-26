package pl.coderunner.championsposa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderunner.championsposa.domain.Register;

public interface RegisterRepository extends JpaRepository<Register, Long> {
    Register findByRegisterKey(String registerKey);
}
