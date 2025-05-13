package spring_team4.spring_team4.order;

import spring_team4.spring_team4.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // 특정 사용자의 게시글 목록 조회
    List<Order> findAllByUser(User user);
}
