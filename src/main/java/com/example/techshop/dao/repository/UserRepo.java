package com.example.techshop.dao.repository;

import com.example.techshop.dao.AbstractDao;
import com.example.techshop.entity.ShoppingSessionEntity;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.HibernateUtil;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserRepo extends AbstractDao<Integer, UserEntity> {

  public UserEntity findUser(String email, String password) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      StringBuilder sql = new StringBuilder(
          "FROM UserEntity ue WHERE ue.email= :email AND ue.password= :password ");
      Query query = session.createQuery(sql.toString());
      query.setParameter("email", email);
      query.setParameter("password", password);
      if (query.getSingleResult() != null) {
        UserEntity entity = (UserEntity) query.getSingleResult();
        return entity;
      }
    } catch (HibernateException e) {
      e.printStackTrace();
    }
    return null;
  }

  public ShoppingSessionEntity findSessionById(Integer cusId) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      String queryString = "FROM ShoppingSessionEntity s WHERE s.userEntity.userId = :cusId";
      org.hibernate.query.Query query = session.createQuery(queryString);
      query.setParameter("cusId", cusId);
      ShoppingSessionEntity shoppingSession = (ShoppingSessionEntity) query.uniqueResult();
      if (shoppingSession != null) {
        return shoppingSession;
      }
    } catch (HibernateException e) {
      throw e;
    }
    return null;
  }
}
