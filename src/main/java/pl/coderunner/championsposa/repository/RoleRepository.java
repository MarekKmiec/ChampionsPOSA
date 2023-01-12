package pl.coderunner.championsposa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderunner.championsposa.domain.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
