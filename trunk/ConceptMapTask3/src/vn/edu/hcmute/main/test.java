package vn.edu.hcmute.main;

import vn.edu.hcmute.entity.*;
import vn.edu.hcmute.dao.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import vn.edu.hcmute.util.*;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		User user1 = new User();
		User user2 = new User();
		Permission permission1 = new Permission();
		permission1.setPermissionID(1);
		permission1.setPermissionName("Teacher");
		Permission permission2 = new Permission();
		permission2.setPermissionID(2);
		permission2.setPermissionName("Student");
		UserDAO userDAO = new UserDAO();
		user2.setEmail("student1@gmail.com");
		user2.setPassWd(MD5("123"));
		user2.setPermission(permission2);
		user1.setEmail("teacher1@gmail.com");
		user1.setPassWd(MD5("123"));
		user1.setPermission(permission1);
		userDAO.addUser(user1);
		userDAO.addUser(user2);*/
	}
	/*private static String MD5(String password) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance("MD5");
            byte[] array = md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }*/

}
