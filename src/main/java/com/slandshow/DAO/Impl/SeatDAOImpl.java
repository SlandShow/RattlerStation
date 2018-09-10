package com.slandshow.DAO.Impl;

import com.slandshow.DAO.SeatDAO;
import com.slandshow.models.Seat;
import com.slandshow.models.Train;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SeatDAOImpl<E extends Seat> extends GenericDAOImpl<E> implements SeatDAO<E> {

    @Autowired
    private SessionFactory sessionFactory;

    public Seat getByTrainAndCarriageAndSeat(Train train, Integer carriage, Integer seat) {
        return (Seat) sessionFactory.getCurrentSession()
                .createQuery("from Seat where " +
                        "train = :train and seat = :seat and carriage = :carriage")
                .setParameter("train", train)
                .setParameter("seat", seat)
                .setParameter("carriage", carriage)
                .uniqueResult();

    }

}
