package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

    public static void main(String[] args) {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);

	System.out.print("Enter full file path: ");
	String path = sc.nextLine();

	try (BufferedReader bf = new BufferedReader(new FileReader(path))) {

	    System.out.print("Enter salary: ");
	    Double salary = sc.nextDouble();

	    String line = bf.readLine();

	    List<Employee> employees = new ArrayList<>();

	    while (line != null) {
		String[] fields = line.split(",");
		employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
		line = bf.readLine();
	    }

	    List<String> moreSalary = employees.stream().filter(p -> p.getSalary() > salary).map(p -> p.getEmail())
		    .sorted((e1, e2) -> e1.toUpperCase().compareTo(e2.toUpperCase())).toList();

	    System.out.println("Email of people whose salary is more than: " + String.format("%.2f", salary));
	    moreSalary.forEach(System.out::println);

	    Double sum = employees.stream().filter(e -> e.getName().toUpperCase().charAt(0) == 'M')
		    .map(e -> e.getSalary()).reduce(0.0, (x, y) -> x + y);

	    System.out.println("Sum of salary of people whose name starts with 'M' :" + String.format("%.2f", sum));

	} catch (Exception e) {
	    System.out.println(e);
	} finally {
	    sc.close();
	}
    }
}