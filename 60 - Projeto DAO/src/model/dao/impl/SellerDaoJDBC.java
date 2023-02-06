package model.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {

	}

	@Override
	public void update(Seller obj) {

	}

	@Override
	public void deleteById(Integer id) {

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT SELLER.*, DEPARTMENT.NAME AS DEPNAME " + "FROM SELLER INNER JOIN DEPARTMENT "
							+ "ON SELLER.DEPARTMENTID = DEPARTMENT.ID " + "WHERE SELLER.ID = ?");

			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Department dep = instantiateDepartment(rs);
				Seller obj = instantiateSeller(rs, dep);
				return obj;
			}
			return null;
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatment(st);
		}
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {

		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate(LocalDate.parse(rs.getDate("BirthDate").toString()));
		obj.setDepartment(dep);
		return obj;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException, IOException, Exception {

		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DEPNAME"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("SELECT S.*, D.NAME AS DEPNAME FROM SELLER S "
					+ "LEFT JOIN DEPARTMENT D "
					+ "ON D.ID = S.DEPARTMENTID "
					+ "ORDER BY S.NAME");
			rs = st.executeQuery();
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			while(rs.next()) {
				Department dep = map.get(rs.getInt("DepartmentId"));
				if(dep == null) {
					map.put(rs.getInt("DepartmentId"), instantiateDepartment(rs));
					dep = map.get(rs.getInt("DepartmentId"));
				}
				list.add(instantiateSeller(rs, dep));
			}
			return list;
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatment(st);
		}
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement( "SELECT S.*, D.NAME AS DEPNAME "
					+ "FROM SELLER S "
					+ "LEFT JOIN DEPARTMENT D "
					+ "ON S.DEPARTMENTID = D.ID "
					+ "WHERE DEPARTMENTID = ? "
					+ "ORDER BY S.NAME");
			
			st.setInt(1, department.getId());
			rs = st.executeQuery();
			
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			while(rs.next()) {
				
				Department dep = map.get(rs.getInt("DepartmentId"));				
				if(dep == null) {
					map.put(rs.getInt("DepartmentId"), instantiateDepartment(rs));
					dep = map.get(rs.getInt("DepartmentId"));
				}
				
				Seller obj = instantiateSeller(rs, dep);
				list.add(obj);
			}	
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		catch (Exception e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatment(st);
		}
	}
}