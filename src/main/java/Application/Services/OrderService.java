package Application.Services;

import Application.DTO.OrderDto.OrderResponse;
import Application.Interfaces.IOrderRepository;
import Application.DTO.OrderDto.OrderRequest;
import Domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final IOrderRepository orderRepository;

    public OrderResponse getById(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ошибка поиска заказа"));

        return new OrderResponse(
                order.getId(),
                order.getName(),
                order.getOrderDate(),
                order.getPrice()
        );
    }

    public Order create(OrderRequest request) {

        Order order = new Order
                (
                request.name(),
                request.price(),
                        LocalDateTime.now()
                );

        return orderRepository.save(order);
    }

    public Order update(UUID id, OrderRequest request) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ошибка обновления заказа"));

        order.updateorder(
                request.name(),
                request.price(),
                LocalDateTime.now()
        );

        return orderRepository.save(order);
    }

    public void remove(UUID id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ошибка удаления заказа"));

        orderRepository.delete(order);
    }

    public List<OrderResponse> getAll() {

        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(order -> new OrderResponse(
                        order.getId(),
                        order.getName(),
                        order.getOrderDate(),
                        order.getPrice()
                ))
                .toList();
    }

}


