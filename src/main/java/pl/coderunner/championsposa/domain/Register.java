package pl.coderunner.championsposa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
//            (mappedBy ="register" )
            (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")

    private User user;
    @OneToOne
//            (mappedBy = "register")
            (cascade = CascadeType.ALL)
    @JoinColumn(name = "competition_id")
    private Competition competition;
    @OneToOne
//            (mappedBy = "register")
            (cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryOfAge_id")
    private CategoryOfAge categoryOfAge;

    private Boolean isPay;

    private String registerKey;


}
