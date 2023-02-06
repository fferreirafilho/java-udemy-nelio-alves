package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	private Double pricePerHour;
	private Double pricePerDay;

	private TaxServices taxServices;

	public RentalService(Double pricePerHour, Double pricePerDay, TaxServices taxServices) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxServices = taxServices;
	}

	public void processInvoice(CarRental carRental) {
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hours = minutes / 60;

		double basicPayment;
		if (hours <= 12) {
			basicPayment = this.pricePerHour * Math.ceil(hours);
		} else {
			basicPayment = this.pricePerDay * Math.ceil(hours / 24);
		}

		double tax = taxServices.tax(basicPayment);

		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}
