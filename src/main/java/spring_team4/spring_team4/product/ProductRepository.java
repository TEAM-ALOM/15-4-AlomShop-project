package spring_team4.spring_team4.product;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_team4.spring_team4.category.Category;
import spring_team4.spring_team4.cart.cartStandard;
/*order 추가 예정*/
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // 카테고리별 상품 조회 (categoryId만 사용할 때) categoryId만 사용하나????
    List<Product> findByCategoryId(Long categoryId);

    // 상품명으로 단건 조회
    Optional<Product> findByProductName(String productName);

    // List<Product> findByProductNameContaining(String keyword);
}
