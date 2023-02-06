package pl.coderunner.championsposa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
//    @NotEmpty(message = "{street.notEmpty}")
    private String street;
//    @NotEmpty(message = "{houseNumber.notEmpty}")
    private String houseNumber;
    private String apartmentNumber;
//    @NotEmpty(message = "{country.notEmpty}")
    private String country;
//    @NotEmpty(message = "{city.notEmpty}")
    private String city;
//    @NotEmpty(message = "{zipCode.notEmpty}")
    private String zipCode;

}
