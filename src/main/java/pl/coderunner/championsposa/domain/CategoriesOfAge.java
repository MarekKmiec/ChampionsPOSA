package pl.coderunner.championsposa.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CategoriesOfAge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Varsity;
    private String JuniorA;
    private String JuniorB;
    private String DuetJunior;
    private String SeniorWomen;
    private String SeniorWomenDuet;
    private String SeniorMen;
    private String Master40;
    private String Master50;
    private String SeniorDuet;
    private String Exception;


}



