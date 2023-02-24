package pl.coderunner.championsposa.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CategoryOfAge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String categoriesOfAge;
    @ManyToOne
    private Competition competition;

    //    private String Varsity;
//    private String JuniorA;
//    private String JuniorB;
//    private String DuetJunior;
//    private String SeniorWomen;
//    private String SeniorWomenDuet;
//    private String SeniorMen;
//    private String Master40;
//    private String Master50;
//    private String SeniorDuet;
//    private String Exception;
    public CategoryOfAge() {

    }

    public CategoryOfAge(String categoriesOfAge) {
        this.categoriesOfAge = categoriesOfAge;
    }
}



