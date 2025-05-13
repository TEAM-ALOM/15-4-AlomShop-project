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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    // 1 : N, N쪽이 연관관계의 주인
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private LocalDateTime orderDate;

    @PrePersist
    public void setOrderDate() {
        this.orderDate = LocalDateTime.now();
    }
}