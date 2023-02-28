package pl.coderunner.championsposa.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddressDto {

    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String country;
    private String city;
    private String zipCode;

    public UserAddressDto(String street, String houseNumber, String apartmentNumber, String country, String city, String zipCode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
    }
  public UserAddressDto(){
  }

}
