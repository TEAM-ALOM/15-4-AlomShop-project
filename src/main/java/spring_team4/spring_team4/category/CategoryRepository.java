package spring_team4.spring_team4.category;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_team4.spring_team4.category.dto.CategoryRequest;
import spring_team4.spring_team4.user.User;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
