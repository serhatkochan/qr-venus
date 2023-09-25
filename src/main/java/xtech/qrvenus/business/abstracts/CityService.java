package xtech.qrvenus.business.abstracts;

import xtech.qrvenus.business.requests.CreateCityRequest;
import xtech.qrvenus.business.requests.UpdateCityRequest;
import xtech.qrvenus.business.responses.GetAllCitiesResponse;
import xtech.qrvenus.business.responses.GetByIdCityResponse;

import java.util.List;

public interface CityService {
    List<GetAllCitiesResponse> getAll();
    GetByIdCityResponse getById(Integer id);

    void add(CreateCityRequest createCityRequest);

    void update(UpdateCityRequest updateCityRequest);

    void delete(Integer id);
}
