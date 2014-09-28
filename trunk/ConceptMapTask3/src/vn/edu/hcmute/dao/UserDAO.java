package vn.edu.hcmute.dao;

import java.util.List;

import vn.edu.hcmute.entity.*;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class UserDAO {

	private static SessionFactory sessionFactory;
    private static Session session;
    private Transaction transaction = null;

    public UserDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    /**
     * list all user in database
     * @param
     * @return list<User> list of all user in database
     */
 
    @SuppressWarnings("unchecked")
    public List<User> getAllUser() {
        List<User> listUser = null;

        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            listUser = session.createCriteria(User.class).list();
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction == null)
                transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return listUser;
    }
    
    /**
     * add a new User to database
     * @param User : object of class User to add
     * @return  boolean : return true if add user successful
     */
    public boolean addUser(User user) {
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.save(user);
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

    /**
     * add a new User to database
     * @param User : object of class User to update
     * @return  boolean : return true if add user successful
     */
    public boolean updateUser(User user) {
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();
            session.update(user);
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
    
    /**
     * get a user with a identified email
     * @param String : email
     * @return  User : a User if the email is existed, else return null
     */
    public User getUserByEmail(String email) {
        User user = null;

        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        user = (User) criteria.uniqueResult();

        return user;
    }
    
    /**
     * get a user with a identified id
     * @param String : id
     * @return  User : a User if the id is existed, else return null
     */
    public User getUserByUserID(int userID) {
        User user = null;

        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("userID", userID));
        user = (User) criteria.uniqueResult();

        return user;
    }
}
