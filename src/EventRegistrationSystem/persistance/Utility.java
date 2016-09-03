package EventRegistrationSystem.persistance;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import EventRegisrtationSystem.Model.Employee;
import EventRegisrtationSystem.Model.Events;
import EventRegistrationSystem.dao.Main;

public class Utility {
	public static Scanner sc=new Scanner(System.in);
	

	
	public void addEmployee(String name,String id,Date joinDate,String emailID){
		Session session=Main.factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Employee e=(Employee) session.get(Employee.class, id);
		if(e==null){
			e=new Employee(id, name, joinDate, emailID);
			session.save(e);
			System.out.println("Employee Added Successfully. \n Thank You!");
		}
		else
			System.out.println("User already Exists. \n Thank You!");
		tx.commit();
		
		session.close();
	}
	
	public void addEvents(String eventtitle,String description){
		Session session=Main.factory.openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("from Events e where "
				+ "e.eventtitle=:eventTitle");
		query.setString("eventTitle", eventtitle);
		Events e=(Events) query.uniqueResult();
		if(e==null){
			e=new Events(eventtitle,description);
			session.save(e);
			System.out.println("Event Added Successfully. \n Thank You!");
		}
		else 
			System.out.println("Event already Exists. \n Thank You!");
		tx.commit();
		
		session.close();
	}
	
	public List<Employee> getEmployeeList(){
		Session session=Main.factory.openSession();
		Criteria criteria=session.createCriteria(Employee.class);
		List<Employee> elist=criteria.list();
		System.out.println("Employee List:");
		for(Employee emp:elist){
			System.out.println(emp.getMID()+" : "+emp.getName());
		}
		session.close();
		return elist;
	}
	
	public void registerForEvents(String mid){
		Session session=Main.factory.openSession();
		Transaction tx=session.beginTransaction();
		Query query1=session.createQuery("from Employee e where "
				+ "e.MID=:ID");
		query1.setString("ID", mid);
		Employee emp=(Employee) query1.uniqueResult();
		if(emp==null){
			System.out.println("Invalid Employee.");
			
		}
		else{
			System.out.println("Please enter EventTitle:");
			String eventtitle=sc.nextLine();
			Query query=session.createQuery("from Events e where "
					+ "e.eventtitle=:eventTitle");
			query.setString("eventTitle", eventtitle);
			Events event=(Events) query.uniqueResult();

			if(event==null){
				System.out.println("Invalid Event. ");
			}
			else{
				emp.getEvent().add(event);
				session.saveOrUpdate(emp);
				tx.commit();
				System.out.println("Event Has been added successfully.\n Would you like to add more events for this employee? Y/N");
				String choice=sc.nextLine();
				if(choice.equalsIgnoreCase("Y")){
					registerForEvents(mid);
				}
				else
					System.out.println("Thnak You!");
					
				
			}
		
			
			
			session.close();
		}
		
		
		
		
	}

}
