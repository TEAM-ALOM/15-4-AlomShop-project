package spring_team4.spring_team4.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // 특정 사용자의 게시글 목록 조회
    //List<Board> findAllByUser(User user);
}