package model.entites;

import java.time.Duration;
import java.time.LocalDate;

public class Reservartion {
	private Integer roomNUmber;
	private LocalDate checkIn;
	private LocalDate checkOut;

	public Reservartion(Integer roomNUmber, LocalDate checkIn, LocalDate checkOut) {
		this.roomNUmber = roomNUmber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNUmber() {
		return roomNUmber;
	}

	public void setRoomNUmber(Integer roomNUmber) {
		this.roomNUmber = roomNUmber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duration() {
		Duration t1 = Duration.between(checkIn, checkOut);
		return t1.toDays();
	}
}
