package com.vm.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLDemo {

	public static void main(String[] args) {
		
	
	Configuration config= new Configuration();
	config.configure("hibernate.cfg.xml");
	SessionFactory sessionfactory=config.buildSessionFactory();
	Session session = sessionfactory.openSession();
	
	Query<Product> query=session.createQuery("from Product");//first p also as p.id or p.name
	
	List<Product> list=query.list();
	for(Product p:list)
	{
		System.out.println("Id : "+p.getId());
		System.out.println("Name: "+p.getName());
	}
	
	 list.forEach(System.out::println);
	 System.out.println("------------------------");
	 System.out.println("Select query with conditions with where clauses");
 
	 Query<Product> query2=session.createQuery("select prd from Product prd where prd.price>300000");
	 List<Product> products=query2.list();
	 products.forEach(System.out::println);
	 
	}
}