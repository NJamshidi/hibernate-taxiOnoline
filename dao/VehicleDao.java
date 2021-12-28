package tamrintaxi.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import tamrintaxi.model.vehicle.Vehicle;

import java.util.List;

public class VehicleDao extends BaseDao{
    public int getId(String plaque) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Vehicle> query = session.createQuery("from Vehicle v where v.plaque=:plaque", Vehicle.class);
        query.setParameter("plaque", plaque);
        List<Vehicle> list = query.list();
        transaction.commit();
        session.close();
        return list.size() > 0 ? list.get(0).getId() : -1;
    }

    public boolean isObjectFound(String plaque) {
        return getId(plaque) > 0;
    }

    public void addNewVehicle(Vehicle vehicle) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(vehicle);
        transaction.commit();
        session.close();
    }
}
