package entities;

public class Rectangle {
	public double widht;
	public double heigth;

	public double area() {
		return this.widht * this.heigth;
	}

	public double Perimeter() {
		return 2 * (this.heigth + this.widht);
	}

	public double Diagonal() {
		return Math.sqrt(this.heigth * this.heigth + this.widht * this.widht);
	}

	@Override
	public String toString() {
		return "AREA = " + this.area() + "\nPERIMETER = " + this.Perimeter() + "\nDIAGONAL = " + this.Diagonal();
	}
}