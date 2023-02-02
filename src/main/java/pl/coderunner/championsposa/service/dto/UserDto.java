package pl.coderunner.championsposa.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderunner.championsposa.domain.User;

import java.io.Serializable;
@Getter
@Setter
@ToString
public class UserDto  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private String username;

    public UserDto(User user){
        this.id= user.getId();
        this.username= user.getUsername();
    }
    public UserDto(){
    }
}
