package testFramework.hibernate;

import org.hibernate.Session;

public class HibernateClient {
    static Session session = HibernateUtil.getSessionFactory().openSession();

    public static void create(Object obj) {
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
    }

    public static <T> T read(Class<T> entityClass, int id) {
        session.beginTransaction();
        T obj = session.get(entityClass, id);
        session.getTransaction().commit();
        return obj;
    }

    public static void update(Object obj) {
        session.beginTransaction();
        session.update(obj);
        session.getTransaction().commit();
    }

    public static void delete(Object obj) {
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit();
    }
}
