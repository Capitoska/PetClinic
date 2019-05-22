package by.bntu.fitr.povt.repository;

import by.bntu.fitr.povt.model.DoctorCard;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


@Log4j2
@Repository
public class HibernateDoctorCardsRepository extends HibernateRepository<DoctorCard> implements DoctorCardsRepository {

    @Override
    public DoctorCard find(String card) {
        log.debug("Сравниваю ерунду с карточками доктора");
        log.debug(card);
        log.debug(sessionFactory.getCurrentSession().createQuery("from DoctorCard where card=:name").setParameter("name",card) !=null);
        return (DoctorCard)sessionFactory.getCurrentSession().createQuery("from DoctorCard where card=:name").setParameter("name",card).uniqueResult();
    }

    @Override
    public void deleteByCard(String card) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from DoctorCard where card=:card");
        query.setParameter("card", card);
        int result = query.executeUpdate();
    }
}
