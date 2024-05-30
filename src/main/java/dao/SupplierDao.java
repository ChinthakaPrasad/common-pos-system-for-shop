package dao;

import entity.Customer;
import entity.Supplier;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SupplierDao {
    public boolean saveSupplier(Supplier s){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(s);
        transaction.commit();
        session.close();
        return true;

    }
    public boolean updateSupplier(Supplier s){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Supplier supplier = session.find(Supplier.class, s.getSupplierId());
        supplier.setSupplierName(s.getSupplierName());
        supplier.setPhoneNumber(s.getPhoneNumber());
        supplier.setAddress(s.getAddress());
        supplier.setEmail(s.getEmail());
        supplier.setRemarks(s.getRemarks());
        session.save(supplier);
        transaction.commit();
        session.close();
        return true;
    }
    public boolean deleteSupplier(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(Supplier.class, id));
        transaction.commit();
        session.close();
        return true;
    }

    public List<Supplier> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Supplier");
        List<Supplier> list = query.list();
        session.close();
        return list;
    }
}
