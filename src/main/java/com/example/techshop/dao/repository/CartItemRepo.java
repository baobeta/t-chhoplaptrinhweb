package com.example.techshop.dao.repository;

import com.example.techshop.dao.AbstractDao;
import com.example.techshop.entity.CartItemEntity;
import com.example.techshop.entity.ShoppingSessionEntity;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.HibernateUtil;

import com.example.techshop.utils.STRepoUtil;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class CartItemRepo extends AbstractDao<Integer, CartItemEntity> {

  public void addProductToCart(Integer cusId, Integer productId) {
    try {
      ShoppingSessionEntity sessionEntity = STRepoUtil.getUserRepo().findSessionById(cusId);
      if (sessionEntity == null) {
        //Neu khong tim thay session thi tao moi
        sessionEntity = new ShoppingSessionEntity();
        sessionEntity.setUserEntity(STRepoUtil.getUserRepo().findById(cusId));
        sessionEntity.setTotal(0);
        STRepoUtil.getShoppingSessionRepo().save(sessionEntity);
      }

      CartItemEntity cartItem = findCartItem(sessionEntity.getSessionId(), productId);
      if (cartItem != null) {
        // Neu co product nay roi thi tang so luong len 1
        cartItem.setQuantity(cartItem.getQuantity() + 1);
        STRepoUtil.getCartItemRepo().update(cartItem);
      } else {
        cartItem = new CartItemEntity();
        cartItem.setShoppingSessionEntity(sessionEntity);
        cartItem.setProductEntity(STRepoUtil.getProductRepo().findById(productId));
        cartItem.setQuantity(1);
        cartItem.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        STRepoUtil.getCartItemRepo().save(cartItem);
      }
    } catch (HibernateException e) {
      throw e;
    }
  }

  public void updateCart(Integer cusId, Integer productId, int quantity) {

    try {
      //Tim session cua user
      Integer sessionId = STRepoUtil.getUserRepo().findSessionById(cusId).getSessionId();
      if (sessionId != null) {
        //Tim item trong session
        CartItemEntity cartItem = findCartItem(sessionId, productId);
        if (cartItem != null) {
          cartItem.setQuantity(quantity);
          STRepoUtil.getCartItemRepo().update(cartItem);
        }
      }
    } catch (HibernateException e) {
      throw e;
    }
  }

  public void deleteCartItem(Integer sessionId, Integer productId){
    CartItemEntity cartItem = findCartItem(sessionId,productId);
    STRepoUtil.getCartItemRepo().delete(Collections.singletonList(cartItem.getCartItemId()));
  }

  public CartItemEntity findCartItem(Integer sessionId, Integer productId) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      String queryString = "FROM CartItemEntity c WHERE c.productEntity.productId = :productId "
          + "and c.shoppingSessionEntity.sessionId = : sessionId";
      Query query = session.createQuery(queryString);
      query.setParameter("productId", productId);
      query.setParameter("sessionId", sessionId);
      CartItemEntity cartItem = (CartItemEntity) query.uniqueResult();
      if (cartItem != null) {
        return cartItem;
      } else {
        return null;
      }
    } catch (HibernateException e) {
      throw e;
    }
  }


}
