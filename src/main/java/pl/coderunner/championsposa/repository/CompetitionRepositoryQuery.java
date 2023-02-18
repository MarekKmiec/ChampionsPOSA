package pl.coderunner.championsposa.repository;

import pl.coderunner.championsposa.domain.Competition;

import java.util.List;

public interface CompetitionRepositoryQuery {
    List<Competition> findByNameAndCategoryOfAge(String name, String categories);
}
