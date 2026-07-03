package Application.DTO.UserDto;

import java.util.UUID;

public record UserResponse(UUID id,String email,String name,String password)
{
}
