package vn.edu.hcmute.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vn.edu.hcmute.entity.Node;

public class NodeDAO {

	private static SessionFactory sessionFactory;
    private static Session session;
    private Transaction transaction = null;

    public NodeDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    public boolean addNode(Node node) {
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.save(node);
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
