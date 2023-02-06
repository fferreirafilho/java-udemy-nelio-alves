package application;

import java.time.LocalDate;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		try {
			SellerDao sellerDao = DaoFactory.createSellerDao();
			System.out.println("== TEST 1: seller findById ====");
			Seller seller = sellerDao.findById(3);
			System.out.println(seller);
			
			System.out.println("== TEST 2: seller findByDepartment ====");
			Department department = new Department(2, null);
			List<Seller> list = sellerDao.findByDepartment(department);
			list.forEach(s -> System.out.println(s.toString()));
			
			System.out.println("== TEST 3: seller findAll ====");
			list = sellerDao.findAll();
			list.forEach(s -> System.out.println(s.toString()));
			
			System.out.println("== TEST 4: seller insert ====");
			Seller newSeller = new Seller(null,"Greg", "greg@gmail.com", LocalDate.now(), 1582.00, new Department(2, null));
			sellerDao.insert(newSeller);
			System.out.println("Inserted! id = " + newSeller.getId());
			
			System.out.println("== TEST 5: seller update ====");
			seller.setDepartment(new Department(2, null));
			sellerDao.update(seller);
			seller = sellerDao.findById(3);
			System.out.println("Update seller = " + seller);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
