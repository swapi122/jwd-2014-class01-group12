package vn.edu.hcmute.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import vn.edu.hcmute.entity.ConceptMap;
import vn.edu.hcmute.util.HibernateUtil;

public class ConceptMapDAO {

	private static SessionFactory sessionFactory;
    private static Session session;
    private Transaction transaction = null;
    
    public ConceptMapDAO() {
    	sessionFactory=HibernateUtil.getSessionFactory();
    }
    
    //Get All Concept Map
    @SuppressWarnings("unchecked")
	public List<ConceptMap> getAllConceptMap() {
        
    	List<ConceptMap> listConceptMap = null;
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            listConceptMap = session.createQuery("from ConceptMap").list();
            //listConceptMap = session.createCriteria(ConceptMap.class).list();
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction == null)
                transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return listConceptMap;
    }
    
    //Add Concept Map
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
    
    //Edit Concept Map
    public boolean updateConceptMap(ConceptMap conceptMap) {
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.update(conceptMap);
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
    
    //Get Concept Map by ID
    public ConceptMap getConceptMapByID(String conceptMapID) {
        ConceptMap conceptMap = null;

        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(ConceptMap.class);
        criteria.add(Restrictions.eq("conceptMapID", conceptMapID));
        conceptMap = (ConceptMap) criteria.uniqueResult();

        return conceptMap;
    }
    
}
