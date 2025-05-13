package spring_team4.spring_team4.order.dto;


import lombok.*;
import spring_team4.spring_team4.order.Order;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private Long orderId;
    private Long userId;
    private LocalDateTime orderDate;

    public static OrderResponse from(Order order) {
        return OrderResponse.builder()                  //builder() -> DTO를 생성 (롬복의 빌더 패턴 사용, 롬복을 이용한 편리한 객체 생성 방식), return BoardResponse -> DTO 완성본을 반환
                .orderId(order.getOrderId())
                .userId(order.getUser().getUserId())
                .orderDate(order.getOrderDate())
                .build();                               //최종 객체 생성
    }

    // 정적 팩토리 메서드(static factory method) 패턴
    // Board 엔티티를 BoardResponse DTO로 변환해주는 전용 메서드
    // 컨트롤러나 서비스에서 매번 이렇게 쓰면 중복 + 코드 지저분함
    // 그래서 from()이라는 **정적 메서드(static method)**를 만들어 변환을 깔끔하게 한 줄로
}

