package edu.jspiders.hqloperationsdemo.dao;

import java.util.List;

import edu.jspiders.hqloperationsdemo.dto.Employee;

public interface EmployeeOperation
{
	boolean addEmployee(Employee newEmployee);
	
	List<Employee> getAllEmployees();
	
	Employee search(int id);
	List<Employee> search(String name);
	
	
	List<Employee> getEmpsBasedOnSalary();
	
	List<Employee> getEmpsBasedOnSalary(double lsal, double usal) ;
	
	List<Employee> displayBasedOnAscOfName();
	List<Employee> displayBasedOnDescOfName();
	
	List<Employee> displayBasedOnAscOfSalary();
	List<Employee> displayBasedOnDescOfSalary();

	boolean updateSalaryBasedOnName(String name1, double salary1);
	
}
