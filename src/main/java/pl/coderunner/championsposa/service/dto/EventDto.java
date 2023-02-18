package pl.coderunner.championsposa.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderunner.championsposa.domain.Competition;
import pl.coderunner.championsposa.domain.EventAddress;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@ToString
public class EventDto {
    private Long Id;
    private String name;
    private EventAddress eventAddress;
    private LocalDateTime localDate;
    private String administrator;
    private String description;
    private List<Competition> competitionsList;

}
