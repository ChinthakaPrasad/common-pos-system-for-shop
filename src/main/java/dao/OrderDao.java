package dao;

import entity.Customer;
import entity.Order;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.PreparedStatement;
import java.util.List;

public class OrderDao {
    public String getLastOrderId(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT MAX(id) FROM Order");
        String lastId=null;
        try {
            lastId =  (String) query.getSingleResult();
        }catch (NullPointerException e){
            if(lastId == null){
                return "Order 001";
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

    public List<Order> getAllOrder(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Order");
        List<Order> list = query.list();
        session.close();
        return list;
    }

    public Order getOrder(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Order order = session.find(Order.class, id);
        session.close();
        return order;
    }
    public boolean deleteOrder(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(Order.class, id));
        transaction.commit();
        session.close();
        return true;
    }


}
