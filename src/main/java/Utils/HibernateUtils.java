package Utils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.lab06.Student;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;


public class HibernateUtils {
    //connect Hibernate
    private static final SessionFactory FACTORY;
    static{
        Configuration conf=new Configuration();
        conf.addAnnotatedClass(Student.class);
        FACTORY = buildSessionFactory();
    }
    private static SessionFactory buildSessionFactory()
    {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder() //
                .configure()
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }
    public static SessionFactory getFactory() {
        return FACTORY;
    }
    public static void close() {
        getFactory().close();
    }
}

