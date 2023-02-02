package pl.coderunner.championsposa.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderunner.championsposa.domain.Role;
import pl.coderunner.championsposa.domain.User;

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
public class AdminUserDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
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

    public AdminUserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.activated = user.isActivated();
        this.imageUrl = user.getImageUrl();
        this.langKey = user.getLangKey();
        this.localDate = user.getLocalDate();
        this.localTime = user.getLocalTime();
        this.createdOn = user.getCreatedOn();
        this.updateOn = user.getUpdateOn();
        this.roles = user.getRoles().stream().map(r -> r.getName()).collect(Collectors.toSet());

    }
}
