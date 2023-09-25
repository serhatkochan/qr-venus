package xtech.qrvenus.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByUserIdCategoryResponse {
    private Integer id;
    private String name;
    List<GetAllQrCodesResponse> qrCodes;
}
