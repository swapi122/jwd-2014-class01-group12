package vn.edu.hcmute.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static SessionFactory sf;

	public static SessionFactory getSessionFactory() {
		try {
			sf = new AnnotationConfiguration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			throw new HibernateException(ex.getMessage());
		}
		return sf;
	}

	public static void close() {
		sf.close();
	}
}
