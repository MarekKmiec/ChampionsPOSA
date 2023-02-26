package pl.coderunner.championsposa.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty(message = "{email.valid}")
    @Email(message = "{email.notEmpty}")
    @Size(max = 60, message = "{email.size}")
    @Column(nullable = false, unique = true, length = 60)
    private String username;
    @NotEmpty(message = "{password.notEmpty}")
    @Column(length = 100)
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-6])(?=.*?[#?!@$%^&*-]).{6,100}$", message = "{weak.password}")
    private String password;
    @Transient
    private String matchingPassword;
    private int enabled;
    /////////////////////////////////////////////
    @NotNull
    @Column(nullable = false)
    private boolean activated = false;

    @Size(min = 2, max = 10)
    @Column(name = "lang_key", length = 10)
    private String langKey;

    @Size(max = 256)
    @Column(name = "image_url", length = 256)
    private String imageUrl;

    @Size(max = 40)
    @Column(name = "activation_key", length = 40)
    @JsonIgnore
    private String activationKey;
    @Size(max = 20)
    @Column(name = "reset_key", length = 20)
    @JsonIgnore
    private String resetKey;
    ///////////////////////////////////////////////
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;
    @Column(name = "time")
    private LocalTime localTime;

    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "updated_on")
    private LocalDateTime updateOn;

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateOn = LocalDateTime.now();
    }
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles=new HashSet<>();


//    @OneToOne
//    @JoinColumn(name = "register_id")
//    private Register register;


//    @OneToMany
//    private List<UserAddress> userAddress;
//    @OneToOne
//    private UserData userData;
//    @OneToMany
//    private List<UserPlayerProfile> playerProfileLiat;

}
