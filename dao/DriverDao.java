package tamrintaxi.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import tamrintaxi.enumaration.UserStatus;
import tamrintaxi.model.person.Driver;

import java.util.List;

public class DriverDao extends  BaseDao{
    public int getId(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Driver> query = session.createQuery("from Driver d where d.id=:id", Driver.class);
        query.setParameter("id", id);
        List<Driver> list = query.list();
        transaction.commit();
        session.close();
        return list.size() > 0 ? list.get(0).getId() : -1;
    }

    public boolean isObjectFound(String id) {
        return getId(id) > 0;
    }

    public Driver getDriverByPersonalCode(String id) {
        int driverId = getId(id);
        Driver driver = null;
        if (driverId != -1) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            driver = session.get(Driver.class, driverId);
            transaction.commit();
            session.close();
        }
        return driver;
    }

    public Driver getDriverByLocation(String location) {
        Driver driver;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Driver> query = session.createQuery("from Driver d where d.location=:location", Driver.class);
        query.setParameter("location", location);
        List<Driver> list = query.list();
        driver = list.get(0);
        transaction.commit();
        session.close();
        return driver;
    }

    public Driver getDriverById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Driver driver = session.get(Driver.class, id);
        transaction.commit();
        session.close();
        return driver;
    }

    public List<Driver> showAllDriver() {
        List<Driver> result;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Driver> query = session.createQuery("from Driver", Driver.class);
        result = query.list();
        transaction.commit();
        session.close();
        return result;
    }

    public void update(Driver driver) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(driver);
        transaction.commit();
        session.close();
    }
    public int addNewDriver(Driver driver) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(driver);
        transaction.commit();
        session.close();
        return 1;
    }

//    public List<String> findLocationOfWaitingStatus() {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        Query<String> query = session.createQuery("select d.location from Driver d where d.userStatus=:status", String.class);
//        query.setParameter("status", UserStatus.WAITING);
//        List<String> list = query.list();
//        transaction.commit();
//        session.close();
//        return list;
//    }
}
