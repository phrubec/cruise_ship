
public class Cruise{
	private String cruiseName;
	private String cruiseShip;
	private String cruiseDetails;
	
	public Cruise() {
		super();
	}
	
	public Cruise(String cruiseName, String cruiseShip, String cruiseDetails) {
		super();
		this.cruiseName = cruiseName;
		this.cruiseShip = cruiseShip;
		this.cruiseDetails = cruiseDetails;
	}

	public String getCruiseName() {
		return cruiseName;
	}
	
	public void setCruiseName(String cruiseName) {
		this.cruiseName = cruiseName;
	}

	public String getCruiseShip() {
		return cruiseShip;
	}

	public void setCruiseShip(String cruiseShip) {
		this.cruiseShip = cruiseShip;
	}


	public String getCruiseDetails() {
		return cruiseDetails;
	}

	public void setCruiseDetails(String cruiseDetails) {
		this.cruiseDetails = cruiseDetails;
	}
	
	@Override
	public String toString() {
		String message = "Cruise:"
				+ "\n\tCruise Name: " + cruiseName
				+ "\n\tCruise Ship: " + cruiseShip
				+ "\n\tDetails: " + cruiseDetails + "\n";
		return message;
	}
}
