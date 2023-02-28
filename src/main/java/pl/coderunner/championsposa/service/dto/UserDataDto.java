package pl.coderunner.championsposa.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Getter
@Setter

public class UserDataDto {

    private String firstName;
    private String lastName;
    private char sex;
    private LocalDate dataOfBirth;
    private String phoneNumber;
}
