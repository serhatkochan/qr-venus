package xtech.qrvenus.business.abstracts;

import xtech.qrvenus.business.requests.CreateCategoryRequest;
import xtech.qrvenus.business.requests.UpdateCategoryRequest;
import xtech.qrvenus.business.responses.GetAllCategoriesResponse;
import xtech.qrvenus.business.responses.GetByIdCategoryResponse;
import xtech.qrvenus.business.responses.GetByUserIdCategoryResponse;

import java.util.List;

public interface CategoryService {
    List<GetAllCategoriesResponse> getAll();

    GetByIdCategoryResponse getById(Integer id);
    List<GetByUserIdCategoryResponse> getByUserId(Integer userId);

    void add(CreateCategoryRequest createCategoryRequest);

    void update(UpdateCategoryRequest updateCategoryRequest);

    void delete(Integer id);

}
