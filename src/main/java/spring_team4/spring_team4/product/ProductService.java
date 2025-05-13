// src/main/java/spring_team4/spring_team4/product/ProductService.java
package spring_team4.spring_team4.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public void deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND
            );
        }
        productRepository.deleteById(productId);
    }

    public Product addCategory(Long productId, Long categoryId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                ));
        product.setCategoryId(categoryId);

        return productRepository.save(product);
    }


    public Product removeCategory(Long productId, Long categoryId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                ));


        if (!Objects.equals(product.getCategoryId(), categoryId)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST
            );
        }
        product.setCategoryId(0L);

        return productRepository.save(product);
    }
}
