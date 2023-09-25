package xtech.qrvenus.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xtech.qrvenus.business.abstracts.CategoryService;
import xtech.qrvenus.business.requests.CreateCategoryRequest;
import xtech.qrvenus.business.requests.UpdateCategoryRequest;
import xtech.qrvenus.business.responses.GetAllCategoriesResponse;
import xtech.qrvenus.business.responses.GetByIdCategoryResponse;
import xtech.qrvenus.business.responses.GetByUserIdCategoryResponse;
import xtech.qrvenus.core.utilities.mappers.ModelMapperService;
import xtech.qrvenus.dataAccess.abstracts.CategoryRepository;
import xtech.qrvenus.entities.concretes.Category;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private ModelMapperService modelMapperService;
    private CategoryRepository categoryRepository;

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoriesResponse> getAllCategoriesResponse = categories.stream()
                .map(category -> modelMapperService.forResponse()
                        .map(category, GetAllCategoriesResponse.class))
                .collect(Collectors.toList());
        return getAllCategoriesResponse;
    }

    @Override
    public GetByIdCategoryResponse getById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        GetByIdCategoryResponse getByIdCategoryResponse = modelMapperService.forResponse()
                .map(category, GetByIdCategoryResponse.class);
        return getByIdCategoryResponse;
    }

    @Override
    public List<GetByUserIdCategoryResponse> getByUserId(Integer userId) {
        List<Category> categories = categoryRepository.findByUserIdOrderByIdAsc(userId);
        List<GetByUserIdCategoryResponse> getByUserIdCategoryResponses = categories.stream()
                .map(category -> modelMapperService.forResponse()
                        .map(category, GetByUserIdCategoryResponse.class))
                .collect(Collectors.toList());
        return getByUserIdCategoryResponses;
    }

    @Override
    public void add(CreateCategoryRequest createCategoryRequest) {
        Category category = modelMapperService.forRequest().map(createCategoryRequest, Category.class);
        categoryRepository.save(category);
    }

    @Override
    public void update(UpdateCategoryRequest updateCategoryRequest) {
        Category category = modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
        categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
