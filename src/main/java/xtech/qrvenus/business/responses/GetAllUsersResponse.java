package xtech.qrvenus.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xtech.qrvenus.business.enums.Role;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersResponse {
    private Integer id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String password;
    private Role role;
    private Instant birthDate;
    private Integer cityId;
    private String cityName;
    private Integer countryId;
    private String countryName;
}
