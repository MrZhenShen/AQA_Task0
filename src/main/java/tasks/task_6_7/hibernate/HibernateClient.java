package tasks.task_6_7.hibernate;

import org.hibernate.Session;
import tasks.task_6_7.model.Device;

public class HibernateClient {
    static Session session = HibernateUtil.getSessionFactory().openSession();
    static int idClient = 0;
    static int idDevice = 0;

    public static void main(String[] args) {
//        crudClientTest();

//        Device device = new Device(idDevice, "IPhone 12 PRO", "Smartphone", read(Client.class, idClient));
//        create(device);

//        System.out.println(read(Client.class, idDevice));

        session.beginTransaction();
        System.out.println(session.createQuery("SELECT a FROM Device a", Device.class).getResultList());
        session.getTransaction().commit();

        session.close();
    }

    private static void crudClientTest() {
//        Client client = new Client(id, "Mark", "Manson", new Date(), "QA new");
//        create(client);

//        Client readClient = read(Client.class, id);
//        readClient.setJob("QA to delete");
//        update(readClient);
//        delete(readClient);
    }

    private static void create(Object obj) {
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
    }

    private static <T> T read(Class<T> entityClass, int id) {
        session.beginTransaction();
        T obj = session.get(entityClass, id);
        session.getTransaction().commit();
        return obj;
    }

    private static void update(Object obj) {
        session.beginTransaction();
        session.update(obj);
        session.getTransaction().commit();
    }

    private static void delete(Object obj) {
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit();
    }
}
