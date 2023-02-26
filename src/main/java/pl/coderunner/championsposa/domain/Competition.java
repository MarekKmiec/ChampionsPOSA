package pl.coderunner.championsposa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "competition_id")
    private List<CategoryOfAge> categoriesOfAge;



//    @JoinColumn(name = "register_id")


    public Competition(String name, List<CategoryOfAge> categoriesOfAge) {
        this.name = name;
        this.categoriesOfAge = categoriesOfAge;
    }
    public Competition(){
    }
}
