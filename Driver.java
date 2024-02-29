import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



public class Driver {

	// Lists - Global
	private static ArrayList<Object> ShipList = new ArrayList<>();
	private static ArrayList<Object> CruiseList = new ArrayList<>();
	private static ArrayList<Object> PassengerList = new ArrayList<>();
	private static Scanner kb = new Scanner(System.in);
			
	public static void main(String[] args) {
		
		
		char choice ;
		// Set Lists hard coded for testing
		ShipList.add(new Ship("SS COD", 4, 5, 2, 10, true));
		ShipList.add(new Ship("SS LWS", 2, 3, 1, 12, true));
		ShipList.add(new Ship("SS 123", 10, 8, 15, 0, false));
		ShipList.add(new Ship("SS Inactive", 10, 10, 15, 10, false));
		CruiseList.add(new Cruise("PAC Cruise", "SS COD", "Along the Pacific"));
		CruiseList.add(new Cruise("ATL Cruise", "SS LWS", "Along the Atlantic"));
		PassengerList.add(new Passenger("Paul Hrubec", "PAC", "STE"));
		PassengerList.add(new Passenger("Ethan Tabz", "PAC", "OCV"));

		do {
		for (int i = 0; i < 50; i++)
			System.out.println();
		displayMenu();
		choice = kb.next().charAt(0);
		
		switch(choice) {
		case '1': // Add Ship ================================================================================
			addShip();
			break;	
		case '2': // Edit Ship ================================================================================
			kb.nextLine();
			System.out.print("Enter name of ship to change: ");
			String origName = kb.nextLine();
			System.out.print("Enter the edit:"
					+ "\n\t[1] = new ship name"
					+ "\n\t[2] = change ship availability"
					+ "\nEnter the edit choice: ");
			String editType = kb.nextLine();
			if (editType.equals("1")) 
				editShip(origName, "NAME");
			else if (editType.equals("2"))
				editShip(origName, "SERVICE");
			else
				System.out.println("Invalid Entry.");
			break;
		case '3': // Add Cruise ================================================================================
			// Check ship availability
			kb.nextLine();
			System.out.print("Enter Ship To Be Used: ");
			String shipCheck = kb.nextLine();
			addCruise(shipCheck);
			break;
		case '4': // Edit Cruise =================================================================================
			kb.nextLine();
			System.out.print("Enter name of cruise to change: ");
			String origCruiseName = kb.nextLine();
			System.out.print("Enter the edit:"
					+ "\n\t[1] = new cruise name"
					+ "\n\t[2] = change cruise details"
					+ "\nEnter the edit choice: ");
			String editCruiseType = kb.nextLine();
			if (editCruiseType.equals("1")) 
				editCruise(origCruiseName, "NAME");
			else if (editCruiseType.equals("2"))
				editCruise(origCruiseName, "SERVICE");
			else
				System.out.println("Invalid Entry");
			break;
		case '5': // Add Passenger ================================================================================
			kb.nextLine();
			System.out.print("Enter Desired Cruise: ");
			String cruiseCheck = kb.nextLine();
			addPassenger(cruiseCheck);
			break;
		case '6': // Edit Passenger ===============================================================================
			kb.nextLine();
			System.out.print("Enter passenger name to edit: ");
			String origPassengerName = kb.nextLine();
			System.out.print("Enter the edit:"
					+ "\n\t[1] = change passenger name"
					+ "\n\t[2] = change room type"
					+ "\nEnter the edit choice: ");
			String editPassengerType = kb.nextLine();
			if (editPassengerType.equals("1"))
				editPassenger(origPassengerName, "NAME");
			else if (editPassengerType.equals("2"))
				editPassenger(origPassengerName, "ROOM");
			else
				System.out.println("Invalid Entry.");
			break;
			
		case 'A': // Print Ship Names ================================================================================
			printShipList("NAME");
			break;
			
			
		case 'B': // Print Available Ships ================================================================================
			printShipList("ACTIVE");
			break;
			
			
		case 'C': // Print Full Ship List ================================================================================
			printShipList("ALL");
			break;
			
			
		case 'D': // Print Cruise Names ================================================================================
			printCruiseList("NAME"); 
			break;
			
			
		case 'E': // Print Cruise Names & Details ================================================================================
			printCruiseList("ALL");
			break;
			
		case 'F':
			printPassengerList();
			break;
			
		case 'x': // Exit
			System.out.println("Exiting");
			choice = 'x';
			break;
		default:
			System.out.println("Invalid Entry");
			
		}// Switch choice
		kb.nextLine();
		System.out.println("Press \"ENTER\" to continue...");
		kb.nextLine();
		} while (choice != 'x');
		
		
		System.out.println("End of program...");
		kb.close();
	} // void main
	
