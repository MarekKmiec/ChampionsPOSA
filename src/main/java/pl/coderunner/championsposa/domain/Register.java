package pl.coderunner.championsposa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToOne
    private User user;
    @OneToOne
    private Competition competitions;
    @OneToOne
    private CategoryOfAge categoriesOfAge;

    private Boolean isPay;

    private String key;

}
