package com.example.techshop.dao.repository;

import com.example.techshop.dao.AbstractDao;
import com.example.techshop.entity.CartItemEntity;
import com.example.techshop.entity.ProductEntity;
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

  public boolean addProductToCart(Integer cusId, Integer productId) {
    try {
      if(cusId == -1){

      } else {
        ShoppingSessionEntity sessionEntity = STRepoUtil.getUserRepo().findSessionByCusId(cusId);
        if (sessionEntity == null) {
          //Neu khong tim thay session thi tao moi
          sessionEntity = new ShoppingSessionEntity();
          sessionEntity.setUserEntity(STRepoUtil.getUserRepo().findById(cusId));
          sessionEntity.setTotal(0);
          STRepoUtil.getShoppingSessionRepo().save(sessionEntity);
        }
        CartItemEntity cartItem = findCartItem(sessionEntity.getSessionId(), productId);
        // Kiem tra co du so luong khong, neu co thi tang len 1
        if (cartItem != null) {
          int newQuantity = cartItem.getQuantity() + 1;
          if (isEnoughAmount(productId, newQuantity)) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            STRepoUtil.getCartItemRepo().update(cartItem);
            return true;
          } else {
            return false;
          }
        }
        if (isEnoughAmount(productId, 1)) {
          cartItem = new CartItemEntity();
          cartItem.setShoppingSessionEntity(sessionEntity);
          cartItem.setProductEntity(STRepoUtil.getProductRepo().findById(productId));
          cartItem.setQuantity(1);
          cartItem.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
          STRepoUtil.getCartItemRepo().save(cartItem);
          return true;
        }
      }

    } catch (HibernateException e) {
      throw e;
    }
    return false;
  }

  public boolean updateCartItem(Integer sessionId, Integer productId, int quantity) {
    try {
      if (sessionId != null) {
        //Tim item trong session
        CartItemEntity cartItem = findCartItem(sessionId, productId);
        if (cartItem != null && isEnoughAmount(productId, quantity)) {
          cartItem.setQuantity(quantity);
          STRepoUtil.getCartItemRepo().update(cartItem);
          return true;
        }
      }
    } catch (HibernateException e) {
      throw e;
    }
    return false;
  }

  public boolean deleteCartItem(Integer sessionId, Integer productId) {
    Integer cartItemId = findCartItem(sessionId, productId).getCartItemId();
    STRepoUtil.getCartItemRepo().delete(Collections.singletonList(cartItemId));
    return true;
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

  public boolean isEnoughAmount(Integer productId, int quantity) {
    ProductEntity product = STRepoUtil.getProductRepo().findById(productId);
    if (product.getQuantity() >= quantity) {
      return true;
    } else if (product.getQuantity() == 0) {
      return false;
    }
    return false;
  }
}
