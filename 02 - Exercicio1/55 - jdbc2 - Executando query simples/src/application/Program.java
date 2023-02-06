package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.DB;

public class Program {
    public static void main(String[] args) {

	Connection conn = DB.getConnection();
	Statement st = null;
	ResultSet rs = null;

	try {

	    st = conn.createStatement();
	    rs = st.executeQuery("Select * from department");

	    while (rs.next()) {
		System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
	    }
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	} finally {
	    DB.closeStatment(st);
	    DB.closeResultSet(rs);
	    DB.closeConnection();
	}
    }
}