package com.example.techshop.dao;

import com.example.techshop.common.CoreConstant;
import com.example.techshop.dto.UserDTO;
import com.example.techshop.utils.HibernateUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javassist.tools.rmi.ObjectNotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID,T>{

  private Class<T> persistenceClass;

  public AbstractDao() {
    this.persistenceClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
  }
  public String getPersistenceClassName() {
    return this.persistenceClass.getSimpleName();
  }
//  private final Logger log =Logger.getLogger(this.getClass());

  @Override
  public List<T> findAll() {
    List<T> list = new ArrayList<T>();
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      //HQL
      StringBuilder sql = new StringBuilder("from ");
      sql.append(this.getPersistenceClassName());
      Query query = session.createQuery(sql.toString());
      list = query.list();
      transaction.commit();
    }
    catch (HibernateException e)
    {
      transaction.rollback();
//      log.error(e.getMessage(),e);
      throw e;
    }
    finally {
      session.close();
    }
    return list;
  }

  @Override
  public T update(T entity) {
    T result = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try{
      Object object = session.merge(entity);
      result = (T) object;
      transaction.commit();
    }
    catch (HibernateException e) {
      transaction.rollback();
//      log.error(e.getMessage(),e);
      throw e;
    }
    finally {
      session.close();
    }
    return result;
  }

  @Override
  public T save(T entity) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try{
      session.persist(entity);
      transaction.commit();
    }
    catch (HibernateException e) {
      transaction.rollback();
//      log.error(e.getMessage(),e);
      throw e;
    }
    finally {
      session.close();
    }
    return entity;
  }

  @Override
  public T findById(ID id) {
    T result = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      result = (T)session.get(persistenceClass,id);
      if(result == null) {
        new ObjectNotFoundException("NOT FOUND "+id,null);
      }
    }
    catch (Exception e) {
      transaction.rollback();
      throw e;
    }
    finally {
      session.close();
    }
    return result;
  }

  @Override
  public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, String whereClause) {
    List<T> list = new ArrayList<T>();
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Object totalItem = 0;
    Object[] nameQuery = HibernateUtil.buildNameQuery(property);
    try {
      StringBuilder sql1 = new StringBuilder("from ");
      sql1.append(getPersistenceClassName()).append(" where 1=1 ").append(nameQuery[0]);
      if (sortExpression != null && sortDirection != null) {
        sql1.append(" order by ").append(sortExpression);
        sql1.append(" " +(sortDirection.equals(CoreConstant.SORT_ASC)?"asc":"desc"));
      }
      if (whereClause != null) {
        sql1.append(whereClause);
      }
      Query query1 = session.createQuery(sql1.toString());
      setParameterToQuery(nameQuery, query1);
      if (offset != null && offset >= 0) {
        query1.setFirstResult(offset);
      }
      if (limit != null && limit > 0) {
        query1.setMaxResults(limit);
      }
      list = query1.list();
      StringBuilder sql2 = new StringBuilder("select count(*) from ");
      sql2.append(getPersistenceClassName()).append(" where 1=1 ").append(nameQuery[0]);
      if (whereClause != null) {
        sql2.append(whereClause);
      }
      Query query2 = session.createQuery(sql2.toString());
      setParameterToQuery(nameQuery, query2);
      totalItem = query2.list().get(0);
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
//      log.error(e.getMessage(), e);
      throw e;
    } finally {
      session.close();
    }
    return new Object[]{totalItem, list};
  }

  private void setParameterToQuery(Object[] nameQuery, Query query) {
    if (nameQuery.length == 3) {
      String[] params = (String[]) nameQuery[1];
      Object[] values = (Object[]) nameQuery[2];
      for (int i2 = 0; i2 < params.length ; i2++) {
        query.setParameter(params[i2], values[i2]);
      }
    }
  }

  @Override
  public Integer delete(List<ID> ids) {
    Integer count = 0;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try{
      for (ID item: ids){
        T t =  (T)session.get(persistenceClass,item);
        session.delete(t);
        count++;
      }
      transaction.commit();
    }
    catch (HibernateException e){
      transaction.rollback();
//      log.error(e.getMessage(),e);
      throw e;
    }
    finally {
      session.close();
    }
    return count;
  }

  @Override
  public T findEqualUnique(String property, Object value) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    T result =null;
    try{
      String sql = "FROM " + getPersistenceClassName() + " model WHERE model."+property+"= :value";
      Query query = session.createQuery(sql.toString());
      query.setParameter("value",value);
      result = (T) query.uniqueResult();

    }catch (HibernateException e){
      transaction.rollback();
//      log.error(e.getMessage(),e);
      throw e;
    }
    finally {
      session.close();
    }
    return result;
  }

//  public UserEntity checkLogin(String email, String password)
//  {
//    UserEntity userEntity = new UserEntity() ;
//    Session session =HibernateUtil.getSessionFactory().openSession();
//    Transaction transaction = session.beginTransaction();
//    boolean isUserExist = false;
//    String roleName = null;
//    try {
//      StringBuilder sql = new StringBuilder("FROM UserEntity ue WHERE ue.email= :email AND ue.password= :password ");
//      Query query = session.createQuery(sql.toString());
//      query.setParameter("name",email);
//      query.setParameter("password",password);
//      if(query.getResultList().size()>0) {
//        isUserExist = true;
//        userEntity = (UserEntity) query.getSingleResult();
//      }
//
//    } catch (HibernateException e)
//    {
//      transaction.rollback();
//      throw e;
//    }
//    finally {
//      session.close();
//    }
//    return userEntity;
//  }
}
