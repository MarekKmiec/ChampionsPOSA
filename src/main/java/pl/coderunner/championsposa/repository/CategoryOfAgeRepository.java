package pl.coderunner.championsposa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderunner.championsposa.domain.CategoryOfAge;

import java.util.List;

public interface CategoryOfAgeRepository extends JpaRepository<CategoryOfAge,Long> {
    CategoryOfAge findByCategoryOfAge(String categoriesOfAge);
    CategoryOfAge findById(long id);
}
