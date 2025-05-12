package spring_team4.spring_team4.category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_team4.spring_team4.category.dto.CategoryRequest;
import spring_team4.spring_team4.category.dto.CategoryResponse;
import spring_team4.spring_team4.user.UserService;

@RestController
@RequestMapping("/api/product")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //URI 경로
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest dto) {
        return ResponseEntity.ok(categoryService.createCategory(dto));
    }
}
