package spring_team4.spring_team4.product;

import lombok.Getter;

import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter @Setter
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    private Long category_id;
    private String product_name;
}
