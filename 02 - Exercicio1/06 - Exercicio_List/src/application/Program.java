package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int quantity = sc.nextInt();

		for (int i = 0; quantity > i; i++) {
			System.out.println("Employee #" + Integer.sum(1, i));
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			list.add(new Employee(name, id, salary));
		}
		System.out.print("Enter the employee id tahr will have salary increase: ");
		int id = sc.nextInt();

		if (list.stream().filter(x -> x.getId() == id).findFirst().orElse(null) != null) {
			System.out.print("Enter the percentage: ");
			int percentage = sc.nextInt();
			Employee e = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
			e.increaseSalary(percentage);
		}

		System.out.println("List of employees: ");
		for (Employee item : list) {
			System.out.println(item.toString());
		}
		sc.close();
	}

}
