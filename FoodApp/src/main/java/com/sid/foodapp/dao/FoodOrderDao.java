package com.sid.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sid.foodapp.enities.FoodOrder;

@Repository
public class FoodOrderDao
{
           @Autowired
           EntityManagerFactory emf;
           
           public void savefoodOrder(FoodOrder foodorder)
           {
        	   EntityManager em=emf.createEntityManager();
       		EntityTransaction et=em.getTransaction();
       		
       		et.begin();
       		em.persist(foodorder);
       		et.commit();
           }
           
           public FoodOrder getFoodOrderById(int id)
           {
        	   EntityManager em=emf.createEntityManager();
        	   return em.find(FoodOrder.class,id);
           }
           
           public List<FoodOrder> viewFoodOrders()
           {
        	   EntityManager em=emf.createEntityManager();
       		   Query query=em.createQuery("select f from FoodOrder f");
       		   return query.getResultList();
           }
           
           public void updatefoodOrder(FoodOrder foodOrder)
           {
        	   EntityManager em=emf.createEntityManager();
       		EntityTransaction et=em.getTransaction();
       		 et.begin();
       		 em.merge(foodOrder);
       		 et.commit();
           }
           
           public void deleteFoodOrderById(int id)
           {
        	   EntityManager em=emf.createEntityManager();
          		EntityTransaction et=em.getTransaction();
          		FoodOrder foodOrder=em.find(FoodOrder.class,id);
          		
          		et.begin();
          		em.remove(foodOrder);
          		et.commit();
           }

}
