package spring_team4.spring_team4.order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring_team4.spring_team4.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // 특정 사용자의 게시글 목록 조회
    List<Order> findAllByUser(User user);

    @Query("SELECT o FROM Order o WHERE "
            + "(:userId IS NULL OR o.user.userId = :userId) AND "
            + "(:productId IS NULL OR o.product.productId = :productId) AND "
            + "(:orderDate IS NULL OR DATE(o.orderDate) = :orderDate)")
    List<Order> findByConditions(
            @Param("userId") Long userId,
            @Param("productId") Long productId,
            @Param("orderDate") LocalDateTime orderDate
    );
}
