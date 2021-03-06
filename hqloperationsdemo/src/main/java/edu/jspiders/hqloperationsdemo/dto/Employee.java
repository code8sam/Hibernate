package edu.jspiders.hqloperationsdemo.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="emp")
public class Employee implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8554049913851710088L;
	
	@GenericGenerator(name="mygen",strategy="increment")
	@GeneratedValue(generator="mygen")
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="ename")
	private String name;
	
	@Column(name="sal")
	private double salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	
	
}
