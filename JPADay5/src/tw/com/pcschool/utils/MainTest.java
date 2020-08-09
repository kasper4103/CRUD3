/*
*
*Copyright (c) 2020, pcschool
*/

package tw.com.pcschool.utils;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import tw.com.pcschool.beans.Customer;

/**
 *
 * @author  EricYang
 *  課程大綱:
 *
*/

public class MainTest {

	public static void main(String[] args) {
		//1.創建一個管理工廠類
		String persistenceUnitName="JPADay01";
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory(persistenceUnitName);
		//2.創建一個管理類
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		//3.開啟事務
		EntityTransaction entityTransaction= entityManager.getTransaction();
		entityTransaction.begin();
		//4.建立beans結構
		
		Customer customer=new Customer();
		customer.setAge(12);
		customer.setEmail("eric@gmail.com");
		customer.setLastName("Tom");
		
		entityManager.persist(customer);
		
	
		
		//5.提交事務
		entityTransaction.commit();
		//6.關閉管理類
		entityManager.close();
		//7.關閉管理工廠類
		entityManagerFactory.close();
		
	}

}
