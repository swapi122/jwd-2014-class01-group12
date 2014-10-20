package vn.edu.hcmute.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vn.edu.hcmute.entity.Concept;
import vn.edu.hcmute.entity.ConceptMap;

public class ConceptDAO {

	private static SessionFactory sessionFactory;
	private static Session session;
	private Transaction transaction = null;

	public ConceptDAO() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public int addConcept(Concept concept) {
		session = sessionFactory.openSession();
		int tmp=0;
		try {
			transaction = session.beginTransaction();
			tmp=Integer.parseInt(session.save(concept).toString());
			transaction.commit();
		} catch (HibernateException ex) {
			if (transaction == null)
				transaction.rollback();
			//ex.printStackTrace();
		} finally {
			session.close();
		}

		return tmp;
	}
	
	public Concept getConceptByID(long ID) {
		session = sessionFactory.openSession();
		return (Concept) session.get(Concept.class, ID);
		
	}


}
