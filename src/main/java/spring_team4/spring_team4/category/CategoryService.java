package spring_team4.spring_team4.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring_team4.spring_team4.category.dto.CategoryRequest;
import spring_team4.spring_team4.category.dto.CategoryResponse;
import spring_team4.spring_team4.user.User;
import spring_team4.spring_team4.user.UserRepository;
import spring_team4.spring_team4.user.dto.UserRequest;
import spring_team4.spring_team4.user.dto.UserResponse;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("category not found"));

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryId(category.getCategoryId());
        categoryResponse.setCategoryName(category.getCategoryName());

        return categoryResponse;
    }

    public CategoryResponse createCategory(CategoryRequest dto) {
        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());

        categoryRepository.save(category);

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryId(category.getCategoryId());
        categoryResponse.setCategoryName(category.getCategoryName());
        return categoryResponse;
    }
}
