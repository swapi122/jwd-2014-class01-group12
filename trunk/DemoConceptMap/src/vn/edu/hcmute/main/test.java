package vn.edu.hcmute.main;

import org.hibernate.Session;

import vn.edu.hcmute.util.HibernateUtil;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		 
		session.beginTransaction();
		session.getTransaction().commit();
	}

}
