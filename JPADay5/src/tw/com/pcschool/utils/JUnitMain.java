/*
*
*Copyright (c) 2020, pcschool
*/

package tw.com.pcschool.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.ejb.QueryHints;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories;

import tw.com.pcschool.beans.Category;
import tw.com.pcschool.beans.Customer;
import tw.com.pcschool.beans.Department;
import tw.com.pcschool.beans.Item;
import tw.com.pcschool.beans.Manager;

/**
 *
 * @author EricYang 課程大綱:
 *
 */

public class JUnitMain {
	EntityManagerFactory entityManagerFactory ;
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	@Before
	public void init() {
		// 1.創建一個管理工廠類
		String persistenceUnitName = "JPADay5";
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		// 2.創建一個管理類
		  entityManager = entityManagerFactory.createEntityManager();
		// 3.開啟事務
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		// 4.建立beans結構
	}
	
	/*
	 * 1.JPQL
	 * 2.JPA
	 * 3.SQL
	 */
	
	
	@Test
	public void testLeftOuterJoinFetch() {
		String jpql = "FROM Customer c where c.id=?";
		Customer customers=(Customer)entityManager.createQuery(jpql).getResultList();
		System.out.println(customers);
	}
	
	
	@Test
	public void testGroupBy() {
		String jpql = "SELECT i.customer FROM Item i GROUP BY i.customer having count(i.id)>2";
		List<Customer> customers=entityManager.createQuery(jpql).getResultList();
		System.out.println(customers);
	}
	
	@Test
	public void testOrderBy() {
		String jpql="FROM Customer c where c.age> ? Order By c.age DESC";
		Query query=entityManager.createQuery(jpql);
		
		query.setParameter(1, 2);
		List<Customer> customers=query.getResultList();
		
		System.out.println(customers);
		
	}
	
	
	
	@Test
	public void testQueryCache() { //hibernate
		String jpql="FROM Customer c where c.age> ?";
		Query query=entityManager.createQuery(jpql).setHint(QueryHints.HINT_CACHEABLE, true);
		query.setParameter(1, 2);
		List<Customer> customers=query.getResultList();
		System.out.println(customers.size());
		
		query=entityManager.createQuery(jpql);
		query.setParameter(1, 2);
		customers=query.getResultList();
		
		System.out.println(customers.size());
	}
	
	
	
	@Test
	public void testSQL() {
		String SQL="SELECT * FROM JPA5_Customer WHERE id = ? ";
		Query query=entityManager.createNativeQuery(SQL).setParameter(1, 1);
		Object obj = query.getSingleResult();
		System.out.println(query.getSingleResult());
		
	}
	
	
	
	
	@Test
	public void testJPQL() {
		String jpql="FROM Customer c where c.age> ?";
		Query query=entityManager.createQuery(jpql);
		
		query.setParameter(1, 2);
		List<Customer> customers=query.getResultList();
		
		System.out.println(customers);
		
	}
	
	@Test
	public void testParyProperties() {
		String jpql="SELECT c.lastName,c.age  FROM Customer c where c.id > ? ";
		List list=entityManager.createQuery(jpql).setParameter(1, 1).getResultList();
		System.out.println(list);
	}
	
	@Test
	public void testParyProperties1() {
		String jpql="SELECT new Customer(c.lastName,c.age)  FROM Customer c where c.id > ? ";
		List list=entityManager.createQuery(jpql).setParameter(1, 1).getResultList();
		System.out.println(list);
	}
	
	
	@Test
	public void testNamedQuery() {
		Query query = entityManager.createNamedQuery("testNamedQuery").setParameter(1, 3);
		Customer customer = (Customer)query.getSingleResult();
		
		System.out.println(customer);
	}
	
	
	
	

	@Test
	public void testManyToMany() {
		Item i1=new Item();
		i1.setItemName("i-1");
		
		Item i2=new Item();
		i2.setItemName("i-2");
		
		Category c1=new Category();
		c1.setCategoryName("c-1");
		
		Category c2=new Category();
		c2.setCategoryName("c-2");
		
		
		i1.getCategorys().add(c1);
		i1.getCategorys().add(c2);
		
		i2.getCategorys().add(c1);
		i2.getCategorys().add(c2);
		
		c1.getItems().add(i1);
		c1.getItems().add(i2);
		
		c2.getItems().add(i1);
		c2.getItems().add(i2);
		
		entityManager.persist(i1);
		entityManager.persist(i2);
		entityManager.persist(c1);
		entityManager.persist(c2);
		
		
		
	}
	
	
	@Test
	public void testOneToOneFind1() {
		Manager mag=entityManager.find(Manager.class, 2);
		System.out.println(mag.getMgrName());
		System.out.println(mag.getDept().getClass().getName());
	}
	
	
	
	@Test
	public void testOneToOneFind() {
		Department dep=entityManager.find(Department.class, 2);
		System.out.println(dep.getDeptName());
		System.out.println(dep.getMgr().getClass().getName());
	}
	
	
	
	
	@Test
	public void testOneToOne() {
		Manager mgr=new Manager();
		mgr.setMgrName("M-BB");
		
		
		Department dep=new Department();
		dep.setDeptName("D-BB");
		
		//關聯
		mgr.setDept(dep);
		dep.setMgr(mgr);
		
		
		entityManager.persist(dep);
		entityManager.persist(mgr);
		
	}
	
	
	@Test
	public void getCustomer() {
		Customer customer=new Customer();
		customer.setAge(34);
		customer.setEmail("eric@gmail.com.tw");
		customer.setLastName("Yang");
		
		entityManager.persist(customer);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@After
	public void destory() {
		
		//5.提交事務
		entityTransaction.commit();
		//6.關閉管理類
		entityManager.close();
		//7.關閉管理工廠類
		entityManagerFactory.close();
	}

}
