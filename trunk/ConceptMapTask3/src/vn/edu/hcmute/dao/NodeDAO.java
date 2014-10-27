package vn.edu.hcmute.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import vn.edu.hcmute.entity.Node;
import vn.edu.hcmute.util.HibernateUtil;

public class NodeDAO {
	private static SessionFactory sessionFactory;
    private static Session session;
    private Transaction transaction = null;
    
    public NodeDAO() {
    	sessionFactory=HibernateUtil.getSessionFactory();
    }
    
    //Get All Node
    @SuppressWarnings("unchecked")
	public List<Node> getAllNode() {
        
    	List<Node> listNode = null;
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            listNode = session.createCriteria(Node.class).list();
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction == null)
                transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return listNode;
    }
    
    //Add Node
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
    
    //Edit Node
    public boolean updateNode(Node node) {
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.update(node);
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
    
    //Get Node by ID
    public Node getNodeByID(String conceptID) {
        Node node = null;

        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Node.class);
        criteria.add(Restrictions.eq("conceptID", conceptID));
        node = (Node) criteria.uniqueResult();

        return node;
    }
}
