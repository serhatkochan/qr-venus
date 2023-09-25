package xtech.qrvenus.webApi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xtech.qrvenus.business.abstracts.CityService;
import xtech.qrvenus.business.requests.CreateCityRequest;
import xtech.qrvenus.business.requests.UpdateCityRequest;
import xtech.qrvenus.business.responses.GetAllCitiesResponse;
import xtech.qrvenus.business.responses.GetByIdCityResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/cities")
@AllArgsConstructor
@CrossOrigin
public class CityController {
    private CityService cityService;

    @GetMapping
    public List<GetAllCitiesResponse> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdCityResponse getById(@PathVariable Integer id) {
        return cityService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateCityRequest createCityRequest) {
        cityService.add(createCityRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateCityRequest updateCityRequest) {
        cityService.update(updateCityRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cityService.delete(id);
    }


}
