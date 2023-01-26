package pl.coderunner.championsposa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Size(min = 3, max = 60, message = "{firstName.size}")
    @NotEmpty(message = "{firstName.notEmpty}")
    @Column(length = 60)
    private String firstName;
    @NotEmpty(message = "{lastName.notEmpty}")
    private String lastName;
    private char sex;
    private LocalDate dataOfBirth;
    @NotEmpty(message = "{phoneNumber.notEmpty}")
    private String phoneNumber;

}
