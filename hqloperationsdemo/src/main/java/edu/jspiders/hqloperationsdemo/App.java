package edu.jspiders.hqloperationsdemo;

import java.util.List;
import java.util.Scanner;

import edu.jspiders.hqloperationsdemo.dao.EmployeeOperation;
import edu.jspiders.hqloperationsdemo.dao.EmployeeOperationImpl;
import edu.jspiders.hqloperationsdemo.dto.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		Scanner sc = new Scanner(System.in);
		EmployeeOperation operation = new EmployeeOperationImpl();

		System.out.println("1.Insert\n2.Get all EMployees\n3.Search\n4.Get Based on salary\n5.Get Based on salary user");
		System.out.println("6.Display\n7.Update Based on Name");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			/*System.out.println("Enter ID");
			int id = sc.nextInt();*/
			System.out.println("Enter Name");
			String name = sc.next();
			System.out.println("Enter Salary");
			double salary = sc.nextDouble();

			Employee newEmployee = new Employee(0, name, salary);

			if(operation.addEmployee(newEmployee))
				System.out.println("Inserted!!");
			else
				System.out.println("NOT Inserted!!!");
			break;
		case 2:
			List<Employee> allEmployees = operation.getAllEmployees();
			for (Employee employee : allEmployees) 
			{
				System.out.println(employee);
			}
			break;
		case 3:
			System.out.println("a.Search by ID\nb.Search by Name");
			char ch1 = sc.next().charAt(0);
			if(ch1 == 'a') 
			{
				System.out.println("Enter ID");
				int id1 = sc.nextInt();
				Employee e = operation.search(id1);
				if(e != null)
					System.out.println(e);
				else
					System.out.println("Emp data is not Present");
			}
			else if(ch1 == 'b') 
			{
				System.out.println("Enter Name");
				String name1 = sc.next();
				List<Employee> allEmps = operation.search(name1);
				if(allEmps.isEmpty())
					System.out.println("Data not present");
				else
				{
					for (Employee employee : allEmps)
					{
						System.out.println(employee);
					}
				}
			}
		case 4:
			List<Employee> allEmps = operation.getEmpsBasedOnSalary();
			if(allEmps.isEmpty())
				System.out.println("Data not present");
			else
			{
				for (Employee employee : allEmps)
				{
					System.out.println(employee);
				}
			}
			
			break;
			
		case 5:
			System.out.println("Enter Lower Range salary");
			double lowerSal = sc.nextDouble();
			
			System.out.println("Enter Upper Range salary");
			double upperSal = sc.nextDouble();
			
			List<Employee> allEmps1 = operation.getEmpsBasedOnSalary(lowerSal,upperSal);
			if(allEmps1.isEmpty())
				System.out.println("Data not present");
			else
			{
				for (Employee employee : allEmps1)
				{
					System.out.println(employee);
				}
			}
			
			break;
			
		case 6:
			System.out.println("a.Name\nb.Salary");
			char ch2 = sc.next().charAt(0);
			if(ch2 == 'a')
			{
				System.out.println("1.ASC\n2.DESC");
				int ch3 = sc.nextInt();
				if(ch3 == 1)
				{
					List<Employee> allEmps2 = operation.displayBasedOnAscOfName();
					for (Employee employee : allEmps2) 
					{
						System.out.println(employee);
					}
				}
				else if(ch3 == 2)
				{
					List<Employee> allEmps2 = operation.displayBasedOnDescOfName();
					for (Employee employee : allEmps2) 
					{
						System.out.println(employee);
					}
				}
			}
			else if(ch2 == 'b')
			{
				System.out.println("1.ASC\n2.DESC");
				int ch3 = sc.nextInt();
				if(ch3 == 1)
				{
					List<Employee> allEmps2 = operation.displayBasedOnAscOfSalary();
					for (Employee employee : allEmps2) 
					{
						System.out.println(employee);
					}
				}
				else if(ch3 == 2)
				{
					List<Employee> allEmps2 = operation.displayBasedOnDescOfSalary();
					for (Employee employee : allEmps2) 
					{
						System.out.println(employee);
					}
				}
			}
			break;
			
		case 7:
			System.out.println("Enter Name");
			String name1 = sc.next();
			
			System.out.println("Enter salary");
			double salary1 = sc.nextDouble();
			boolean isUpdated = operation.updateSalaryBasedOnName(name1,salary1);
			if(isUpdated)
				System.out.println("Updated!!");
			else 
				System.out.println("NOT Updated!!!");
			break;
		default:
			break;
		}

	}
}
