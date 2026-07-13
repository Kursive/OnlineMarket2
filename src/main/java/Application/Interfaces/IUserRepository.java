package Application.Interfaces;

import Domain.User;
import jakarta.persistence.Id;
import org.yaml.snakeyaml.events.Event;

import java.util.UUID;

public interface IUserRepository extends IGenericRepository<User, UUID>
{
}
