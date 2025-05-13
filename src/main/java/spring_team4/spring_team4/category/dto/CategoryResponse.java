package spring_team4.spring_team4.category.dto;

import lombok.Getter;
import lombok.Setter;
import spring_team4.spring_team4.category.Category;
import spring_team4.spring_team4.user.User;
import spring_team4.spring_team4.user.dto.UserResponse;

@Getter
@Setter
public class CategoryResponse {
    private Long categoryId;
    private String categoryName;
}
