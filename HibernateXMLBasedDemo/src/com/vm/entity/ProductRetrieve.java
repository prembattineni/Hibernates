package com.vm.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javassist.tools.rmi.ObjectNotFoundException;

public class ProductRetrieve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Object o = null;
		try {
		 o=session.load(Product.class, new Integer(1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(o==null) {
			System.out.print("Object not exists");
		}
		else {
			
			Product s=(Product)o;
			System.out.println("Loaded object product name is___"+s.getName());
			System.out.println("Loaded object product name is___"+s.getCategory());
			System.out.println("Loaded object product name is___"+s.getPrice());
			
			System.out.println("Object Loaded successfully.....!!");
		}
		session.close();
		factory.close();
		
	}

}
