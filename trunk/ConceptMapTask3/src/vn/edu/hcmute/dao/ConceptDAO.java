package vn.edu.hcmute.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import vn.edu.hcmute.entity.Concept;
import vn.edu.hcmute.util.HibernateUtil;

public class ConceptDAO {
	private static SessionFactory sessionFactory;
    private static Session session;
    private Transaction transaction = null;
    
    public ConceptDAO() {
    	sessionFactory=HibernateUtil.getSessionFactory();
    }
    
    //Get All Concept
    @SuppressWarnings("unchecked")
	public List<Concept> getAllConcept() {
        
    	List<Concept> listConcept = null;
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            listConcept = session.createCriteria(Concept.class).list();
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction == null)
                transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return listConcept;
    }
    
    //Add Concept 
    public boolean addConcept(Concept concept) {
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.save(concept);
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
    
    //Edit Concept 
    public boolean updateConcept(Concept concept) {
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.update(concept);
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
    
    //Get Concept by ID
    public Concept getConceptByID(String conceptID) {
        Concept concept = null;
        
        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Concept.class);
        criteria.add(Restrictions.eq("conceptID", conceptID));
        concept=(Concept) criteria.uniqueResult();
        return concept;
    }
}