	// Outside Main Functions
	public static void printShipList(String listType) {
		/*
		 * Method to print the list of ships depending on the given type
		 * either 	 "ALL" => Print all ships & info
		 * 			 "NAME" => Print all ship names
		 * 			 "ACTIVE" => Print available ships
		 * 
		*/
		if (ShipList.size() < 1) {
			System.out.println("No ships in list");
			return;
		}
		if (listType == "NAME") {
			System.out.println("Ship Names:");
			for (Object s: ShipList) {
				System.out.println(((Ship) s).getShipName());
			}
			System.out.println();
		}
		else if (listType == "ACTIVE") {
			System.out.println("Active Ships:");
			for (Object s: ShipList) {
				if (((Ship) s).isInService()) {
					System.out.println(((Ship) s).getShipName());
				}
			}
			System.out.println();
		}
		else if (listType == "ALL") {
			for (Object s: ShipList) {
				System.out.println(s);
				System.out.println();
			}
			System.out.println();
		}
		else {
			System.out.println("Error: Called printShip with incorrect listType");
		}
	} // print ship list function
	public static void printCruiseList(String listType) {
		/*
		 * Method to print the list of cruises depending on the given type
		 * either 	 "ALL" => Print all cruises & details
		 * 			 "NAME" => Print all cruise names
		 * 
		*/
		if (ShipList.size() < 1) {
			System.out.println("No cruises in list");
			return;
		}
		if (listType == "NAME") {
			System.out.println("Cruise Names:");
			for (Object c: CruiseList) {
				System.out.println(((Cruise) c).getCruiseName());
			}
			System.out.println();
		}
		else if (listType == "ALL") {
			for (Object c: CruiseList) {
				System.out.println(c);
				System.out.println();
			}
			System.out.println();
		}
		else {
			System.out.println("Error: Called printCruise with incorrect listType");
		}
	} // print cruise list function
	public static void printPassengerList() {
		/*
		 * Method to print the list of passengers
		 * 
		*/
		if (PassengerList.size() < 1) {
			System.out.println("No passengers in list");
			return;
		}
		
		for (Object p: PassengerList) {
			System.out.println(p);
			System.out.println();
		}
		System.out.println();
		
	} // print cruise list function
	public static void editShip(String name, String task) {
		// verify ship
		if (!verifyShip(name)) {
			System.out.println("Not a registerd ship");
			return;
		}
		
		if (task == "NAME") {
			System.out.println("Enter new ship name: ");
			String newName = kb.nextLine();
			
			// Set new name in list for ships
			Iterator<Object> it = ShipList.iterator();
			while (it.hasNext()) {
				Ship sh = (Ship) it.next();
				if (sh.getShipName().equals(name)) {
					((Ship) sh).setShipName(newName);
				}
			}
			// Set new name in list for cruises
			Iterator<Object> it2 = CruiseList.iterator();
			while (it2.hasNext()) {
				Cruise c = (Cruise) it2.next();
				if (c.getCruiseShip().equals(name)) {
					((Cruise) c).setCruiseShip(newName);
				}
			}
			System.out.println("Name Change: Complete");
		}// if statement
		
		if (task == "SERVICE") {
			System.out.println("Is this ship available?:"
					+ "\n\t[1] = YES"
					+ "\n\t[2] = NO"
					+ "\nEnter the edit choice: ");
			int answer = kb.nextInt();
			boolean bool = false;
			if (answer == 1)
				bool = true;
			else
				bool = false;
				
			Iterator<Object> it = ShipList.iterator();
			while (it.hasNext()) {
				Ship sh = (Ship) it.next();
				if (sh.getShipName().equals(name)) {
					((Ship) sh).setInService(bool);
				}
			}
		}// if statement
		
		if (task == "-BAL") {
			Iterator<Object> it = ShipList.iterator();
			while (it.hasNext()) {
				Ship sh = (Ship) it.next();
				if (sh.getShipName().equals(name)) {
					((Ship) sh).reduceBAL();
				}
			}
		}// if statement
		if (task == "-OCV") {
			Iterator<Object> it = ShipList.iterator();
			while (it.hasNext()) {
				Ship sh = (Ship) it.next();
				if (sh.getShipName().equals(name)) {
					((Ship) sh).reduceOCV();
				}
			}
		}// if statement
		if (task == "-STE") {
			Iterator<Object> it = ShipList.iterator();
			while (it.hasNext()) {
				Ship sh = (Ship) it.next();
				if (sh.getShipName().equals(name)) {
					((Ship) sh).reduceSTE();
				}
			}
		}// if statement
		if (task == "-INT") {
			Iterator<Object> it = ShipList.iterator();
			while (it.hasNext()) {
				Ship sh = (Ship) it.next();
				if (sh.getShipName().equals(name)) {
					((Ship) sh).reduceINT();
				}
			}
		}// if statement
		
		if (task == "+BAL") {
			Iterator<Object> it = ShipList.iterator();
			while (it.hasNext()) {
				Ship sh = (Ship) it.next();
				if (sh.getShipName().equals(name)) {
					((Ship) sh).increaseBAL();
				}
			}
		}// if statement
		if (task == "+OCV") {
			Iterator<Object> it = ShipList.iterator();
			while (it.hasNext()) {
				Ship sh = (Ship) it.next();
				if (sh.getShipName().equals(name)) {
					((Ship) sh).increaseOCV();
				}
			}
		}// if statement
		if (task == "+STE") {
			Iterator<Object> it = ShipList.iterator();
			while (it.hasNext()) {
				Ship sh = (Ship) it.next();
				if (sh.getShipName().equals(name)) {
					((Ship) sh).increaseSTE();
				}
			}
		}// if statement
		if (task == "+INT") {
			Iterator<Object> it = ShipList.iterator();
			while (it.hasNext()) {
				Ship sh = (Ship) it.next();
				if (sh.getShipName().equals(name)) {
					((Ship) sh).increaseINT();
				}
			}
		}// if statement
		
		
	}	
	public static void editCruise(String name, String task) {
		// verify cruise
		if (!verifyCruise(name)) {
			System.out.println("Not a registerd cruise");
			return;
		}
		
		if (task == "NAME") {
			System.out.print("Enter new cruise name: ");
			String newName = kb.nextLine();
			Iterator<Object> it = CruiseList.iterator();
			while (it.hasNext()) {
				Cruise c = (Cruise) it.next();
				if (c.getCruiseName().equals(name)) 
					((Cruise) c).setCruiseName(newName);
			}
			System.out.println("Name Change: Complete");
			return;
		}// if statement
		
		if (task == "SERVICE") {
			System.out.print("Enter new cruise details: ");
			String details = kb.nextLine();
			Iterator<Object> it = CruiseList.iterator();
			while (it.hasNext()) {
				Cruise c = (Cruise) it.next();
				if (c.getCruiseName().equals(name)) 
					((Cruise) c).setCruiseDetails(details);
			}
			System.out.println("Details Change: Complete");
			return;
		}
	}
	public static void editPassenger(String name, String task) {
		// verify passenger
		if (!verifyPassenger(name)) {
			System.out.println("Not a registerd passenger");
			return;
		}
		if (task == "NAME") {
			System.out.print("Enter new name: ");
			String newName = kb.nextLine();
			Iterator<Object> it = PassengerList.iterator();
			while (it.hasNext()) {
				Passenger p = (Passenger) it.next();
				if (p.getPassengerName().equals(name)) 
					((Passenger) p).setPassengerName(newName);
			}
			System.out.println("Name Changed");
			return;
		}
		if (task == "ROOM") {
			// get current cruise 
			String currentCruise = "";
			String currentType = "";
			Iterator<Object> it = PassengerList.iterator();
			while (it.hasNext()) {
				Passenger p = (Passenger) it.next();
				if (p.getPassengerName().equals(name)) {
					currentCruise = ((Passenger) p).getCruiseName();
					currentType = ((Passenger) p).getRoomType();
				}
			}
			
			System.out.print("Room Types:"
					+ "\n[1] = Balcony"
					+ "\n[2] = Ocean View"
					+ "\n[3] = Suite"
					+ "\n[4] = Interior"
					+ "\n\nEnter room type: ");
			int typeNum = kb.nextInt();
			String type = "";
			if (typeNum == 1)
				type = "BAL";
			else if (typeNum == 2)
				type = "OCV";
			else if (typeNum == 3)
				type = "STE";
			else if (typeNum == 4)
				type = "INT";
			else {
				System.out.println("Invalid room type provided");
				return;
			}
			// check availability
			int space = roomAvailability(currentCruise, type);
			String switched = "";
			if (space > 0) {
				kb.nextLine();
				System.out.print("\nThere are " + space + " rooms available"
						+ "\nWould you like to switch[y/n]?");
				switched = kb.nextLine();
			}
			else {
				System.out.print("\nNo rooms available for that. Max Capacity\n");
				return;
			}
			
			// complete switch
			if (switched.equals("y")) {
				String sName = cruiseToShipName(currentCruise);
				if (typeNum == 1)
					editShip(sName, "-BAL");
				else if (typeNum == 2)
					editShip(sName, "-OCV");
				else if (typeNum == 3)
					editShip(sName, "-STE");
				else if (typeNum == 4)
					editShip(sName, "-INT");
				
				if (currentType.equals("BAL"))
					editShip(sName, "+BAL");
				else if (currentType.equals("OCV"))
					editShip(sName, "+OCV");
				else if (currentType.equals("STE"))
					editShip(sName, "+STE");
				else if (currentType.equals("INT"))
					editShip(sName, "+INT");
				
				System.out.println("Switched");
				return;
			}
		}// if statement
	}
	public static void addShip() {
		kb.nextLine();
		System.out.print("Enter Ship Name: ");
		String nm = kb.nextLine();
		System.out.print("Enter Balcony Capacity: ");
		int bc = kb.nextInt();
		System.out.print("Enter Ocean-View Capacity: ");
		int oc = kb.nextInt();
		System.out.print("Enter Suite Capacity: ");
		int sc = kb.nextInt();
		System.out.print("Enter Interior Capacity: ");
		int ic = kb.nextInt();
		kb.nextLine();
		System.out.print("Is Ship Available (Y/N): ");
		String ready = kb.nextLine();
		boolean bool;
		if (ready.equals("Y") || ready.equals("y")) {
			bool = true;
		}
		else {
			bool = false;
		}
		System.out.println("Ship Added.");
		ShipList.add(new Ship(nm, bc, oc, sc, ic, bool));
	}
	public static void addCruise(String check) {
		// verify ship
		if (!verifyShip(check)) {
			System.out.println("Not a registered ship");
			return;
		}
		
		System.out.print("Enter Cruise Name: ");
		String cn = kb.nextLine();
		System.out.print("Enter Cruise Details: ");
		String dt = kb.nextLine();
		System.out.println("Cruise added.");
		CruiseList.add(new Cruise(cn, check, dt));
	}
	public static void addPassenger(String check) {
		// check the cruise
		if (!verifyCruise(check)) {
			System.out.println("Not a registerd cruise");
			return;
		}
		System.out.print("Enter full name: ");
		String name = kb.nextLine();
		System.out.print("Room Types:"
				+ "\n[1] = Balcony"
				+ "\n[2] = Ocean View"
				+ "\n[3] = Suite"
				+ "\n[4] = Interior"
				+ "\n\nEnter room type: ");
		int typeNum = kb.nextInt();
		String type = "";
		if (typeNum == 1)
			type = "BAL";
		else if (typeNum == 2)
			type = "OCV";
		else if (typeNum == 3)
			type = "STE";
		else if (typeNum == 4)
			type = "INT";
		else {
			System.out.println("Invalid room type provided, passenger not added");
			return;
		}
		
		// check availability
		int space = roomAvailability(check, type);
		String purchase = "";
		if (space > 0) {
			kb.nextLine();
			System.out.print("\nThere are " + space + " rooms available"
					+ "\nWould you like a room[y/n]? ");
			purchase = kb.nextLine();
		}
		else {
			System.out.println("\nNo rooms available for that. Max Capacity");
		}
	
		if (purchase.equals("y")) {
			String sName = cruiseToShipName(check);
			if (typeNum == 1)
				editShip(sName, "-BAL");
			else if (typeNum == 2)
				editShip(sName, "-OCV");
			else if (typeNum == 3)
				editShip(sName, "-STE");
			else if (typeNum == 4)
				editShip(sName, "-INT");
			
			System.out.println("Purchased");
		}
		else {
			System.out.println("\nReturning back to menu...");
			return;
		}
		System.out.println("Passenger Added.");
		PassengerList.add(new Passenger(name, check, type));
		
		return;
	}
	public static boolean verifyCruise(String name) {
		boolean bool = false;
		
		Iterator<Object> it = CruiseList.iterator();
		while (it.hasNext()) {
			Cruise c = (Cruise) it.next();
			if (c.getCruiseName().equals(name)) 
				bool = true;
		}
		
		return bool;
	}
	public static boolean verifyShip(String name) {
		boolean bool = false;
		Iterator<Object> it = ShipList.iterator();
		while (it.hasNext()) {
			Ship c = (Ship) it.next();
			if (c.getShipName().equals(name)) 
				bool = true;
		}
		return bool;
	}
	public static boolean verifyPassenger(String name) {
		boolean bool = false;
		Iterator<Object> it = PassengerList.iterator();
		while (it.hasNext()) {
			Passenger p = (Passenger) it.next();
			if (p.getPassengerName().equals(name)) 
				bool = true;
		}
		return bool;
	}
	public static int roomAvailability(String cName, String room) {
		String findShip = "";
		
		Iterator<Object> it = CruiseList.iterator();
		while (it.hasNext()) {
			Cruise c = (Cruise) it.next();
			if (c.getCruiseName().equals(cName)) 
				findShip = c.getCruiseShip();
		}
		
		Iterator<Object> it2 = ShipList.iterator();
		while (it2.hasNext()) {
			Ship s = (Ship) it2.next();
			if (s.getShipName().equals(findShip)) {
				if (room == "BAL")
					return s.getBalconyCap();
				else if (room == "OCV")
					return s.getOceanViewCap();
				else if (room == "STE")
					return s.getSuiteCap();
				else if (room == "INT")
					return s.getInteriorCap();
			}
		}
		return 0;
	}
	public static String cruiseToShipName(String cName) {
		String findShip = "";
		
		Iterator<Object> it = CruiseList.iterator();
		while (it.hasNext()) {
			Cruise c = (Cruise) it.next();
			if (c.getCruiseName().equals(cName)) 
				findShip = c.getCruiseShip();
		}
		
		Iterator<Object> it2 = ShipList.iterator();
		while (it2.hasNext()) {
			Ship s = (Ship) it2.next();
			if (s.getShipName().equals(findShip)) {
				findShip = s.getShipName();
				return findShip;
			}
		}
		return findShip;

	}
	public static void displayMenu() {
		System.out.println("Make a selection:\n"
				+ "\t[1] Add Ship 		\t[A] Print Ship Names\n"
				+ "\t[2] Edit Ship 		\t[B] Print Available Ships\n"
				+ "\t[3] Add Cruise 	\t\t[C] Print Full Ship List\n"
				+ "\t[4] Edit Cruise 	\t[D] Print Cruise List\n"
				+ "\t[5] Add Passenger 	\t[E] Print Cruise Details\n"
				+ "\t[6] Edit Passenger \t\t[F] Print Passenger List\n"
				+ "\t[x] Exit Program");

		System.out.print("\nEnter choice here: ");
	}
} // last bracket 




