package vn.edu.hcmute.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import vn.edu.hcmute.entity.Relation;
import vn.edu.hcmute.util.HibernateUtil;

public class RelationDAO {
	private static SessionFactory sessionFactory;
    private static Session session;
    private Transaction transaction = null;
    
    public RelationDAO() {
    	sessionFactory=HibernateUtil.getSessionFactory();
    }
    
    //Get All Relation
    @SuppressWarnings("unchecked")
	public List<Relation> getAllRelation() {
        
    	List<Relation> listRelation = null;
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            listRelation = session.createCriteria(Relation.class).list();
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction == null)
                transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return listRelation;
    }
    
    //Add Relation
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
    
    //Edit Relation
    public boolean updateRelation(Relation relation) {
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.update(relation);
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
    
    //Get Relation by ID
    public Relation getRelationByID(String relationID) {
        Relation relation = null;

        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Relation.class);
        criteria.add(Restrictions.eq("relationID", relationID));
        relation = (Relation) criteria.uniqueResult();

        return relation;
    }
}
