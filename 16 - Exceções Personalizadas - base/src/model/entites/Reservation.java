package model.entites;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;

	private static DateTimeFormatter dtmf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getroomNumber() {
		return roomNumber;
	}

	public void setroomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duration() {
		Duration t1 = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
		return t1.toDays();
	}

	public void updateDates(LocalDate checkIn, LocalDate checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room " + this.roomNumber + ", check-in " + this.checkIn.format(dtmf1) + ", check-Out "
				+ this.checkOut.format(dtmf1) + ", " + this.duration() + " nigths";
	}
}
