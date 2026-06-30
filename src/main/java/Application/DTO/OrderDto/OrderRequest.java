package Application.DTO.OrderDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderRequest(String name, LocalDateTime orderDate, BigDecimal price)
{}
