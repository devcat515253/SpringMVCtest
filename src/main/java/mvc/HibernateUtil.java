package mvc;

import mvc.model.PhonesEntity;
import mvc.model.UsersEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class HibernateUtil {

    private static SessionFactory sessionFactory ;

   public static SessionFactory getSessionFactory() {

       StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
               .configure( "hibernate.cfg.xml" )
               .build();

       Metadata metadata = new MetadataSources( standardRegistry )
               .getMetadataBuilder()
               .build();

       sessionFactory = metadata.getSessionFactoryBuilder().build();

       return sessionFactory;



   }
}
