package dao;

import entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.PreparedStatement;

public class OrderDao {
    public int getLastOrderId(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT MAX(id) FROM Order");
        int lastId=-1;
        try {
            lastId = (int) query.getSingleResult();
        }catch (NullPointerException e){
            if(!(lastId >=0)){
                return 0;
            }
        }
        return lastId;

    }

    public boolean saveOrder(Order o){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(o);
        transaction.commit();
        session.close();
        return true;
    }


}
