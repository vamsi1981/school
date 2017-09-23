package com.pkg.dbConnection;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
public class DBConnection {

	private DBConnection(){}
	static Session s;
	public static Session getSession()	
	{	

		SessionFactory sessionFactory= null;
		try 
		{

			if(s!=null && s.isOpen())
			{
				return s;
			}
			Configuration c = new Configuration();
			sessionFactory = c.configure("hibernate.cfg.xml").buildSessionFactory();
			s = sessionFactory.openSession();

		}
		catch(Exception e)
		{
			System.out.println("DB Connection Exception"+e);
		}
		return s;
	}

}
