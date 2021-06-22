package com.vm.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vm.entity.Product;

public class App {

	public static void main(String[] args) {
		
		
		
SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		 
		  //in employee.cfg.xml
		  //create->if table not there will create ,if there it drop that table and will create again
		  //update->if table not there will create ,if there will update it.
		Product prd=new Product();
		prd.setId(1);
		prd.setName("laptops");
		prd.setPrice(50000);
		prd.setCategory("electronics");
		
		Product prd1=new Product();
		prd1.setId(2);
		prd1.setName("apple");
		prd1.setPrice(50);
		prd1.setCategory("fruits");
		
		
		
	//object is sending to database(persist state)->it can a row in the database	
		session.save(prd);
		session.save(prd1);
		transaction.commit();
		session.close();
	}
}
