package spring_team4.spring_team4.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<String> addToCart(@RequestBody Cart cart) {
        boolean isAdded = cartService.addProductToCart(cart);
        if (isAdded) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Product added to cart.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add product to cart.");
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getCartItems(
            @RequestParam(required = false) Long productId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long userId) {
        List<Cart> cartItems = cartService.getCartItems(productId, categoryId, userId);
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping
    public ResponseEntity<String> removeFromCart(@RequestBody List<Long> cartIds) {
        boolean isRemoved = cartService.removeProductsFromCart(cartIds);
        if (isRemoved) {
            return ResponseEntity.ok("Products removed from cart.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to remove products from cart.");
    }
}
