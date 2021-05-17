package com.yhh.jdbc;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Statement;
import java.sql.Connection;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import java.util.HashMap;
import java.util.Map;

public class UseJdbcPrepareStatment {
	
	public void updateBatchStudent(Connection con, HashMap<String, Integer> salesForWeek) throws SQLException {
		String updateString = "update COFFEES set SALES = ? where COF_NAME = ?";
		String updateStatement = "update COFFEES set TOTAL = TOTAL + ? where COF_NAME = ?";

		try (PreparedStatement updateSales = con.prepareStatement(updateString);
				PreparedStatement updateTotal = con.prepareStatement(updateStatement))

		{
			con.setAutoCommit(false);
			for (Map.Entry<String, Integer> e : salesForWeek.entrySet()) {
				updateSales.setInt(1, e.getValue().intValue());
				updateSales.setString(2, e.getKey());
				updateSales.executeUpdate();

				updateTotal.setInt(1, e.getValue().intValue());
				updateTotal.setString(2, e.getKey());
				updateTotal.executeUpdate();
				con.commit();
			}
		} catch (SQLException e) {
			JdbcUtil.printSQLException(e);
			if (con != null) {
				try {
					System.err.print("Transaction is being rolled back");
					con.rollback();
				} catch (SQLException excep) {
					JdbcUtil.printSQLException(excep);
				}
			}
		}
	}
	
	public void addBatchStudent() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
