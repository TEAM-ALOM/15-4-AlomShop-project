package spring_team4.spring_team4.order.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "주문 접수 요청 DTO")
public class OrderRequest {
    private Long userId;  // 유저 ID
}
