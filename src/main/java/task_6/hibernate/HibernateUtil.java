package task_6.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import task_6.model.Client;
import task_6.model.Device;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) initSessionFactory();
        return sessionFactory;
    }

    private static void initSessionFactory() {
        Configuration config = new Configuration();
//        config.getProperties().put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
//        config.getProperties().put("hibernate.connection.url", "jdbc:mysql://localhost/aqa_task");
//        config.getProperties().put("hibernate.connection.username", "root");
//        config.getProperties().put("hibernate.connection.password", "MS_union1908");
//        config.getProperties().put("hibernate.connection.pool_size", "2");
//        config.getProperties().put("hibernate.show_sql", "true");
//        config.getProperties().put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        config.getProperties().put("hibernate.current_session_context_class", "thread");
//        config.getProperties().put("hibernate.archive.autodetection", "class, hbm");

        try {
            Properties props = new Properties();
            props.load(new FileInputStream("src/main/resources/config.properties"));
            config.setProperties(props);
        } catch (IOException e) {
            e.printStackTrace();
        }


        config.addAnnotatedClass(Client.class);
        config.addAnnotatedClass(Device.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        System.out.println("Hibernate Java Config serviceRegistry created");

        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }
}
