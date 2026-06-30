package Domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String email;

    private String password;

    public User(String name, String email, String password)
    {

        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Ошибка имени");

        if (email == null || email.isBlank() && !email.contains("@"))
            throw new IllegalArgumentException("Ошибка почты");

        if (password == null || password.isBlank())
            throw new IllegalArgumentException("Ошибка пароля");

        this.name = name;
        this.email = email;
        this.password = password;
    }
}


