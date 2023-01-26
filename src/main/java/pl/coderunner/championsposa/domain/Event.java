package pl.coderunner.championsposa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @OneToOne
    private EventAddress eventAddress;
    private LocalDateTime localDate;
    private String Administrator;
    private String Description;
    @OneToMany
    private List<CategoriesOfAge> categories;
    @OneToMany
    private List<Competitions> competitionsList;

}
