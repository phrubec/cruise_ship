public class Passenger {
	private String passengerName;
	private String cruiseName;
	private String roomType;
	
	// Default Constructor
	public Passenger() {
		super();
	}

	// Constructor with Fields
	public Passenger(String passengerName, String cruiseName, String roomType) {
		super();
		this.passengerName = passengerName;
		this.cruiseName = cruiseName;
		this.roomType = roomType;
	}

	// Setters and Getters
	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getCruiseName() {
		return cruiseName;
	}

	public void setCruiseName(String cruiseName) {
		this.cruiseName = cruiseName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	

	@Override
	public String toString() {
		String message = "Passenger:\n"
				+ "\n\tName: " + passengerName
				+ "\n\tCruise: " + cruiseName
				+ "\n\tRoom Type: " + roomType + "\n";
		return message;
	}
	
	
	
}


