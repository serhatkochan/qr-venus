package xtech.qrvenus.webApi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xtech.qrvenus.business.abstracts.CountryService;
import xtech.qrvenus.business.requests.CreateCountryRequest;
import xtech.qrvenus.business.requests.UpdateCountryRequest;
import xtech.qrvenus.business.responses.GetAllCountyResponse;
import xtech.qrvenus.business.responses.GetByIdCountryResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/countries")
@AllArgsConstructor
@CrossOrigin
public class CountryController {
    private CountryService countryService;

    @GetMapping
    public List<GetAllCountyResponse> getAll() {
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdCountryResponse getById(@PathVariable Integer id) {
        return countryService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateCountryRequest createCountryRequest) {
        countryService.add(createCountryRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateCountryRequest updateCountryRequest) {
        countryService.update(updateCountryRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        countryService.delete(id);
    }
}
