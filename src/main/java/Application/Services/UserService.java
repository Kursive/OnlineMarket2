package Application.Services;

import Application.DTO.UserDto.UserRequest;
import Application.DTO.UserDto.UserResponse;
import Application.Interfaces.IUserRepository;
import Domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserService
{
private final IUserRepository _userRepository;

public UserResponse getbyid(UUID id)
{
    User user = _userRepository.getById(id);
    if (user == null)
    {
        throw  new IllegalArgumentException("Ошибка нахождения пользователя");
    }
    return  new UserResponse(user.getId(), user.getEmail(), user.getEmail(), user.getPassword());
}

public User create(UserRequest request)
{
    User user = new User(request.email(),request.name(),request.password());
    if (user == null)
    {
        throw new IllegalArgumentException("Ошибка создания пользователя");
    }
    return  _userRepository.create(user);

}

public  User update(UUID id)
{
    User user = _userRepository.getById(id);
    if (user == null)
    {
        throw new IllegalArgumentException("Ошибка обновления пользователя");
    }
    user.updateuser(user.getName(),user.getEmail(),user.getPassword());
    return _userRepository.update(user);
}

public List<UserResponse> getAll()
{
    List<User> users = _userRepository.getAll();
    if (users == null)
    {
        throw new IllegalArgumentException("Ошибка получения всех пользвателей");
    }
    return users.stream().map(user -> new UserResponse
            (user.getId(),user.getEmail(),user.getName(),user.getPassword())).toList();
}

public  void remove(UUID id)
{
    User user = _userRepository.getById(id);
    if (user == null )
    {
        throw new IllegalArgumentException("пользователь не найден");
    }
    _userRepository.remove(user);
}

}
