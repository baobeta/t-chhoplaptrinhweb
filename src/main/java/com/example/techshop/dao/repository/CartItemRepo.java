package com.example.techshop.dao.repository;

import com.example.techshop.dao.AbstractDao;
import com.example.techshop.entity.CartItemEntity;
import com.example.techshop.entity.ShoppingSessionEntity;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.HibernateUtil;

import com.example.techshop.utils.STRepoUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CartItemRepo extends AbstractDao<Integer, CartItemEntity> {

  public void addProduct(int cusId){
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();

    try {
      String queryString = "FROM ShoppingSessionEntity s WHERE s.userEntity.userId = :cusId";
      Query query = session.createQuery(queryString);
      query.setParameter("cusId",cusId);
      ShoppingSessionEntity shoppingSession = (ShoppingSessionEntity)query.uniqueResult();
      if (shoppingSession ==null){
        ShoppingSessionEntity newSession = new ShoppingSessionEntity();
        UserEntity user = STRepoUtil.getUserRepo().findById(cusId);
        newSession.setUserEntity(user);
        newSession.setTotal(0);
        STRepoUtil.getShoppingSessionRepo().save(newSession);
      }
    }catch (HibernateException e){
      throw e;
    }
  }
}
