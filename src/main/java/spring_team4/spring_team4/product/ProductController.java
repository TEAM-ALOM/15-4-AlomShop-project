// src/main/java/spring_team4/spring_team4/product/ProductController.java
package spring_team4.spring_team4.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_team4.spring_team4.category.Category;
import spring_team4.spring_team4.category.CategoryRepository;
import java.util.List;

>>>>>>> Stashed changes
@RestController
@RequestMapping("/api/product")
public class ProductController {

<<<<<<< Updated upstream
    @Autowired
    private ProductService productService;
=======
    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;
    private final
    public ProductController(ProductRepository productRepo,
                             CategoryRepository categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

>>>>>>> Stashed changes

   //상품삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/category")
    public ResponseEntity<Product> addCategory(
            @RequestParam Long productId,
            @RequestParam Long categoryId
    ) {
        Product updated = productService.addCategory(productId, categoryId);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/category")
    public ResponseEntity<Product> removeCategory(
            @RequestParam Long productId,
            @RequestParam Long categoryId
    ) {
        Product updated = productService.removeCategory(productId, categoryId);
        return ResponseEntity.ok(updated);
    }
}
