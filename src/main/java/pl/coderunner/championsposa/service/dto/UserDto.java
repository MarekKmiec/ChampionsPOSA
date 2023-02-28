package pl.coderunner.championsposa.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderunner.championsposa.domain.User;
import pl.coderunner.championsposa.domain.UserAddress;
import pl.coderunner.championsposa.domain.UserData;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private String password;
    @NotEmpty(message = "{email.valid}")
    @Email(message = "{email.notEmpty}")
    @Size(max = 60, message = "{email.size}")
    @Column(nullable = false, unique = true, length = 60)
    private String username;
    @Size(max = 256)
    private String imageUrl;
    private boolean activated = false;
    @Size(min = 2, max = 10)
    private String langKey;
    private LocalDate localDate;
    private LocalTime localTime;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
    private Set<String> roles;
    private UserDataDto userDataDto;
    private UserAddressDto userAddressDto;


//    }
//
//    public UserDto(User user) {
//        this.id = user.getId();
//        this.username = user.getUsername();
//        this.activated = user.isActivated();
//        this.imageUrl = user.getImageUrl();
//        this.langKey = user.getLangKey();
//        this.localDate = user.getLocalDate();
//        this.localTime = user.getLocalTime();
//        this.createdOn = user.getCreatedOn();
//        this.updateOn = user.getUpdateOn();
//        this.roles = user.getRoles().stream().map(a -> a.getName()).collect(Collectors.toSet());
//    }
}
