package com.example.techshop.dao.repository;

import com.example.techshop.dao.AbstractDao;
import com.example.techshop.entity.CartItemEntity;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.entity.ShoppingSessionEntity;
import com.example.techshop.utils.HibernateUtil;

import com.example.techshop.utils.STRepoUtil;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class CartItemRepo extends AbstractDao<Integer, CartItemEntity> {

  public boolean addProductToCart(Integer cusId, Integer productId) {
    try { 
      ShoppingSessionEntity sessionEntity = STRepoUtil.getUserRepo().findSessionByCusId(cusId);
      if (sessionEntity == null) {
        //Neu khong tim thay session thi tao moi
        sessionEntity = new ShoppingSessionEntity();
        sessionEntity.setUserEntity(STRepoUtil.getUserRepo().findById(cusId));
        sessionEntity.setTotal(0);
        STRepoUtil.getShoppingSessionRepo().save(sessionEntity);
      }
      //Kiem tra xem da ton tai cart cua san pham do hay chua
      CartItemEntity cartItem = findCartItem(sessionEntity.getSessionId(), productId);
      //Neu co thi tang len 1
      if (cartItem != null) {
        if (isEnoughAmount(productId, 1)) {
          cartItem.setQuantity(cartItem.getQuantity() + 1);
          STRepoUtil.getCartItemRepo().update(cartItem);
          updateProductQuantity(productId, 1);
          return true;
        } else {
          return false;
        }
      }
      //Neu chua co thi tao moi
      if (isEnoughAmount(productId, 1)) {
        cartItem = new CartItemEntity();
        cartItem.setShoppingSessionEntity(sessionEntity);
        cartItem.setProductEntity(STRepoUtil.getProductRepo().findById(productId));
        cartItem.setQuantity(1);
        cartItem.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        STRepoUtil.getCartItemRepo().save(cartItem);
        updateProductQuantity(productId, 1);
        return true;
      }
    } catch (HibernateException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean updateCartItem(Integer cusId, Integer productId, int quantity) {
    try {
      ShoppingSessionEntity session = STRepoUtil.getUserRepo().findSessionByCusId(cusId);
      Integer sessionId = session.getSessionId();
      if (sessionId != null) {
        //Tim item trong session
        CartItemEntity cartItem = findCartItem(sessionId, productId);
        //Lay so thay doi cua san pham
        int changedQuantity = quantity - cartItem.getQuantity();
        if (cartItem != null && isEnoughAmount(productId, changedQuantity)) {
          cartItem.setQuantity(quantity);
          STRepoUtil.getCartItemRepo().update(cartItem);
          updateProductQuantity(productId, changedQuantity);
          return true;
        }
      }
    } catch (HibernateException e) {
      throw e;
    }
    return false;
  }

  public void updateProductQuantity(Integer productId, int changedQuantity) {
    try {
      ProductEntity product = STRepoUtil.getProductRepo().findById(productId);
      product.setQuantity(product.getQuantity() - changedQuantity);
      STRepoUtil.getProductRepo().update(product);
    }catch (HibernateException e){
      throw e;
    }

  }

  public boolean deleteCartItem(Integer cusId, Integer productId) {
    try {
      ShoppingSessionEntity session = STRepoUtil.getUserRepo().findSessionByCusId(cusId);
      Integer sessionId = session.getSessionId();
      Integer cartItemId = findCartItem(sessionId, productId).getCartItemId();
      STRepoUtil.getCartItemRepo().delete(Collections.singletonList(cartItemId));
      return true;
    }catch (HibernateException e){
      throw e;
    }
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
    } finally {
      session.close();
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

  public List<CartItemEntity> getCartItemsByCusId(Integer cusId) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Integer sessionId = STRepoUtil.getUserRepo().findSessionByCusId(cusId).getSessionId();
    List<CartItemEntity> cartItems = new ArrayList<CartItemEntity>();
    try {
      String queryString = "FROM CartItemEntity c WHERE c.shoppingSessionEntity.sessionId = :sessionId ";
      Query query = session.createQuery(queryString);
      query.setParameter("sessionId", sessionId);
      cartItems = (List<CartItemEntity>) query.getResultList();

    } catch (HibernateException e) {
      throw e;
    } finally {
      session.close();
    }
    return cartItems;
  }

  public void addCartInCookieToCus(Integer cusId, HttpServletRequest request,
      HttpServletResponse response) {
    Cookie[] cookies = request.getCookies();
    ShoppingSessionEntity sessionEntity = STRepoUtil.getUserRepo().findSessionByCusId(cusId);
    for (Cookie cookie : cookies) {
      if (cookie.getName().contains("productId")) {
        Integer productId = Integer.parseInt(cookie.getValue());
        addProductToCart(cusId, productId);
      }
    }
    for (Cookie cookie: cookies) {
      if(cookie.getName().contains("productId")){
        cookie.setMaxAge(0);
        cookie.setPath("/cart");
        response.addCookie(cookie);
      }
    }
  }
}
