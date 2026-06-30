package Application.Services;

import Application.DTO.OrderDto.OrderResponse;
import Application.Interfaces.IOrderRepository;
import Application.DTO.OrderDto.OrderRequest;
import Domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService
{

    private final IOrderRepository orderRepository;

    public OrderResponse getById(UUID id)
    {
        Order order = orderRepository.getById(id);
        if (order == null)
        {
            throw new IllegalArgumentException("Ошибка поиска заказа");
        }
        return new OrderResponse(
                order.getId(),
                order.getName(),
                order.getOrderDate(),
                order.getPrice()
        );
    }
    public  Order  create (OrderRequest request)
    {
        Order order = new Order(request.name(), request.price(), request.orderDate());
        if (order == null)
        {
            throw new IllegalArgumentException("Ошибка создания заказа");
        }
        return orderRepository.create(order);
    }
    public Order update (UUID id)
    {
        Order order = orderRepository.getById(id);
        if (order == null)
        {
            throw new IllegalArgumentException("Ошибка обновления заказа");
        }
        order.updateorder(order.getName(), order.getPrice(),order.getOrderDate());
        return  orderRepository.update(order);
    }

    public  void remove(UUID id)
    {
        Order order = orderRepository.getById(id);
        if (order == null)
        {
        throw new IllegalArgumentException("Ошибка удаления заказа");
        }
        orderRepository.remove(order);
    }
    public List<OrderResponse> getAll()
    {
       List<Order> orders = orderRepository.getAll();
       return  orders.stream().map(order -> new OrderResponse
               (order.getId(),order.getName(),order.getOrderDate(),order.getPrice())).toList();
    }

}


