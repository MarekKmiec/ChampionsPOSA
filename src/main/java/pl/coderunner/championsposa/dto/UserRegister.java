package pl.coderunner.championsposa.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegister {
    @Column(nullable = false, unique = true, length = 60)
    private String username;
    private String password;
    private String password2;
}
