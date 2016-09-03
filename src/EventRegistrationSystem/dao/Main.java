package EventRegistrationSystem.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import EventRegistrationSystem.persistance.Utility;

public class Main {
	
	public static SessionFactory factory;
	public static Scanner sc=new Scanner(System.in);
	public static void setup(){
		try {
			Configuration configuration = new Configuration();
			configuration.configure("/resources/hibernate.cfg.xml");
			
			ServiceRegistryBuilder srBuilder = new ServiceRegistryBuilder();
			srBuilder.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = srBuilder.buildServiceRegistry();
			factory = configuration.buildSessionFactory(serviceRegistry);

		} catch (HibernateException e) {
			e.printStackTrace();
			
		}
	}
	

	
	public static void main(String[] args) throws ParseException {
		
		Utility manage=new Utility();
		setup();
				
		System.out.println("Please select your option:\n A.Add Employee. \n B.Add Event \n C.Register Events for an Employee.\n D.Display All Employee. ");
		String choice;
		choice=sc.nextLine();
		switch (choice.toUpperCase()){
		case "A" :
			
			System.out.println("Enter Name:");
			String name=sc.nextLine();
			System.out.println("Enter Id:");
			String id=sc.nextLine();
			System.out.println("Enter Date (dd/mm/yyyy:");
			String date=sc.nextLine();
			System.out.println("Enter Email:");
			String email=sc.nextLine();
			Date jdate=new SimpleDateFormat("dd/MM/yyyy").parse(date);
			System.out.println("Adding Employee...");
			manage.addEmployee(name, id, jdate, email);
			break;
		case "B" :
			
			System.out.println("Enter Title:");
			String title=sc.nextLine();
			System.out.println("Enter Description:");
			String desc=sc.nextLine();
			System.out.println("Adding Employee...");
			manage.addEvents(title, desc);
			break;
			
		case "C" :
			System.out.println("Please enter EmployeeID:");
			String mid=sc.nextLine();
            manage.registerForEvents(mid); 
            break;
         case "D" :
        	 
        	manage.getEmployeeList();
         default :
            System.out.println("Thank You!");
      
		}

		
		
	
	}

}
