package com.example.techshop.dao.repository;

import com.example.techshop.command.ProductCommand;
import com.example.techshop.dao.AbstractDao;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ProductRepo extends AbstractDao<Integer, ProductEntity> {

  public List<ProductEntity> getProducts(int firstIndex) {
    List<ProductEntity> products = new ArrayList<ProductEntity>();
    Session session = HibernateUtil.getSessionFactory().openSession();
    ProductCommand command = new ProductCommand();
    String query = "FROM ProductEntity";
    try {
      if (firstIndex < 0) {
        products = (List<ProductEntity>) session.createQuery(query).getResultList();
      } else {
        products = (List<ProductEntity>) session.createQuery(query).setFirstResult(firstIndex)
            .setMaxResults(command.getMaxPageItems()).getResultList();
      }
    } catch (HibernateException e) {
      throw e;
    }
    finally {
      session.close();
    }
    return products;
  }
  public void getProductByBrandAntCate(){
    List<ProductEntity> products = new ArrayList<ProductEntity>();
    Session session = HibernateUtil.getSessionFactory().openSession();
  }

//  public List<ProductEntity> searchProducts(){
//    List<ProductEntity> products = new ArrayList<ProductEntity>();
//    Session session = HibernateUtil.getSessionFactory().openSession();
//
//  }
}
