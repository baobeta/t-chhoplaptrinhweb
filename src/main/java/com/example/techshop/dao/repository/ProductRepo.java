package com.example.techshop.dao.repository;

import com.example.techshop.command.ProductCommand;
import com.example.techshop.dao.AbstractDao;
import com.example.techshop.entity.BrandEntity;
import com.example.techshop.entity.CategoryEntity;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.utils.HibernateUtil;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ProductRepo extends AbstractDao<Integer, ProductEntity> {

  public List<ProductEntity> searchResult(Map<String, Object> properties) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Criteria criteria = session.createCriteria(ProductEntity.class);
    Transaction transaction = session.beginTransaction();
    List<ProductEntity> products = new ArrayList<ProductEntity>();
    try {
      for (Map.Entry property : properties.entrySet()) {
        String name = property.getKey().toString();
        if (property.getValue() != null) {
          String value = property.getValue().toString();
          //Check criteria cusId
          if (name.contains("cusId") && Integer.parseInt(value) > 0) {
            criteria.add(Restrictions.eq("brandEntity.brandId", Integer.parseInt(value)));
          }
          //Check criteria categoryId
          if (name.contains("cateId") && Integer.parseInt(value) > 0) {
            criteria.add(Restrictions.eq("categoryEntity.categoryId", Integer.parseInt(value)));
          }
          //Check criteria sort
          if (name.contains("sort") && !value.isEmpty()) {
            String[] orCriteria = value.split("-");
            if (orCriteria[1].equals("ASC")) {
              criteria.addOrder(Order.asc(orCriteria[0]));
            } else if (orCriteria[1].equals("DESC")) {
              criteria.addOrder(Order.desc(orCriteria[0]));
            }
          }
          //Check criteria name
          if (name.contains("name") && !value.isEmpty()) {
            criteria.add(Restrictions.ilike("name", "%" + value + "%"));
          }
          //Check min-max price
          if (name.contains("minPrice") && Integer.parseInt(value) > 0) {
            criteria.add(Restrictions.gt("price", Integer.parseInt(value)));
          }
          if (name.contains("maxPrice") && Integer.parseInt(value) > 0) {
            criteria.add(Restrictions.lt("price", Integer.parseInt(value)));
          }
          if (name.contains("firstIndex") && Integer.parseInt(value) > -1) {
            criteria.setFirstResult(Integer.parseInt(value));
          }
          if (name.contains("maxResult") && Integer.parseInt(value) > -1) {
            criteria.setMaxResults(Integer.parseInt(value));
          }
        }

      }
      products = criteria.list();
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      throw e;
    } finally {
      session.close();
    }
    return products;
  }

  public Map<String, Object> searchProperties(ProductCommand command) {
    Map<String, Object> properties = new HashMap<String, Object>();
    properties.put("brandId", command.getBrand().getBrandId());
    properties.put("cateId", command.getCategory().getCategoryId());
    properties.put("sort", command.getSort());
    properties.put("name", command.getSearchName());
    properties.put("minPrice", command.getMinPrice());
    properties.put("maxPrice", command.getMaxPrice());
    properties.put("firstIndex", command.getFirstIndex());
    properties.put("maxResult", command.getMaxPageItems());
    return properties;
  }

  public List<ProductEntity> getNewProducts() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Criteria criteria = session.createCriteria(ProductEntity.class);
    Transaction transaction = session.beginTransaction();
    List<ProductEntity> products = new ArrayList<ProductEntity>();
    try {
      criteria.addOrder(Order.desc("createdDate"));
      criteria.setFirstResult(0);
      criteria.setMaxResults(5);
      products = criteria.list();
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      throw e;
    }finally {
      session.close();
    }
    return products;
  }

  public List<ProductEntity> getIsSaleOffProducts(){
    Session session = HibernateUtil.getSessionFactory().openSession();
    Criteria criteria = session.createCriteria(ProductEntity.class);
    Transaction transaction = session.beginTransaction();
    List<ProductEntity> products = new ArrayList<ProductEntity>();
    try {
      criteria.add(Restrictions.eq("sale",true));
      products = criteria.list();
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      throw e;
    }finally {
      session.close();
    }
    return products;
  }

}
