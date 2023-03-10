package entities;

public class Employee {

	protected String name;
	protected Integer id;
	protected Double salary;

	public Employee(String name, Integer id, Double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public Double getSalary() {
		return salary;
	}

	public void increaseSalary(double percentage) {
		this.salary += percentage / 100 * this.salary;
	}

	@Override
	public String toString() {
		return this.id + ", " + this.name + ", " + String.format("%.2f", this.salary);
	}

}
