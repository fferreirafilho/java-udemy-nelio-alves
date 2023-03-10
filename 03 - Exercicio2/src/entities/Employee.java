package entities;

public class Employee {
	public String name;
	public Double grossSalary;
	public Double tax;

	public double NetSalary() {
		return this.grossSalary - tax;
	}

	public void IncreaseSalary(double percent) {
		this.grossSalary += percent / 100 * this.grossSalary;
	}

	@Override
	public String toString() {
		return "Employee: " + this.name + ", $ " + this.NetSalary();
	}
}
