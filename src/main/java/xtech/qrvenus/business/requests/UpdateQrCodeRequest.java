package xtech.qrvenus.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateQrCodeRequest {
    @NotNull
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String title;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 20)
    private String note;

    @NotNull
    @NotBlank
    private String code;

    private Integer categoryId;

    private List<Integer> qrCodePermissionIds;

    @NotNull
    private Integer userId;
}
