package xtech.qrvenus.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xtech.qrvenus.business.abstracts.CountryService;
import xtech.qrvenus.business.requests.CreateCountryRequest;
import xtech.qrvenus.business.requests.UpdateCountryRequest;
import xtech.qrvenus.business.responses.GetAllCountyResponse;
import xtech.qrvenus.business.responses.GetByIdCountryResponse;
import xtech.qrvenus.core.utilities.mappers.ModelMapperService;
import xtech.qrvenus.dataAccess.abstracts.CountryRepository;
import xtech.qrvenus.entities.concretes.Country;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryManager implements CountryService {
    private ModelMapperService modelMapperService;
    private CountryRepository countryRepository;

    @Override
    public List<GetAllCountyResponse> getAll() {
        List<Country> countries = countryRepository.findAll();
        List<GetAllCountyResponse> getAllCountyResponses = countries.stream()
                .map(country -> modelMapperService.forResponse()
                        .map(country, GetAllCountyResponse.class))
                .collect(Collectors.toList());
        return getAllCountyResponses;
    }

    @Override
    public GetByIdCountryResponse getById(Integer id) {
        Optional<Country> country = countryRepository.findById(id);
        GetByIdCountryResponse getByIdCountryResponse = modelMapperService.forResponse()
                .map(country, GetByIdCountryResponse.class);
        return getByIdCountryResponse;
    }

    @Override
    public void add(CreateCountryRequest createCountryRequest) {
        Country country = modelMapperService.forRequest().map(createCountryRequest, Country.class);
        countryRepository.save(country);
    }

    @Override
    public void update(UpdateCountryRequest updateCountryRequest) {
        Country country = modelMapperService.forRequest().map(updateCountryRequest, Country.class);
        countryRepository.save(country);
    }

    @Override
    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }
}
