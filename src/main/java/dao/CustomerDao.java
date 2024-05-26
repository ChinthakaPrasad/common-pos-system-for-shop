package dao;

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerDao {
    public static boolean saveCustomer(Customer c){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(new Customer( "chinthaka", "001","123","no",null));
        transaction.commit();
        return true;
    }

}
