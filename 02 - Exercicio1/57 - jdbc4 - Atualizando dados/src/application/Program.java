package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import db.DB;

public class Program {
    public static void main(String[] args) {
	Connection conn = null;
	PreparedStatement st = null;
	
	try {
	    conn = DB.getConnection();
	    
	    st = conn.prepareStatement("UPDATE SELLER "
		    + "SET BASESALARY = BASESALARY * ? + BASESALARY "
		    + "WHERE "
		    + "(DEPARTMENTID = ?)",
		    Statement.RETURN_GENERATED_KEYS);
	   st.setDouble(1, 0.10);
	   st.setInt(2, 2);
	   
	   int rowsAffected = st.executeUpdate();
	   System.out.println("Done! Rows affected: " + rowsAffected);
	   
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}finally {
	    DB.closeStatment(st);
	    DB.closeConnection();
	}
    }
}