package com.example.concertbooking.dao.impl;

import com.example.concertbooking.dao.AbstractHibernateDAO;
import com.example.concertbooking.dao.ConcertDAO;
import com.example.concertbooking.domain.ConcertReservation;
import com.example.concertbooking.pojo.Concert;
import com.example.concertbooking.pojo.Reservation;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("concertDAOImpl")
public class ConcertDAOImpl extends AbstractHibernateDAO<Concert> implements ConcertDAO {
    public ConcertDAOImpl(){setClazz(Concert.class);}


    @Override
    public List<Concert> getAllConcerts() {
        List<Concert> concertlist = getCurrentSession().createQuery("from Concert").getResultList();
        return concertlist;
    }

    @Override
    public Concert getConcertByID(Integer id) {
        return getCurrentSession().get( Concert.class, id);
    }

    public List<ConcertReservation> getConcertReservationByID(Integer user_id){
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<ConcertReservation> cq = cb.createQuery(ConcertReservation.class);

        Root<Reservation> pRoot = cq.from(Reservation.class);
        pRoot.join("concert", JoinType.INNER);

        cq.multiselect(
                pRoot.get("concert").get("title"),
                pRoot.get("concert").get("description"),
                pRoot.get("concert").get("start_at"),
                pRoot.get("concert").get("duration"),
                pRoot.get("user_id"),
                pRoot.get("tickets_count"),
                pRoot.get("created_at")
        );

        cq.where(pRoot.get("user_id").in(user_id));

        List<ConcertReservation> resultlist = getCurrentSession().createQuery(cq).getResultList();

        return resultlist;

    }
}
