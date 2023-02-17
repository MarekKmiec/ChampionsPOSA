package pl.coderunner.championsposa.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderunner.championsposa.domain.CategoryOfAge;

import java.util.List;

@Getter
@Setter
@ToString
public class CompetitionDto {

    private String name;
//    private List<String> categoriesOfAgeList;
    private String categoriesOfAge;
}
