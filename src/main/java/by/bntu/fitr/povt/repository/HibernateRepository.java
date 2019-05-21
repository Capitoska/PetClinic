package by.bntu.fitr.povt.repository;

import lombok.Setter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class HibernateRepository<T> implements Repository<T> {

    @Setter(onMethod_ = @Autowired)
    protected SessionFactory sessionFactory;

    @Override
    public void save(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public Optional<T> find(Class<T> clazz, Integer id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(clazz, id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll(Class<T> clazz) {
        return sessionFactory.getCurrentSession()
                .createQuery("from " + clazz.getSimpleName())
                .list();
    }
}
