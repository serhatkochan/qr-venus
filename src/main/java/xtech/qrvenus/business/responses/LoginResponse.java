package xtech.qrvenus.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xtech.qrvenus.business.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private Integer userId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String password;
    private Role role;
    private String token;
}
