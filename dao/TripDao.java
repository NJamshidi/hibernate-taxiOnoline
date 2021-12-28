package tamrintaxi.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import tamrintaxi.model.trip.Trip;

import java.util.List;

public class TripDao extends BaseDao{
    public Trip findTripByDriverId(int driverId) {
        Session session = sessionFactory.openSession();
        List<Trip> result;
        session.beginTransaction();
        Query<Trip> query = session.createQuery("from Trip t where t.driver.id=:id", Trip.class);
        query.setParameter("id", driverId);
        result = query.list();
        assert result != null;
        try {
            return result.get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
