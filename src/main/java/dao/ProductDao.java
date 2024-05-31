package dao;

import entity.Customer;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDao {
    public boolean saveProduct(Product p){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(p);
        transaction.commit();
        session.close();
        return true;

    }
    public boolean updateProduct(Product p){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.find(Product.class, p.getProductId());
        product.setProductName(p.getProductName());
        product.setUnitPrice(p.getUnitPrice());
        product.setUnitType(p.getUnitType());
        product.setRemarks(p.getRemarks());
        session.save(product);
        transaction.commit();
        session.close();
        return true;
    }
    public boolean deleteProduct(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(Product.class, id));
        transaction.commit();
        session.close();
        return true;
    }

    public List<Product> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Product");
        List<Product> list = query.list();
        session.close();
        return list;
    }
}
