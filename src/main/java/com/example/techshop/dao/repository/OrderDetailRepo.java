package com.example.techshop.dao.repository;

import com.example.techshop.dao.AbstractDao;
import com.example.techshop.entity.OrderDetailEntity;
import com.example.techshop.utils.HibernateUtil;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDetailRepo extends AbstractDao<Integer, OrderDetailEntity> {


  public List<Object> getIncomeInMonth(int year) {

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      String queryString = "SELECT MONTH(o.createdDate), SUM(o.total) FROM OrderDetailEntity o WHERE YEAR(o.createdDate)= :year GROUP BY MONTH(o.createdDate)";
      Query query = session.createQuery(queryString);
      query.setParameter("year",year);
      List<Object> income = query.list();
      transaction.commit();
      return income;
    } catch (HibernateException e) {
      transaction.rollback();
      throw e;
    } finally {
      session.close();
    }
  }
}
