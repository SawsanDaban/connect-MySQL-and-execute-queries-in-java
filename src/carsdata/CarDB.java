package carsdata;

import carsconnection.carsConnection;
import java.sql.*;

public class CarDB {

    car c = new car();
    Connection conn = null;
    PreparedStatement preparedStmt = null;
    Statement statement = null;
    ResultSet rs = null;

    public CarDB() {
        
    }
    
    //insert new cars data to database
    public void insertData(int id, String name, double price, int quantity) {
        String query = " insert into carModels (ModelNo, ModelName, ModelPrice, ModelQuantity)"
                         + " values (?, ?, ?, ?)";

	try {
		conn = carsConnection.getConnection();
		preparedStmt = conn.prepareStatement(query);
		preparedStmt.setInt(1, id);
		preparedStmt.setString (2, name);
                preparedStmt.setDouble   (3, price);
                preparedStmt.setInt    (4, quantity);
		preparedStmt.executeUpdate();
		System.out.println(query);

	} catch (Exception e) {
		e.printStackTrace();
	} 
    }

	
    //get car data by id	
    public void selectById(int id) {
        String query = "SELECT * FROM carModels WHERE id = ?";

	try {
		conn = carsConnection.getConnection();
		preparedStmt = conn.prepareStatement(query);
		preparedStmt.setInt(1, id);
		rs = preparedStmt.executeQuery();

		while (rs.next()) {
		    c.setModelNo(rs.getInt("ModelNo"));
                    c.setModelName(rs.getString("ModelName"));
                    c.setModelPrice(rs.getDouble("ModelPrice"));
                    c.setModelQuantity(rs.getInt("ModelQuantity"));
	        }

	} catch (Exception e) {
		e.printStackTrace();
	} 
    }

	
    //get all cars data	
    public void selectAll() {
        String query = "SELECT * FROM carModels";

	try {
		conn = carsConnection.getConnection();
		statement = conn.createStatement();
		rs = statement.executeQuery(query);

		while (rs.next())
                {
                  c.setModelNo(rs.getInt("ModelNo"));
                  c.setModelName(rs.getString("ModelName"));
                  c.setModelPrice(rs.getDouble("ModelPrice"));
                  c.setModelQuantity(rs.getInt("ModelQuantity"));
        
                  // print the results
                  System.out.format("%s, %s, %s, %s\n", c.getModelNo(), c.getModelName(), c.getModelPrice(), c.getModelQuantity());
                }
                 System.out.println("");

	} catch (Exception e) {
		e.printStackTrace();
	} 
    }
	

    //delete a car by id
    public void deleteData(int id) {
        String query = "delete from carModels where ModelNo = ?";

	try {
		conn = carsConnection.getConnection();
		preparedStmt = conn.prepareStatement(query);
		preparedStmt.setInt(1, id);
		preparedStmt.executeUpdate();
		System.out.println(query);

	} catch (Exception e) {
		e.printStackTrace();
	} 
    }

	
    //update car data by id	
    public void updateData(int id, double price, int quantity) {
        String query = "update carModels set ModelPrice = ? , ModelQuantity = ? where ModelNo = ?";

	try {
		conn = carsConnection.getConnection();
		preparedStmt = conn.prepareStatement(query);
                preparedStmt.setDouble(1, price);
		preparedStmt.setInt(2, quantity);
                preparedStmt.setInt(3, id);
		preparedStmt.executeUpdate();

		System.out.println(query);

	} catch (Exception e) {
		e.printStackTrace();
	}
    }
    
}
