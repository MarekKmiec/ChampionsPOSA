package pl.coderunner.championsposa.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
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

    @NotEmpty(message = "Wpisz adres email")
    @Email(message = "Niepoprawny format adresu email")
    @Size(max = 60,message = "Maksymalna długość adresu email to 60 znaków")
    @NotEmpty(message = "Email nie może być pusty")
    @Column(nullable = false, unique = true, length = 60)
    private String username;
    @NotEmpty(message = "Hasło nie moę być puste")
    @Column(length = 100)
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-6])(?=.*?[#?!@$%^&*-]).{6,100}$", message = "{weak.password}")
    private String password;
    @Transient
    private String matchingPassword;
    @Size(min = 3, max = 60, message = "Minimalna ilość znaków to 3, maksymalna ilosc znaków 60")
    @NotEmpty(message = "pole nie może być puste")
    @Column(length = 60)
    private String firstName;
    @NotEmpty(message = "pole nie może być puste")
    private String lastName;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String country;
    private String city;
    private String zipCode;

    private String phoneNumber;
    private int enabled;
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;
    @Column(name = "time")
    private LocalTime localTime;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartmentNumber=" + apartmentNumber +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
