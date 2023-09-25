package xtech.qrvenus.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xtech.qrvenus.business.abstracts.CityService;
import xtech.qrvenus.business.requests.CreateCityRequest;
import xtech.qrvenus.business.requests.UpdateCityRequest;
import xtech.qrvenus.business.responses.GetAllCitiesResponse;
import xtech.qrvenus.business.responses.GetByIdCityResponse;
import xtech.qrvenus.core.utilities.mappers.ModelMapperService;
import xtech.qrvenus.dataAccess.abstracts.CityRepository;
import xtech.qrvenus.entities.concretes.City;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private ModelMapperService modelMapperService;
    private CityRepository cityRepository;

    @Override
    public List<GetAllCitiesResponse> getAll() {
        List<City> countries = cityRepository.findAll();
        List<GetAllCitiesResponse> getAllCitiesResponses = countries.stream()
                .map(country -> modelMapperService.forResponse()
                        .map(country, GetAllCitiesResponse.class))
                .collect(Collectors.toList());
        return getAllCitiesResponses;
    }

    @Override
    public GetByIdCityResponse getById(Integer id) {
        Optional<City> city = cityRepository.findById(id);
        GetByIdCityResponse getByIdCityResponse = modelMapperService.forResponse()
                .map(city, GetByIdCityResponse.class);
        return getByIdCityResponse;
    }

    @Override
    public void add(CreateCityRequest createCityRequest) {
        City city = modelMapperService.forRequest()
                .map(createCityRequest, City.class);
        city.setId(null);
        cityRepository.save(city);
    }

    @Override
    public void update(UpdateCityRequest updateCityRequest) {
        City city = modelMapperService.forRequest().map(updateCityRequest, City.class);
        cityRepository.save(city);
    }

    @Override
    public void delete(Integer id) {
        cityRepository.deleteById(id);
    }
}
