package entities;


public class Car {

	String brand;
	String model;
	String year;
	String parkingNumber;
	Boolean reservation_status;
	Boolean block_status;
	int owner;
	
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String brand, String model, String year, String parkingNumber, Boolean reservation_status,
			Boolean block_status, int owner) {
		super();
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.parkingNumber = parkingNumber;
		this.reservation_status = reservation_status;
		this.block_status = block_status;
		this.owner = owner;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getParkingNumber() {
		return parkingNumber;
	}

	public void setParkingNumber(String parkingNumber) {
		this.parkingNumber = parkingNumber;
	}

	public Boolean getReservation_status() {
		return reservation_status;
	}

	public void setReservation_status(Boolean reservation_status) {
		this.reservation_status = reservation_status;
	}

	public Boolean getBlock_status() {
		return block_status;
	}

	public void setBlock_status(Boolean block_status) {
		this.block_status = block_status;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + ", year=" + year + ", parkingNumber=" + parkingNumber
				+ ", reservation_status=" + reservation_status + ", block_status=" + block_status + ", owner=" + owner
				+ "]";
	}
	
	
	
}
