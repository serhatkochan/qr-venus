package xtech.qrvenus.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCountyResponse {
    private Integer id;
    private String name;
    private List<GetAllCitiesResponse> cities;
}
