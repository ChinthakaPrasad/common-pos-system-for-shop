package dao;

import entity.Customer;
import entity.OrderItemDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDetailDao {
    public boolean saveOrderDetail(OrderItemDetail c){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(c);
        transaction.commit();
        session.close();
        return true;

    }
}
