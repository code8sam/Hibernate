package edu.jspiders.hiberatecurdoperation.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.jspiders.hiberatecurdoperation.dto.Vehicle;

public class VehicleDataBaseOperations
{
	private static  SessionFactory factory = null;
	
	static
	{
		Configuration config = new Configuration();
		config.configure();
		
		factory = config.buildSessionFactory();
		
	}
	
	public boolean insertVehicle(Vehicle newVehicle)
	{
		/*Configuration config = new Configuration();
		config.configure();

//		config.addAnnotatedClass(Vehicle.class);

		SessionFactory factory = config.buildSessionFactory();*/
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(newVehicle);
		try
		{
			tx.commit();
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

	public Vehicle searchVehicle(String chasisNumber)
	{
		/*Configuration configuration = new Configuration();
		configuration.configure();

//		configuration.addAnnotatedClass(Vehicle.class);

		SessionFactory factory = configuration.buildSessionFactory();*/
		Session session = factory.openSession();

		Vehicle searchedVehicle = session.get(Vehicle.class, chasisNumber);

		return searchedVehicle;
	}

	public boolean updateVehiclePrice(String chasisNumber, double updatedPrice)
	{
		Vehicle vehicleToBeUpadted = searchVehicle(chasisNumber);

		if(vehicleToBeUpadted != null)
		{
			/*Configuration configuration = new Configuration();
			configuration.configure();

//			configuration.addAnnotatedClass(Vehicle.class);

			SessionFactory factory = configuration.buildSessionFactory();*/
			Session session = factory.openSession();

			vehicleToBeUpadted.setPrice(updatedPrice);

			session.update(vehicleToBeUpadted);

			Transaction tx = session.beginTransaction();

			try
			{
				tx.commit();
				return true;
			}
			catch (Exception e)
			{
				e.printStackTrace();
				tx.rollback();
				return false;
			}
		}
		else
			return false;
	}
	
	public boolean deleteVehicle(String chasisNumber)
	{
		Vehicle vehicleToBeDeleted = searchVehicle(chasisNumber);

		if(vehicleToBeDeleted != null)
		{
			/*Configuration configuration = new Configuration();
			configuration.configure();

//			configuration.addAnnotatedClass(Vehicle.class);

			SessionFactory factory = configuration.buildSessionFactory();*/
			Session session = factory.openSession();


			session.delete(vehicleToBeDeleted);

			Transaction tx = session.beginTransaction();

			try
			{
				tx.commit();
				return true;
			}
			catch (Exception e)
			{
				e.printStackTrace();
				tx.rollback();
				return false;
			}
		}
		else
			return false;
	}
}
