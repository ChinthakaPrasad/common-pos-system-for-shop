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
    public boolean updateProduct(Product p, int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.find(Product.class, id);
        product.setProductName(p.getProductName());
        product.setSellingUnitPrice(p.getSellingUnitPrice());
        product.setBuyingUnitPrice(p.getBuyingUnitPrice());
        product.setSupplier(p.getSupplier());
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

    public Product getProduct(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.find(Product.class, id);
        session.close();
        return product;

    }

    public Product getProduct(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Product WHERE productName = :value";
        Query query = session.createQuery(hql);
        query.setParameter("value", name);

        Product result = (Product) query.uniqueResult();
        return result;
    }
}
