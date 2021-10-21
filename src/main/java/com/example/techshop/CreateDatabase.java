package com.example.techshop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateDatabase {

  public static void main(String[] args){
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("techshop");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();

    entityTransaction.begin();

    entityTransaction.commit();
    entityManager.close();
    entityManagerFactory.close();

  }

}
