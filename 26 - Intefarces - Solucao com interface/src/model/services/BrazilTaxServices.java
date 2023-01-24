package model.services;

public class BrazilTaxServices implements TaxServices {
	public double tax(double amount) {
		if (amount <= 100.0) {
			return amount * 0.2;
		}
		return amount * 0.15;
	}
}
