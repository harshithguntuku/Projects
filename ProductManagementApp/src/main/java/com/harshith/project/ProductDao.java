package com.harshith.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	
	public int save(Product product)
	{
		//Declare the resources
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				int count=0;
				try
				{
					//Get the connection
					connection = DbConnection.createConnection();
					
					//Create PreparedStatement object
					preparedStatement = connection.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?)");
					
					//Read the data from product object and set to parameters
					preparedStatement.setInt(1, product.getProId());
					preparedStatement.setString(2, product.getProName());
					preparedStatement.setDouble(3, product.getProPrice());
					preparedStatement.setString(4, product.getProBrand());
					preparedStatement.setString(5, product.getProMadeIn());
					preparedStatement.setDate(6, product.getProMfgDate());
					preparedStatement.setDate(7, product.getProExpDate());
					preparedStatement.setBytes(8, product.getProImage());
					
					count=preparedStatement.executeUpdate();
					
				}
				
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				
				finally
				{
					//before release connection check the connection is present or not
					try {
					if(connection!=null)
						connection.close();
					
					if(preparedStatement!=null)
						preparedStatement.close();
					}
					
					catch(SQLException e)
					{
						e.printStackTrace();
					}
					
				}
				return count;
				}
	
	//This class has findAll method which is used to print all the product
		public List<Product> findAll()
		{
			List<Product> l=new ArrayList<>();
			try(Connection connection=DbConnection.createConnection();
				Statement statement=connection.createStatement())
			{
				ResultSet resultSet=statement.executeQuery("select * from product_data");
				
				while(resultSet.next())
				{
					Product product=new Product();
					product.setProId(resultSet.getInt("proId"));
					product.setProName(resultSet.getString("proName"));
					product.setProPrice(resultSet.getDouble("proPrice"));
					product.setProBrand(resultSet.getString("proBrand"));
					product.setProMadeIn(resultSet.getString("proMadeIn"));
					product.setProMfgDate(resultSet.getDate("proMfgDate"));
					product.setProExpDate(resultSet.getDate("proExpDate"));
					product.setProImage(resultSet.getBytes("proImage"));
					l.add(product);
						
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return l;
		}			
		
		public int deletebyId(int proId)
		{
			int count=0;
			//try with resource
			try(Connection connection = DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("delete from product_data where proId=?"))
			{
				//Set the data to the parameter
				preparedStatement.setInt(1, proId);
				
				//execute the query
				 count = preparedStatement.executeUpdate();
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			}
					return count;
			
		}
		
		public Product findById(int proId)
		{
			Product p=null;
			//try with resource
			try(Connection connection = DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("select * from product_data where proId=?"))
			{
				//Set the data to the parameter
				preparedStatement.setInt(1, proId);
				
				//execute the query
				ResultSet resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next())
				{
					//Reading the data from ResultSet setting to the product
					
					p = new Product();
					p.setProId(resultSet.getInt("proId"));
					p.setProName(resultSet.getString("proName"));
					p.setProPrice(resultSet.getDouble("proPrice"));
					p.setProBrand(resultSet.getString("proBrand"));
					p.setProMadeIn(resultSet.getString("proMadeIn"));
					p.setProMfgDate(resultSet.getDate("proMfgDate"));
					p.setProExpDate(resultSet.getDate("proExpDate"));
					p.setProImage(resultSet.getBytes("proImage"));
					
				}
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			}
					return p;	
		}
		

		public int updateById(Product product) {
			String sql = "UPDATE product_data SET proName=?, proPrice=?, proBrand=?, proMadeIn=?, proMfgDate=?, proExpDate=?, proImage=? WHERE proId=?";
			int updateResult=0;
			try(Connection connection = DbConnection.createConnection();
					PreparedStatement preparedStatement=connection.prepareStatement(sql))
				{	
					preparedStatement.setString(1, product.getProName());
					preparedStatement.setDouble(2, product.getProPrice());
					preparedStatement.setString(3, product.getProBrand());
					preparedStatement.setString(4, product.getProMadeIn());
					preparedStatement.setDate(5, product.getProMfgDate());
					preparedStatement.setDate(6, product.getProExpDate());
					preparedStatement.setBytes(7, product.getProImage());
					preparedStatement.setInt(8, product.getProId());
					
					updateResult = preparedStatement.executeUpdate();
				}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
					return updateResult;						
					
		}
		

	}


