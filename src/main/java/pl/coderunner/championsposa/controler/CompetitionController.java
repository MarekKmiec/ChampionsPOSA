package pl.coderunner.championsposa.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderunner.championsposa.domain.Competition;
import pl.coderunner.championsposa.service.CompetitionService;
import pl.coderunner.championsposa.service.dto.CompetitionDto;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompetitionController {

    private final CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @PostMapping("/competition")
    public Competition addCompetition(@RequestBody CompetitionDto competitionDto) {
        Competition newCompetition;
        newCompetition = competitionService.addCompetition(competitionDto);
        return newCompetition;
    }

    @GetMapping("/competitions")
    public List<Competition> findByNameAndCategoryOfAge(@RequestParam(required = false, name ="name") String name,
                                                        @RequestParam(required = false, name = "categoriesOfAge") String categories) {
        return competitionService.findByNameAndCategoryOfAge(name, categories);
    }
}
