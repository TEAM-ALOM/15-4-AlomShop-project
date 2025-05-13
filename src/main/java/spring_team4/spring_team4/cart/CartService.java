package spring_team4.spring_team4.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public boolean addProductToCart(Cart cart) {
        // 장바구니에 동일한 상품이 이미 있으면 추가하지 않거나, 수량 증가 로직 등을 넣을 수 있음
        cartRepository.save(cart);
        return true;
    }

    public List<Cart> getCartItems(Long productId, Long categoryId, Long userId) {
        if (productId != null) {
            return cartRepository.findByProductProductId(productId);
        }
        if (categoryId != null) {
            return cartRepository.findByProductCategoryId(categoryId);
        }
        if (userId != null) {
            return cartRepository.findByUserUserId(userId);
        }
        return cartRepository.findAll();
    }

    public boolean removeProductsFromCart(List<Long> cartIds) {
        cartRepository.deleteAllByIdInBatch(cartIds);
        return true;
    }
}
