package mvc.controller;



import mvc.HibernateUtil;
import mvc.model.UsersEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RESTclientListController {




    @RequestMapping(value = "/clientsUpdate",method = RequestMethod.PUT)
    public void Update(@RequestBody List<UsersEntity> users){



        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();


        for (UsersEntity user : users) {

        //session.update(user);
            try{
                NativeQuery sqlQuery = session.createNativeQuery("UPDATE phones SET phone='"+ user.getPhonesByIdPhone().getPhone() +"',  type='"+ user.getPhonesByIdPhone().getType() +"',  comment='"+ user.getPhonesByIdPhone().getComment() +"' WHERE idPhone=" + user.getPhonesByIdPhone().getIdPhone());

                sqlQuery.executeUpdate();
            }
            catch (Exception ex){}
        }

        session.getTransaction().commit();
        session.close();


    }
    @RequestMapping(value = "/clients",method = RequestMethod.GET)
    public List clients(){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<UsersEntity>  result = (List<UsersEntity>) session.createNativeQuery("select * from Users" , UsersEntity.class).getResultList();

        session.getTransaction().commit();
        session.close();

        return result;
    }


}
