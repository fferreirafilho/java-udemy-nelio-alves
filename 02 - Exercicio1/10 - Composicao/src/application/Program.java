package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) {
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double workerBaseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary,
				new Department(departmentName));

		System.out.print("How many contracts to this worker? ");
		int numberContracts = sc.nextInt();
		for (int i = 1; i <= numberContracts; i++) {
			System.out.println("Enter contract number #" + i + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			LocalDate contractDate = LocalDate.parse(sc.next(), fmt1);
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Durantion (hours): ");
			int hour = sc.nextInt();
			HourContract contract = new HourContract(contractDate.atTime(0, 0), valuePerHour, hour);
			worker.addContract(contract);
		}

		System.out.println();
		System.out.print("Enter the month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		sc.close();
	}

}
