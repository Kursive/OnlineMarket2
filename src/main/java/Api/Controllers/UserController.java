package Api.Controllers;

import Application.DTO.UserDto.UserRequest;
import Application.DTO.UserDto.UserResponse;
import Application.Services.UserService;
import Domain.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController
{
    private  final UserService userService;

    @GetMapping
    public List<UserResponse> getAll()
    {
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public UserResponse getbyid(@Valid @PathVariable UUID id)
    {
        return  userService.getById(id);
    }
    @PostMapping
    public  User create(@Valid @RequestBody UserRequest request)
    {
        return userService.create(request);
    }
    @PutMapping
    public  User update(@Valid @RequestBody UserRequest request,@PathVariable UUID id)
    {
        return  userService.update(id,request);
    }

    @DeleteMapping("/{id}")
    public  void delete(@Valid @PathVariable UUID id)
    {
        userService.remove(id);
    }

}
