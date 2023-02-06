package application;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DB;

public class Program {
    public static void main(String[] args) {
	Connection conn = null;
	PreparedStatement st = null;
	
	try {
	    
	    conn = DB.getConnection();
	    
	    st = conn.prepareStatement(
		    "DELETE FROM DEPARTMENT WHERE ID = ? ");
	    st.setInt(1, 1);
	    
	    int rowsAffected = st.executeUpdate();
	    
	    System.out.println("Done! Rows affected = " + rowsAffected);
	    
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}finally {
	    DB.closeStatment(st);
	    DB.closeConnection();
	}
    }
}