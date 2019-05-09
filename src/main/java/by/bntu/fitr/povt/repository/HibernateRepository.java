package by.bntu.fitr.povt.repository;

import lombok.Setter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public abstract class HibernateRepository<T> {

    @Setter(onMethod_ = @Autowired)
    protected SessionFactory sessionFactory;

    public void save(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }

    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public Optional<T> find(Class<T> clazz, Integer id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(clazz, id));
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll(Class<T> clazz) {
        return sessionFactory.getCurrentSession()
                .createQuery("from " + clazz.getSimpleName())
                .list();
    }
}
