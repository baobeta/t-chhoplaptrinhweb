package com.example.techshop.dao;

import com.example.techshop.utils.HibernateUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import javassist.tools.rmi.ObjectNotFoundException;
import org.hibernate.*;
import org.hibernate.criterion.Order;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID,T>{

  private final Class<T> persistenceClass;

  public AbstractDao() {
    this.persistenceClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
  }
  public String getPersistenceClassName() {
    return this.persistenceClass.getSimpleName();
  }

  @Override
  public List<T>  findAll() {
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

//  // @page: 1, 2, ..
//  public Map<String,Object> PaginationResult(String params, int page, int maxResult, int maxNavigationPage) {
//
//    int thistotalRecords;
//    int thiscurrentPage;
//    List<T> thislist;
//    int thismaxResult;
//    int thistotalPages;
//    int thismaxNavigationPage;
//    List<Integer> thisnavigationPages;
//    Map<String, Object> returnValue = new HashMap<>();
//    Session session = HibernateUtil.getSessionFactory().openSession();
//    Transaction transaction = session.beginTransaction();
//
//
//    String sql = "Select e from " + persistenceClass + " e " //
//            + " Where e."+params+"> :"+"params";
//    org.hibernate.query.Query<T> query = session.createQuery(sql,persistenceClass);
//    query.setParameter(params, 100);
//
//
//
//    final int pageIndex = page - 1 < 0 ? 0 : page - 1;
//
//    int fromRecordIndex = pageIndex * maxResult;
//    int maxRecordIndex = fromRecordIndex + maxResult;
//
//    ScrollableResults resultScroll = query.scroll(ScrollMode.SCROLL_INSENSITIVE  );
//
//    List<T> results = new ArrayList<T>();
//
//    boolean hasResult =   resultScroll.first();
//
//    if (hasResult) {
//
//      // Scroll to position:
//      hasResult = resultScroll.scroll(fromRecordIndex);
//
//      if (hasResult) {
//        do {
//          T record = (T) resultScroll.get(0);
//          results.add(record);
//        } while (resultScroll.next()//
//                && resultScroll.getRowNumber() >= fromRecordIndex
//                && resultScroll.getRowNumber() < maxRecordIndex);
//
//      }
//
//      // Go to Last record.
//      resultScroll.last();
//    }
//
//    // Total Records
//    thistotalRecords = resultScroll.getRowNumber() + 1;
//    thiscurrentPage = pageIndex + 1;
//    thislist = results;
//    thismaxResult = maxResult;
//
//    if (thistotalRecords % thismaxResult == 0) {
//      thistotalPages = thistotalRecords / thismaxResult;
//    } else {
//      thistotalPages = (thistotalRecords / thismaxResult) + 1;
//    }
//
//    thismaxNavigationPage = maxNavigationPage;
//
//    if (maxNavigationPage < thistotalPages) {
//      thismaxNavigationPage = maxNavigationPage;
//    }
//    resultScroll.close();
//
//    //=====================================================
//    /// calc Navigation pages
//    thisnavigationPages = new ArrayList<Integer>();
//
//    int current = thiscurrentPage > thistotalPages ? thistotalPages : thiscurrentPage;
//
//    int begin = current - thismaxNavigationPage / 2;
//    int end = current + thismaxNavigationPage / 2;
//
//    // The first page
//    thisnavigationPages.add(1);
//    if (begin > 2) {
//
//
//      // Using for '...'
//      thisnavigationPages.add(-1);
//    }
//
//    for (int i = begin; i < end; i++) {
//      if (i > 1 && i < thistotalPages) {
//        thisnavigationPages.add(i);
//      }
//    }
//
//    if (end < thistotalPages - 2) {
//
//      // Using for '...'
//      thisnavigationPages.add(-1);
//    }
//
//    // The last page.
//    thisnavigationPages.add(thistotalPages);
//
//    returnValue.put("totalRecords",thistotalRecords);
//    returnValue.put("currentPage",thiscurrentPage);
//    returnValue.put("list",thislist);
//    returnValue.put("maxResult",thismaxResult);
//    returnValue.put("totalPages",thistotalPages);
//    returnValue.put("maxNavigationPage",thismaxNavigationPage);
//    returnValue.put("navigationPages",thisnavigationPages);
//    return returnValue;
//  }

  public List<T> pagination(Integer pageNumber, Integer pageSize){
    List<T> listResult = new ArrayList<>();
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      String term = getPersistenceClassName();
      term =term.split("Entity")[0];
      String firstLetter = term.substring(0, 1);
      String remainingLetters = term.substring(1, term.length());
      firstLetter = firstLetter.toLowerCase();

      Criteria criteria = session.createCriteria(persistenceClass);
      criteria.setFirstResult((pageNumber - 1) * pageSize);
      criteria.setMaxResults(pageSize);
      criteria.addOrder(Order.asc(firstLetter +remainingLetters +"Id"));

      listResult = (List<T>) criteria.list();
      session.getTransaction().commit();
    }
    catch (HibernateException e) {
      e.printStackTrace();
      session.getTransaction().rollback();
    }
    return listResult;
  }
  public int Count(String params) {
    int count =0;
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      CriteriaBuilder builder = session.getCriteriaBuilder();
      CriteriaQuery<Long> query = builder.createQuery(Long.class);
      Root<T> root = query.from(persistenceClass);
      query.select(builder.count(root.get(params)));
      count = Math.toIntExact((Long) session.createQuery(query).getSingleResult());
      session.getTransaction().commit();
    }
    catch (HibernateException e) {
      e.printStackTrace();
      session.getTransaction().rollback();
    }
    return count;
  }

}
