package edu.jspiders.hiberatecurdoperation.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyOwnGenerator implements IdentifierGenerator
{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) 
			throws HibernateException
	{
		String genPk = "Abc1xyz2";
		
		String dburl = "jdbc:mysql://localhost:3306/heha22_db?user=root&password=root";
		String query = "SELECT max(chasis_number) FROM vehicle_table";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(dburl);
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(query);
			
			while (rs.next())
			{
				String maxpk = rs.getString(1);
				
				int data3 = (int)maxpk.charAt(3);
				int datalast = (int)maxpk.charAt(7);
				
				data3++;
				datalast++;
				
				genPk = maxpk.substring(0, 3) + data3 +maxpk.substring(4,7) + datalast;
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		return genPk;
	}

}
