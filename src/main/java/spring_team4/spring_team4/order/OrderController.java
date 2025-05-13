package spring_team4.spring_team4.order;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring_team4.spring_team4.order.dto.OrderRequest;
import spring_team4.spring_team4.order.dto.OrderResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @Operation(summary = "주문 접수")
    @PostMapping
    public OrderResponse createBoard(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

    @Operation(summary = "사용자 주문 목록 조회 (전체)")
    @GetMapping("/user/{userId}")
    public List<OrderResponse> getBoardsByUser(@PathVariable Long userId) {
        return orderService.getOrderByUser(userId);
    }

    @Operation(summary = "단일 주문 조회")
    @GetMapping("/{orderId}")
    public OrderResponse getOrder(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }

    @Operation(summary = "주문 취소")
    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return "주문 취소 완료";
    }


}
