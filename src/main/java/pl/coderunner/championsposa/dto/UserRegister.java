package pl.coderunner.championsposa.dto;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRegister {
    private long id;
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
    @NotEmpty(message = "Hasło nie moę być puste")
    @Column(length = 100)
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-6])(?=.*?[#?!@$%^&*-]).{6,100}$", message = "{weak.password}")
    private String password2;
    @Size(min = 3, max = 60, message = "Minimalna ilość znaków to 3, maksymalna ilosc znaków 60")
    @NotEmpty(message = "pole nie może być puste")
    @Column(length = 60)
    private String firstName;
    @NotEmpty(message = "pole nie może być puste")
    private String lastName;
    @NotEmpty(message = "pole nie może być puste")
    private String street;

    private int houseNumber;
    private int apartmentNumber;
    @NotEmpty(message = "pole nie może być puste")
    private String country;
    @NotEmpty(message = "pole nie może być puste")
    private String city;
    @NotEmpty(message = "pole nie może być puste")
    private String zipCode;

    private int phoneNumber;

    public UserRegister(){

    }

    public UserRegister(String username, String password, String password2, String firstName, String lastName, String street, int houseNumber, int apartmentNumber, String country, String city, String zipCode, int phoneNumber) {
        this.username = username;
        this.password = password;
        this.password2 = password2;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }
}
