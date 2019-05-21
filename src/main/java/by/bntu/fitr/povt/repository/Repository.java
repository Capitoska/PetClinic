package by.bntu.fitr.povt.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    void save(T entity);

    void saveOrUpdate(T entity);

    void update(T entity);

    void delete(T entity);

    Optional<T> find(Class<T> clazz, Integer id);

    List<T> findAll(Class<T> clazz);
}
