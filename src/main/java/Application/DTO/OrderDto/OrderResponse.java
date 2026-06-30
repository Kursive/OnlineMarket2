package Application.DTO.OrderDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record OrderResponse(UUID id, String name , LocalDateTime dateTime, BigDecimal price)
{
}
