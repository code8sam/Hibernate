package edu.jspiders.hiberatecurdoperation;

import java.util.Scanner;

import edu.jspiders.hiberatecurdoperation.dao.VehicleDataBaseOperations;
import edu.jspiders.hiberatecurdoperation.dto.Vehicle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	VehicleDataBaseOperations operations = new VehicleDataBaseOperations();
    	while (true)
    	{
    		System.out.println("1.Insert\n2.Search\n3.Update Vehicle data\n4.Delete Vehicle\n5.Exit");
    		System.out.println("Enter the choice");
    		int choice = sc.nextInt();
    		
    		switch (choice) {
			case 1:
				/*System.out.println("Enter Chasis Number");
				String chasisNum = sc.next();*/
				
				System.out.println("Enter Model");
				String model = sc.next();
				
				System.out.println("Enter Color");
				String color = sc.next();
				
				System.out.println("Enter price");
				double price = sc.nextDouble();
				
				System.out.println("Enter Year of manufacture");
				int yom = sc.nextInt();
				
				System.out.println("Enter type");
				String type = sc.next();
				
				Vehicle newVehicle = new Vehicle("", model, color, price, yom, type);
				
				boolean isInserted = operations.insertVehicle(newVehicle);
				
				if(isInserted)
					System.out.println("Inserted!!!!");
				else
					System.out.println("NOT Inserted!!!");
				break;

			case 2:
				System.out.println("Enter Chasis Number");
				String chasisNumber = sc.next();
				
				Vehicle searchedVeh = operations.searchVehicle(chasisNumber);
				if(searchedVeh != null)
					System.out.println(searchedVeh);
				else
					System.out.println("Data Not Present!!!");
				break;
				
			case 3:
				System.out.println("Enter Chasis Number");
				String chasisNumber1 = sc.next();
				
				System.out.println("Enter Updated price");
				double updatedPrice = sc.nextDouble();
				
				boolean isUpdated  = operations.updateVehiclePrice(chasisNumber1,updatedPrice);
				if(isUpdated)
					System.out.println("Data Updated!!!!");
				else
					System.out.println("Data NOT Updated!!!");
				break;
				
			case 4:
				System.out.println("Enter Chasis Number");
				String chasisNumber2 = sc.next();
				
				boolean isDeleted = operations.deleteVehicle(chasisNumber2);
				
				if(isDeleted)
					System.out.println("Data Deleted!!!");
				else
					System.out.println("Data NOT Deleted!!");
				break;
				
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid Choice!!!!");
				break;
			}
		}
    }
}
