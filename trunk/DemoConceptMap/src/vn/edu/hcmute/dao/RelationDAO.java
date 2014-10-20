package vn.edu.hcmute.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import vn.edu.hcmute.entity.Relation;

public class RelationDAO {
	private static SessionFactory sessionFactory;
    private static Session session;
    private Transaction transaction = null;

    public RelationDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    public boolean addRelation(Relation relation) {
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.save(relation);
            transaction.commit();
            return true;
        } catch (HibernateException ex) {
            if (transaction == null)
                transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return false;
    }
}
