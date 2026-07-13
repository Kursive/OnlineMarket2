package Api.Controllers;

import Application.DTO.OrderDto.OrderRequest;
import Application.DTO.OrderDto.OrderResponse;
import Application.Services.OrderService;
import Domain.Order;
import Domain.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController
{
    private final OrderService orderService;

    @GetMapping
    public List<OrderResponse> getAll()
    {
        return  orderService.getAll();
    }

    @GetMapping("/{id}")
    public OrderResponse getbyid(@Valid @PathVariable UUID id)
    {
        return orderService.getById(id);
    }

    @PostMapping
    public  Order create(@Valid @RequestBody OrderRequest request)
    {
        return orderService.create(request);
    }

    @PutMapping
    public  Order update(@Valid @RequestBody OrderRequest request,@PathVariable UUID id )
    {
        return  orderService.update(id,request);
    }

    @DeleteMapping("/{id}")
    public  void delete(@Valid @PathVariable UUID id)
    {
        orderService.remove(id);
    }

}
