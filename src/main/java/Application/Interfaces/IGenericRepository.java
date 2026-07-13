package Application.Interfaces;

import Domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface IGenericRepository<T,ID > extends JpaRepository<T,ID>
{

}
