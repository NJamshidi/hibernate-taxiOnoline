package tamrintaxi.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import tamrintaxi.model.person.Driver;

import java.util.List;

public class DriverDao extends  BaseDao{
    public int getId(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Driver d where d.id=:id";
        Query<Driver> query = session.createQuery(hql, Driver.class);
        query.setParameter("id", id);
        List<Driver> list = query.list();
        transaction.commit();
        session.close();
        return list.size() > 0 ? list.get(0).getId() : -1;
    }

    public boolean isObjectFound(String id) {
        return getId(id) > 0;
    }
}
