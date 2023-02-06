package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		try {
			DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
			System.out.println("== TEST 1: department findById ====");
			Department dep = departmentDao.findById(1);
			System.out.println(dep + "\n");
			
			System.out.println("== TEST 2: department findAll ====");
			List<Department> list = departmentDao.findAll();
			list.forEach( l -> System.out.println(l));
			
			System.out.println("== TEST 3: department insert ====");
			dep = new Department(null, "Teste");
			departmentDao.insert(dep);			
			System.out.println("Inserted! Id = " + dep.getId());
			
			System.out.println("== TEST 4: department update ====");
			dep = departmentDao.findById(1);
			dep.setName("Fernando");
			departmentDao.update(dep);
			dep = departmentDao.findById(1);
			System.out.println(dep);
			
			System.out.println("== TEST 5: department delete ====");
			departmentDao.deleteById(7);
			dep = departmentDao.findById(7);
			System.out.println("Delete success");
			System.out.println(dep);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
