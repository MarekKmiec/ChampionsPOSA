package pl.coderunner.championsposa.service.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RegisterDto {
    private long userId;
    private long competitionID;
    private long categoryOfAgeId;


}
