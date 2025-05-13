package spring_team4.spring_team4.cart;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring_team4.spring_team4.product.Product;
import spring_team4.spring_team4.user.User;

@Entity
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
