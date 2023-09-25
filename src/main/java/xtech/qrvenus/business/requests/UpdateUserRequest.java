package xtech.qrvenus.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xtech.qrvenus.business.enums.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    @NotNull
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String surname;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String phoneNumber;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String password;

    @NotNull
    private Role role;

    @NotNull
    private Instant birthDate;

    @NotNull
    private Integer cityId;
}
