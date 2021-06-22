package com.vm.entity;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ProductClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//         Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
//       
//     SessionFactory factory = meta.getSessionFactoryBuilder().build();  
//     Session session = factory.openSession();  
//     Transaction t = session.beginTransaction();  
	
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
     Product prd=new Product();
	
		prd.setName("fridge");
		prd.setPrice(300000);
		prd.setCategory("electronics");
		
		Transaction tx = session.beginTransaction();
	session.save(prd); 		
	
    tx.commit();  
    System.out.println("successfully saved"); 
    session.close();
     factory.close();  
    
	
	}

}
