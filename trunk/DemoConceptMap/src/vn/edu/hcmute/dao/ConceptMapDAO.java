package vn.edu.hcmute.dao;

import vn.edu.hcmute.entity.ConceptMap;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ConceptMapDAO {

	private static SessionFactory sessionFactory;
    private static Session session;
    private Transaction transaction = null;

    public ConceptMapDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    public boolean addConceptMap(ConceptMap conceptMap) {
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.save(conceptMap);
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
