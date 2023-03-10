package entities;

public class OutsorcedEmployee extends Employee {
	private Double additonalCharge;

	public OutsorcedEmployee() {
		super();
	}

	public OutsorcedEmployee(String name, Integer hours, Double valuePerHour, Double additonalCharge) {
		super(name, hours, valuePerHour);
		this.additonalCharge = additonalCharge;
	}

	public Double getAdditonalCharge() {
		return additonalCharge;
	}

	public void setAdditonalCharge(Double additonalCharge) {
		this.additonalCharge = additonalCharge;
	}

	@Override
	public Double payment() {
		// TODO Auto-generated method stub
		return super.payment() + (this.additonalCharge * 1.1);
	}

}
