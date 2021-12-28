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
}
