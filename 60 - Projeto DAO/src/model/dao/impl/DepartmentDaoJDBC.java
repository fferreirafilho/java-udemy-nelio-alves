package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO DEPARTMENT (NAME) "
					+ "VALUES"
					+ "(?)", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getName());
			
			int rowsEffected = st.executeUpdate();
			
			if(rowsEffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					obj.setId(rs.getInt(1));
				}
				DB.closeResultSet(rs);
			}else {
				throw new DbException("Unespected error! No rows effected! ");
			}
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatment(st);
		}
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("UPDATE DEPARTMENT SET NAME = ? WHERE ID = ?");
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			st.executeUpdate();
			
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatment(st);;
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM DEPARTMENT WHERE ID = ?");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatment(st);
		}
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT D.* FROM DEPARTMENT D "
					+ "WHERE D.ID = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				return instatiateDepartemnt(rs);
			}
			return null;
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatment(st);
		}
	}

	private Department instatiateDepartemnt(ResultSet rs) throws SQLException {
		return new Department(rs.getInt("ID"), rs.getString("NAME"));
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT D.* FROM DEPARTMENT D");
			rs = st.executeQuery();
			List<Department> list = new ArrayList<>();			
			while(rs.next()) {
				list.add(instatiateDepartemnt(rs));
			}
			return list;
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatment(st);
		}
	}

}
