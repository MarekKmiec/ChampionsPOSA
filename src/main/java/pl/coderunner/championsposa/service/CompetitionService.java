package pl.coderunner.championsposa.service;

import org.jetbrains.annotations.NotNull;
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

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

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
        Join<Competition, CategoryOfAge> categoryOfAgeJoin = competitionRoot.join(Competition_.CATEGORIES_OF_AGE);



        List<Predicate> namePredicate = getPredicationCompetition(name,cb,competitionRoot);
        List<Predicate> predicateListCategory=getPredicateCategory(categoriesOfAge,cb,categoryOfAgeJoin);




//        Predicate categoriesPredicate = cb.equal(categoryOfAgeJoin.get(CategoryOfAge_.categoriesOfAge), categoriesOfAge);
//
//        Predicate nameCatPredicate = cb.or(categoriesPredicate, namePredicate);

//        cq.select(competitionRoot)
//                .where(cb.or(nameCatPredicate,categoriesPredicate))
//                .orderBy(cb.desc(competitionRoot.get("name")));

        cq.select(competitionRoot);
        cq.where(
                cb.and(namePredicate.toArray(new Predicate[]{})),
                cb.and(predicateListCategory.toArray(new Predicate[]{})));




//        cq.select(competitionRoot);
//        cq.where(namePredicate);
//        cq.where(categoriesPredicate);
//        cq.orderBy(cb.asc(categoryOfAgeJoin.get(CategoryOfAge_.categoriesOfAge)));


        TypedQuery<Competition> query = entityManager.createQuery(cq);

        List<Competition> result = query.getResultList();
        return result;
    }

    private List<Predicate> getPredicationCompetition(String name, CriteriaBuilder cb, Root<Competition> competitionRoot){
       List<Predicate> predicateList=new ArrayList<>();

        if(name!=null){
            Predicate namePredicate = cb.equal(competitionRoot.get(Competition_.name), name);
            predicateList.add(namePredicate);
        }
        return predicateList;
    }

    private List<Predicate> getPredicateCategory(String categoriesOfAge,CriteriaBuilder cb,Join<Competition, CategoryOfAge> categoryOfAgeJoin){
        List<Predicate> predicateListCategory=new ArrayList<>();
        if(categoriesOfAge!=null) {
            Predicate categoriesPredicate = cb.equal(categoryOfAgeJoin.get(CategoryOfAge_.categoriesOfAge), categoriesOfAge);
            predicateListCategory.add(categoriesPredicate);
        }

        return predicateListCategory;
    }

        public Competition addCompetition (CompetitionDto competitionDto){
            Competition newCompetition = new Competition();
            newCompetition.setName(competitionDto.getName());
            List<CategoryOfAge> catAgeList = new ArrayList<>();
            for (String str : competitionDto.getCategoriesOfAgeList()) {
                catAgeList.add(categoryOfAgeRepository.findByCategoriesOfAge(str));
            }
            newCompetition.setCategoriesOfAge(catAgeList);
            competitionRepository.save(newCompetition);
            return newCompetition;
        }
    }
