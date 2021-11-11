package com.example.techshop.dao.repository;

import com.example.techshop.dao.AbstractDao;
import com.example.techshop.entity.BrandEntity;
import com.example.techshop.entity.CategoryEntity;
import com.example.techshop.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class CategoryRepo extends AbstractDao<Integer, CategoryEntity> {

  public List<BrandEntity> getBrandInCate(Integer cateId) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<BrandEntity> brandList = new ArrayList<BrandEntity>();
    try {
      String queryString = "SELECT DISTINCT p.brandEntity FROM ProductEntity p WHERE p.categoryEntity.categoryId = :cateId ";
      Query query = session.createQuery(queryString);
      query.setParameter("cateId", cateId);
      brandList = (List<BrandEntity>) query.getResultList();
    } catch (HibernateException e) {
      throw e;
    } finally {
      session.close();
    }
    return brandList;
  }

}
