package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Employee emp = new Employee();

		System.out.print("Name: ");
		emp.name = sc.nextLine();

		System.out.print("GrossSalaray: ");
		emp.grossSalary = sc.nextDouble();

		System.out.print("Tax: ");
		emp.tax = sc.nextDouble();

		System.out.println("\nEmployee: " + emp);

		System.out.print("\nWhich percentage to increase salary? ");
		emp.IncreaseSalary(sc.nextDouble());
		System.out.println("\nUpdate data: " + emp);

		sc.close();
	}

}
