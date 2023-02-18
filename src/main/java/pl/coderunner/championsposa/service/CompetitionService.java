package pl.coderunner.championsposa.service;

import org.springframework.stereotype.Service;
import pl.coderunner.championsposa.domain.CategoryOfAge;
import pl.coderunner.championsposa.domain.CategoryOfAge_;
import pl.coderunner.championsposa.domain.Competition;
import pl.coderunner.championsposa.domain.Competition_;
import pl.coderunner.championsposa.repository.CategoryOfAgeRepository;
import pl.coderunner.championsposa.repository.CompetitionRepository;
import pl.coderunner.championsposa.repository.CompetitionRepositoryQuery;
import pl.coderunner.championsposa.service.dto.CompetitionDto;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionService implements CompetitionRepositoryQuery {

    private final CompetitionRepository competitionRepository;
    private final CategoryOfAgeRepository categoryOfAgeRepository;
    private final EntityManager entityManager;

    public CompetitionService(CompetitionRepository competitionRepository, CategoryOfAgeRepository categoryOfAgeRepository, EntityManager entityManager) {
        this.competitionRepository = competitionRepository;
        this.categoryOfAgeRepository = categoryOfAgeRepository;
        this.entityManager = entityManager;
    }


    @Override
    public List<Competition> findByNameAndCategoryOfAge(String name, String categoriesOfAge) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Competition> cq = cb.createQuery(Competition.class);

        Root<Competition> competitionRoot = cq.from(Competition.class);
        Join<Competition, CategoryOfAge> categoryOfAgeJoin = competitionRoot.join(Competition_.categoriesOfAge);


        Predicate namePredicate = cb.equal(competitionRoot.get("name"), name);
        Predicate categoriesPredicate = cb.equal(categoryOfAgeJoin.get("categoriesOfAge"), categoriesOfAge);

        cq.where(namePredicate, categoriesPredicate);

        TypedQuery<Competition> query = entityManager.createQuery(cq);

        List<Competition> result = query.getResultList();
        return result;
    }

    public Competition addCompetition(CompetitionDto competitionDto) {
        Competition newCompetition = new Competition();
        newCompetition.setName(competitionDto.getName());
        CategoryOfAge categoryOfAge = new CategoryOfAge();
        categoryOfAge.setCategoriesOfAge(competitionDto.getCategoriesOfAge());

//        List<CategoryOfAge> CatAgeList=competitionDto.getCategoriesOfAgeList().stream()
//                        .map(s->categoryOfAge.setCategoriesOfAge(s))
//                .collect(Collectors.toList();

        newCompetition.setCategoriesOfAge(List.of(categoryOfAge));
        competitionRepository.save(newCompetition);
        return newCompetition;
    }
}
