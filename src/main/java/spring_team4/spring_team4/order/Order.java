package spring_team4.spring_team4.order;


import jakarta.persistence.*;
import lombok.*;
import spring_team4.spring_team4.product.Product;
import spring_team4.spring_team4.user.User;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    // 1 : N, N쪽이 연관관계의 주인
    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    private LocalDateTime createdAt;

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }
}