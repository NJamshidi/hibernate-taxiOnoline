package tamrintaxi.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseDao {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
}
