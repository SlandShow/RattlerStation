package com.slandshow.DAO.Impl;

import com.slandshow.DAO.TrainDAO;
import com.slandshow.models.Schedule;
import com.slandshow.models.Train;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class TrainDAOImpl<E extends Train> extends GenericDAOImpl<E> implements TrainDAO<E> {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Train getByName(String name) {
        return (Train) sessionFactory.getCurrentSession()
                .createQuery("from Train where name = :name")
                .setParameter("name", name)
                .uniqueResult();
    }

    public Schedule getLastSchedule(Train train) {
        Date date = new Date();
        List<Schedule> schedules = sessionFactory.getCurrentSession()
                .createQuery("from Schedule where train = :train and dateArrival < :date order by dateArrival desc")
                .setParameter("train", train)
                .setParameter("date", date)
                .getResultList();
        return schedules.isEmpty() ? null : schedules.get(0);
    }
}
