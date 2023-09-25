package xtech.qrvenus.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByUserIdQrCodesResponse {
    private Integer id;
    private String title;
    private String note;
    private String code;

    private Integer categoryId;
    private String categoryName;

    private List<GetAllQrCodePermissionsResponse> qrCodePermissions;

    private Integer userId;
    private String userName;
}
