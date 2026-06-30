package Application.Interfaces;

import Domain.Order;

import java.util.List;
import java.util.UUID;

public interface IGenericRepository<T>
{
    T getById(UUID id);
    T create(T entity);
    List<T> getAll();
    T update(T entity);
    void remove(T entity);
}
