package Application.DTO.OrderDto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderRequest(

        @NotBlank(message = "Название заказа не должно быть пустым")
        @Size(min = 4, max = 10, message = "Название должно содержать от 4 до 10 символов")
        String name,



        @NotNull(message = "Цена обязательна")
        @DecimalMin(value = "0.01", message = "Цена должна быть больше 0")
        BigDecimal price)
{}
