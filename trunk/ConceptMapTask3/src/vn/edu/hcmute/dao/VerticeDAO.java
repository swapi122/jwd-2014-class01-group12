package vn.edu.hcmute.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import vn.edu.hcmute.entity.Vertice;
import vn.edu.hcmute.util.HibernateUtil;

public class VerticeDAO {
	private static SessionFactory sessionFactory;
    private static Session session;
    private Transaction transaction = null;
    
    public VerticeDAO() {
    	sessionFactory=HibernateUtil.getSessionFactory();
    }
    
    //Get All Vertices
    @SuppressWarnings("unchecked")
	public List<Vertice> getAllVertice() {
        
    	List<Vertice> listVertice = null;
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            listVertice = session.createCriteria(Vertice.class).list();
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction == null)
                transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return listVertice;
    }
    
    //Add Vertice 
    public boolean addVertice(Vertice vertice) {
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.save(vertice);
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
    
    //Edit Vertice 
    public boolean updateVertice(Vertice vertice) {
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.update(vertice);
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
