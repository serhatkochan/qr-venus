package xtech.qrvenus.business.abstracts;

import xtech.qrvenus.business.requests.CreateCountryRequest;
import xtech.qrvenus.business.requests.UpdateCountryRequest;
import xtech.qrvenus.business.responses.GetAllCountyResponse;
import xtech.qrvenus.business.responses.GetByIdCountryResponse;

import java.util.List;

public interface CountryService {
    List<GetAllCountyResponse> getAll();
    GetByIdCountryResponse getById(Integer id);

    void add(CreateCountryRequest createCountryRequest);

    void update(UpdateCountryRequest updateCountryRequest);

    void delete(Integer id);

}
