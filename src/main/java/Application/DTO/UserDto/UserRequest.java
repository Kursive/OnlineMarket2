package Application.DTO.UserDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest
        (
                @NotBlank(message = "Почта не должна быть пустой")
                @Email
                String email,

                @NotBlank(message = "Имя не должно быть пустым")
                @Size(min = 4, max = 10)
                String name ,

                @NotBlank(message = "Пароль не должен быть пустым")
                @Size(min = 5, max = 20)
                String password)
{
}
