package spring_team4.spring_team4.product.dto;

import lombok.*;

@Getter
@Setter
public class ProductRequest {
    private Long ProductId;
    private Long CategoryId;
    private String productName;
}
