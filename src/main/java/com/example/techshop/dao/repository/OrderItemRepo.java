package com.example.techshop.dao.repository;

import com.example.techshop.command.OrderDetailCommand;
import com.example.techshop.dao.AbstractDao;
import com.example.techshop.entity.CartItemEntity;
import com.example.techshop.entity.OrderDetailEntity;
import com.example.techshop.entity.OrderItemEntity;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.HibernateUtil;
import com.example.techshop.utils.STRepoUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderItemRepo extends AbstractDao<Integer, OrderItemEntity> {

  public void convertCartItemToOrderItem(
      OrderDetailCommand command) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      Integer cusId = command.getCusId();
      List<CartItemEntity> cartItems = STRepoUtil.getCartItemRepo().getCartItemsByCusId(cusId);
      OrderDetailEntity orderDetail = newOrderDetail(command, cusId);
      List<Integer> delCartIds = new ArrayList<Integer>();

      for (CartItemEntity cartItem : cartItems) {
        OrderItemEntity orderItem = new OrderItemEntity();
        orderItem.setOrderDetailEntity(orderDetail);
        orderItem.setProductEntity(cartItem.getProductEntity());
        orderItem.setQuantiy(cartItem.getQuantity());
        delCartIds.add(cartItem.getCartItemId());
        STRepoUtil.getOrderItemRepo().save(orderItem);
      }
      STRepoUtil.getCartItemRepo().delete(delCartIds);
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      throw e;
    }
  }

  public OrderDetailEntity newOrderDetail(OrderDetailCommand command, Integer cusId) {
    OrderDetailEntity orderDetail = new OrderDetailEntity();
    try {
      UserEntity user = STRepoUtil.getUserRepo().findById(cusId);

      orderDetail.setAddress(command.getPojo().getAddress());
      orderDetail.setPhoneNumber(command.getPojo().getPhoneNumber());
      orderDetail.setTotal(command.getTotal());
      orderDetail.setUserEntity(user);
      orderDetail.setIspaid(false);

      STRepoUtil.getOrderDetailRepo().save(orderDetail);
      return orderDetail;
    } catch (HibernateException e) {
      throw e;
    }
  }

}
