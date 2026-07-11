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
public class UserService {

    private final IUserRepository userRepository;

    public UserResponse getById(UUID id)
    {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ошибка нахождения пользователя"));

        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getPassword()
        );
    }

    public User create(UserRequest request) {

        User user = new User(
                request.name(),
                request.email(),
                request.password()
        );

        return userRepository.save(user);
    }

    public User update(UUID id, UserRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ошибка обновления пользователя"));

        user.updateuser(
                request.name(),
                request.email(),
                request.password()
        );

        return userRepository.save(user);
    }

    public List<UserResponse> getAll()
    {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getEmail(),
                        user.getName(),
                        user.getPassword()
                ))
                .toList();
    }

    public void remove(UUID id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь не найден"));

        userRepository.delete(user);
    }
}
