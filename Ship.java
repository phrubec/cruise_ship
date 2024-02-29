
public class Ship {
	// Class Variables
	private String ShipName;
	private int balconyCap;
	private int oceanViewCap;
	private int suiteCap;
	private int interiorCap;
	private boolean inService;
	
	// Default Constructor
	public Ship() {
		super();
	}

	// Constructor with fields
	public Ship(String shipName, int balconyCap, int oceanViewCap, int suiteCap, int interiorCap, boolean inService) {
		super();
		ShipName = shipName;
		this.balconyCap = balconyCap;
		this.oceanViewCap = oceanViewCap;
		this.suiteCap = suiteCap;
		this.interiorCap = interiorCap;
		this.inService = inService;
	}
	// Getters & Setters
	public String getShipName() {
		return ShipName;
	}

	public void setShipName(String shipName) {
		ShipName = shipName;
	}

	public int getBalconyCap() {
		return balconyCap;
	}

	public void setBalconyCap(int balconyCap) {
		this.balconyCap = balconyCap;
	}

	public int getOceanViewCap() {
		return oceanViewCap;
	}

	public void setOceanViewCap(int oceanViewCap) {
		this.oceanViewCap = oceanViewCap;
	}
	

	public int getSuiteCap() {
		return suiteCap;
	}

	public void setSuiteCap(int suiteCap) {
		this.suiteCap = suiteCap;
	}

	public int getInteriorCap() {
		return interiorCap;
	}

	public void setInteriorCap(int interiorCap) {
		this.interiorCap = interiorCap;
	}
	
	public boolean isInService() {
		return inService;
	}

	public void setInService(boolean inService) {
		this.inService = inService;
	}
	
	public void reduceBAL() {
		this.balconyCap -= 1;
	}
	public void reduceOCV() {
		this.oceanViewCap -= 1;
	}
	public void reduceSTE() {
		this.suiteCap -= 1;
	}
	public void reduceINT() {
		this.interiorCap -= 1;
	}
	
	public void increaseBAL() {
		this.balconyCap += 1;
	}
	public void increaseOCV() {
		this.oceanViewCap += 1;
	}
	public void increaseSTE() {
		this.suiteCap += 1;
	}
	public void increaseINT() {
		this.interiorCap += 1;
	}

	
	@Override
	public String toString() {
		String message = "Ship:"
				+ "\n\tShip Name: " + ShipName
				+ "\n\tBAL Capacity: " + balconyCap
				+ "\n\tOCV Capacity: " + oceanViewCap
				+ "\n\tSTE Capacity: " + suiteCap
				+ "\n\tINT Capacity: " + interiorCap
				+ "\n\tAvailability: " + inService + "\n";
		return message;
	}
	
	
	
}
