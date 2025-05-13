package spring_team4.spring_team4.order;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_team4.spring_team4.order.dto.OrderRequest;
import spring_team4.spring_team4.order.dto.OrderResponse;
import spring_team4.spring_team4.product.Product;
import spring_team4.spring_team4.product.ProductRepository;
import spring_team4.spring_team4.user.User;
import spring_team4.spring_team4.user.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderResponse createOrder(OrderRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        Product product = productRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("제품을 찾을 수 없습니다."));

        Order order = Order.builder()
                .user(user)
                .product(product)
                .build();

        return OrderResponse.from(orderRepository.save(order));
    }

    public List<OrderResponse> getOrderByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        return orderRepository.findAllByUser(user).stream()
                .map(OrderResponse::from)
                .toList();
    }

    public OrderResponse getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("주문 내역 없음"));

        return OrderResponse.from(order);
    }

    @Transactional
    public void deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("주문 내역 없음"));

        orderRepository.delete(order);
    }
}
