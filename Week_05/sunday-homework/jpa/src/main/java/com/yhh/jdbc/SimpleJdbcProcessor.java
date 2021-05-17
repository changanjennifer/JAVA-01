/**
 * Processing use row JDBC API to implements ADD/UPDATE/DELETE/QUERY from mysql db
 */
package com.yhh.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.sql.Connection;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
public class SimpleJdbcProcessor {

	
	public boolean UpdateRecord(Connection con) throws SQLException{

	    String updateString = "update COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";
	    try (Statement stmt = con.createStatement()) {
	      boolean ret = stmt.execute(updateString);
	      return ret;
	    } catch (SQLException e) {
	    	JdbcUtil.printSQLException(e);
	    	throw e;
	    }
	}
	
	public boolean AddRecord(Connection con) throws SQLException{

	    String addString = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";
	    try (Statement stmt = con.createStatement()) {
	      boolean ret = stmt.execute(addString);
	      return ret;
	    } catch (SQLException e) {
	    	JdbcUtil.printSQLException(e);
	    	throw e;
	    }
	}
	
	
	public ResultSet fetchCoffee(Connection con) throws SQLException{

	    String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";
	    try (Statement stmt = con.createStatement()) {
	      ResultSet rs = stmt.executeQuery(query);
	      while (rs.next()) {
	        String coffeeName = rs.getString("COF_NAME");
	        int supplierID = rs.getInt("SUP_ID");
	        float price = rs.getFloat("PRICE");
	        int sales = rs.getInt("SALES");
	        int total = rs.getInt("TOTAL");
	        System.out.println(coffeeName + ", " + supplierID + ", " + price +
	                           ", " + sales + ", " + total);
	      }
	      return rs;
	    } catch (SQLException e) {
	    	JdbcUtil.printSQLException(e);
	    	throw e;
	    }
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
