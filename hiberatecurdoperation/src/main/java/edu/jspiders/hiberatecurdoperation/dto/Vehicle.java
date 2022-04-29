package edu.jspiders.hiberatecurdoperation.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="vehicle_table")
public class Vehicle implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@GenericGenerator(name="myGen",strategy="edu.jspiders.hiberatecurdoperation.dao.MyOwnGenerator")
	@GeneratedValue(generator="myGen")
	@Id
	@Column(name="chasis_number")
	private String chasisNumber;
	
	@Column(name="model")
	private String model;
	
	@Column(name="color")
	private String color;
	
	@Column(name="price")
	private double price;
	
	@Column(name="year_of_manufacture")
	private int yearOfManufacture;
	
	@Column(name="type")
	private String type;
	
	public Vehicle() {
	}

	public Vehicle(String chasisNumber, String model, String color, double price, int yearOfManufacture, String type) {
		super();
		this.chasisNumber = chasisNumber;
		this.model = model;
		this.color = color;
		this.price = price;
		this.yearOfManufacture = yearOfManufacture;
		this.type = type;
	}

	public String getChasisNumber() {
		return chasisNumber;
	}

	public void setChasisNumber(String chasisNumber) {
		this.chasisNumber = chasisNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Vehicle [chasisNumber=" + chasisNumber + ", model=" + model + ", color=" + color + ", price=" + price
				+ ", yearOfManufacture=" + yearOfManufacture + ", type=" + type + "]";
	}
	
	
	
}
