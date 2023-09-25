package xtech.qrvenus.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCityResponse {
    private Integer id;
    private String name;
    private Integer countryId;
    private String countryName;
}
