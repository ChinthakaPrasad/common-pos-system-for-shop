package dao;

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDao {
    public boolean saveCustomer(Customer c){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(c);
        transaction.commit();
        session.close();
        return true;

    }
    public boolean updateCustomer(Customer c, int id){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.find(Customer.class, id);
        customer.setCustomerName(c.getCustomerName());
        customer.setNic(c.getNic());
        customer.setPhoneNumber(c.getPhoneNumber());
        customer.setRemarks(c.getRemarks());
        session.save(customer);
        transaction.commit();
        session.close();
        return true;
    }
    public boolean deleteCustomer(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(Customer.class, id));
        transaction.commit();
        session.close();
        return true;
    }

    public List<Customer> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Customer");
        List<Customer> list = query.list();
        session.close();
        return list;
    }

    public Customer getCustomer(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Customer WHERE customerName = :value";
        Query query = session.createQuery(hql);
        query.setParameter("value", name);

        Customer result = (Customer) query.uniqueResult();
        return result;
    }

}
