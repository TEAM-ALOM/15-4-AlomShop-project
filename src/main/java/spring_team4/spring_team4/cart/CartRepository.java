package spring_team4.spring_team4.cart;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByProductProductId(Long productId);
    List<Cart> findByProductCategoryId(Long categoryId);
    List<Cart> findByUserUserId(Long userId);
}
