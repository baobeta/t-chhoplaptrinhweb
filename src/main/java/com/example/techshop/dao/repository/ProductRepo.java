package com.example.techshop.dao.repository;

import com.example.techshop.command.ProductCommand;
import com.example.techshop.dao.AbstractDao;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProductRepo extends AbstractDao<Integer, ProductEntity> {

  public List<ProductEntity> getProducts(int firstIndex, Integer brandId, Integer cateId){
    List<ProductEntity> products = new ArrayList<ProductEntity>();
    Session session = HibernateUtil.getSessionFactory().openSession();
    ProductCommand command = new ProductCommand();
    String queryString = "FROM ProductEntity";
    if(brandId!=null){
      queryString+= " p where p.brandEntity.brandId= :brandId";
    }
    if (cateId!=null){
      if(brandId!=null){
        queryString+= " and p.categoryEntity.categoryId= :cateId";
      }else {
        queryString+= " where p.categoryEntity.categoryId= :cateId";
      }
    }
    Query query = session.createQuery(queryString);
    query.setParameter("brandId", brandId);
    query.setParameter("cateId", cateId);
    try {
      if (firstIndex < 0) {
        products = (List<ProductEntity>) query.getResultList();
      } else {
        products = (List<ProductEntity>) query.setFirstResult(firstIndex)
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

//  public List<ProductEntity> searchProducts(){
//    List<ProductEntity> products = new ArrayList<ProductEntity>();
//    Session session = HibernateUtil.getSessionFactory().openSession();
//
//  }
}
