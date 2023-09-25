package xtech.qrvenus.webApi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xtech.qrvenus.business.abstracts.CategoryService;
import xtech.qrvenus.business.requests.CreateCategoryRequest;
import xtech.qrvenus.business.requests.UpdateCategoryRequest;
import xtech.qrvenus.business.responses.GetAllCategoriesResponse;
import xtech.qrvenus.business.responses.GetByIdCategoryResponse;
import xtech.qrvenus.business.responses.GetByUserIdCategoryResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
@AllArgsConstructor
@CrossOrigin
public class CategoriesController {
    private CategoryService categoryService;

    @GetMapping
    public List<GetAllCategoriesResponse> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdCategoryResponse getById(@PathVariable Integer id) {
        return categoryService.getById(id);
    }

    @GetMapping("/user/{userId}")
    public List<GetByUserIdCategoryResponse> getByUserId(@PathVariable Integer userId) {
        return categoryService.getByUserId(userId);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateCategoryRequest createCategoryRequest) {
        categoryService.add(createCategoryRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
        categoryService.update(updateCategoryRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoryService.delete(id);
    }
}
