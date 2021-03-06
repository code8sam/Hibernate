package edu.jspiders.hqloperationsdemo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.jspiders.hqloperationsdemo.dto.Employee;

public class EmployeeOperationImpl implements EmployeeOperation
{
	private static SessionFactory factory = null;
	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		
		factory = configuration.buildSessionFactory();
	}
	
	@Override
	public boolean addEmployee(Employee newEmployee) 
	{
		Session session = factory.openSession();
		session.save(newEmployee);
		
		Transaction tx = session.beginTransaction();
		try
		{
			tx.commit();
			return true;
		}
		catch (Exception e) 
		{
			tx.rollback();
			return false;
		}
	}

	@Override
	public List<Employee> getAllEmployees() 
	{
		Session session = factory.openSession();
		String hql = "FROM Employee";
		Query query = session.createQuery(hql);
		
		List<Employee> allEmps = query.getResultList();
		
		return allEmps;
	}

	@Override
	public Employee search(int id) 
	{
		Session session = factory.openSession();
		Employee e = session.get(Employee.class, id);
		return e;
	}

	@Override
	public List<Employee> search(String name)
	{
		Session session = factory.openSession();
		String hql = "FROM Employee WHERE name = :nm";
		Query query = session.createQuery(hql);
		query.setParameter("nm", name);
		
		List<Employee> allEmps = query.getResultList();
		
		return allEmps;
	}

	@Override
	public List<Employee> getEmpsBasedOnSalary() 
	{
		Session session = factory.openSession();
		String hql = "FROM Employee WHERE salary BETWEEN 2.0 and 3.0";
		Query query = session.createQuery(hql);
		
		List<Employee> allEmps = query.getResultList();
		
		return allEmps;
	}
	
	
	@Override
	public List<Employee> getEmpsBasedOnSalary(double lsal, double usal) 
	{
		Session session = factory.openSession();
		String hql = "FROM Employee WHERE salary BETWEEN :lr AND :ur";
		Query query = session.createQuery(hql);
		
		query.setParameter("lr", lsal);
		query.setParameter("ur", usal);
		
		List<Employee> allEmps = query.getResultList();
		
		return allEmps;
	}

	@Override
	public List<Employee> displayBasedOnAscOfName() 
	{
		Session session = factory.openSession();
		String hql = "FROM Employee ORDER BY name ASC";
		Query query = session.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public List<Employee> displayBasedOnDescOfName() {
		Session session = factory.openSession();
		String hql = "FROM Employee ORDER BY name DESC";
		Query query = session.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public List<Employee> displayBasedOnAscOfSalary() {
		Session session = factory.openSession();
		String hql = "FROM Employee ORDER BY salary ASC";
		Query query = session.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public List<Employee> displayBasedOnDescOfSalary() {
		Session session = factory.openSession();
		String hql = "FROM Employee ORDER BY salary DESC";
		Query query = session.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public boolean updateSalaryBasedOnName(String name, double salary)
	{
		Session session = factory.openSession();
		String hql = "UPDATE Employee SET salary = :sal WHERE name = :nm";
		Query query = session.createQuery(hql);
		query.setParameter("sal", salary);
		query.setParameter("nm", name);
		Transaction tx = session.beginTransaction();
		
		int rowsAff = query.executeUpdate();
		
		tx.commit();
		
		return rowsAff != 0;
	}

}
