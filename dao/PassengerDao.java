package tamrintaxi.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import tamrintaxi.model.person.Passenger;

import java.util.List;

public class PassengerDao extends  BaseDao{
    public int getId(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Passenger> query = session.createQuery("from Passenger p where p.id=:id", Passenger.class);
        query.setParameter("id", id);
        List<Passenger> list = query.list();
        transaction.commit();
        session.close();
        return list.size() > 0 ? list.get(0).getId() : -1;
    }

    public boolean isObjectFound(String id) {
        return getId(id) > 0;
    }
    public Passenger returnPassengerByPersonalCode(String id) {
        int passengerId = getId(id);
        Passenger passenger = null;
        if (passengerId != -1) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            passenger = session.get(Passenger.class, passengerId);
            transaction.commit();
            session.close();
        }
        return passenger;
    }


    public Passenger returnPassengerById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Passenger passenger = session.get(Passenger.class, id);
        transaction.commit();
        session.close();
        return passenger;
    }

    public int addNewPassenger(Passenger passenger) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(passenger);
        transaction.commit();
        session.close();
        return 1;
    }

    public List<Passenger> showAllPassengers() {
        Session session = sessionFactory.openSession();
        List<Passenger> result;
        Transaction transaction = session.beginTransaction();
        String hql = "from Passenger";
        System.out.println(hql);
        Query<Passenger> query = session.createQuery(hql, Passenger.class);
        result = query.list();
        transaction.commit();
        session.close();
        return result;
    }

    public void update(Passenger passenger) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(passenger);
        transaction.commit();
        session.close();
    }
}
