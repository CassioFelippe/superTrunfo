// import java.util.Scanner;
// import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static Scanner scan = new Scanner(System.in);

	public static int idVehicle = 0;
	public static int idCc = 0;
	public static int idZeroToHundred = 0;
	public static int idMaxSpeed = 0;
	public static int idStrength = 0;
	public static int idSize = 0;
	public static int idWeight = 0;

	// INCREMENTA id AUTOMATICAMENTE
	public static int generateId(String classType) {
		switch (classType) {
		case "vehicle":
			return ++idVehicle;

		case "cc":
			return ++idCc;

		case "zeroToHundred":
			return ++idZeroToHundred;

		case "maxSpeed":
			return ++idMaxSpeed;
			
		case "strength":
			return ++idStrength;
			
		case "size":
			return ++idSize;
			
		case "weight":
			return ++idWeight;

		default:
			System.err.println("Failed to switch in getId() method!");
			return 0;
		}
	}

	public static class Cc {
		private final int id = generateId("cc");
		private int value;
		private final String um = "cc";
		public int getId() {
			return id;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getUm() {
			return um;
		}
	}

	public static class ZeroToHundred {
		private final int id = generateId("zeroToHundred");
		private int value;
		private final String um = "s";
		public int getId() {
			return id;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getUm() {
			return um;
		}
	}

	public static class MaxSpeed {
		private final int id = generateId("maxSpeed");
		private int value;
		private final String um = "km/h";
		public int getId() {
			return id;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getUm() {
			return um;
		}
	}
	
	public static class Strength {
		private final int id = generateId("strength");
		private int value;
		private final String um = "CV";
		public int getId() {
			return id;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getUm() {
			return um;
		}
	}
	
	public static class Size {
		private final int id = generateId("size");
		private int value;
		private final String um = "cm";
		public int getId() {
			return id;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getUm() {
			return um;
		}
	}
	
	public static class Weight {
		private final int id = generateId("size");
		private int value;
		private final String um = "kg";
		public int getId() {
			return id;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getUm() {
			return um;
		}
	}

	public static class Vehicle {
		public Vehicle(){
			this(null, null, null, null, null, null, null);
		}
		public Vehicle(	
				String name,
				Cc cc,
				Strength strength,
				MaxSpeed maxSpeed,
				ZeroToHundred zeroToHundred,
				Size size,
				Weight weight
				){
//			super(Vehicle.class, name, cc, strength, maxSpeed, zeroToHundred, size, weight);
		}
		private final int id = generateId("vehicle");
		private String name = "";
		private Cc cc = new Cc();
		private Strength strength = new Strength();
		private MaxSpeed maxSpeed = new MaxSpeed();
		private ZeroToHundred zeroToHundred = new ZeroToHundred();
		private Size size = new Size();
		private Weight weight = new Weight();
	}

	public static List<Vehicle> vehicles = new ArrayList<Vehicle>();
	// public static class Vehicles {
	// public static List<Vehicle> vehicles = new ArrayList<Vehicle>();

	// public static void add(Vehicle vehicle){
	// vehicles.add(vehicle);
	// }
	// }

	public static void createVehicle() {
		Vehicle vehicle = new Vehicle();

		System.out.println("\nInsert the vehicle name: ");
		scan.nextLine();
		vehicle.name = scan.nextLine();
		System.out.println("\nInsert the vehicle cc: ");
		vehicle.cc.value = scan.nextInt();
		System.out.println("\nInsert the vehicle strength: ");
		vehicle.strength.value = scan.nextInt();
		System.out.println("\nInsert the vehicle maximum speed: ");
		vehicle.maxSpeed.value = scan.nextInt();
		System.out.println("\nInsert the vehicle zero to hundred: ");
		vehicle.zeroToHundred.value = scan.nextInt();
		System.out.println("\nInsert the vehicle size: ");
		vehicle.size.value = scan.nextInt();
		System.out.println("\nInsert the vehicle weight: ");
		vehicle.weight.value = scan.nextInt();

		vehicles.add(vehicle);
	}

	public static void showVehicles() {
		for (Vehicle v : vehicles) {
			System.out.println(v.id + " - " + v.name);
		}
	}

	public static void battle(Vehicle v1, Vehicle v2) {
		Vehicle winner = new Vehicle();
		Vehicle loser = new Vehicle();

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("###########################");
		System.out.println("# ----------------------- #  --- Vehicle 1 ---");
		System.out.println("#          BATTLE         #  Id: " + v1.id);
		System.out.println("# ----------------------- #  Name: " + v1.name);
		System.out.println("#     Choose a skill:     #");
		System.out.println("#                         #  --- Vehicle 2 ---");
		System.out.println("# 1 - Cc                  #  Id: " + v2.id);
		System.out.println("# 2 - Strength            #  Name: " + v2.name);
		System.out.println("# 3 - Maximum speed       #");
		System.out.println("# 4 - Zero to hundred     #");
		System.out.println("# 5 - Size                #");
		System.out.println("# 6 - Weight              #");
		System.out.println("# 0 - Cancel              #");
		System.out.println("#                         #");
		System.out.println("###########################");

		int option = scan.nextInt();

		if (option == 1) {
			System.out.println(v1.name + " cc: " + v1.cc.value + v1.cc.um);
			System.out.println(v2.name + " cc: " + v2.cc.value + v2.cc.um);
			if (v1.cc.value > v2.cc.value) {
				winner = v1;
				loser = v2;
			} else if (v1.cc.value == v2.cc.value) {
				option = -2;
			} else {
				winner = v2;
				loser = v1;
			}
		} else if (option == 2) {
			System.out.println(v1.name + " strength: " + v1.strength.value + v1.strength.um);
			System.out.println(v2.name + " strength: " + v2.strength.value + v2.strength.um);
			if (v1.strength.value > v2.strength.value) {
				winner = v1;
				loser = v2;
			} else if (v1.strength == v2.strength) {
				option = -2;
			} else {
				winner = v2;
				loser = v1;
			}
		} else if (option == 3) {
			System.out.println(v1.name + " maximum speed: " + v1.maxSpeed.value + v1.maxSpeed.um);
			System.out.println(v2.name + " maximum speed: " + v2.maxSpeed.value + v2.maxSpeed.um);
			if (v1.maxSpeed.value > v2.maxSpeed.value) {
				winner = v1;
				loser = v2;
			} else if (v1.maxSpeed.value == v2.maxSpeed.value) {
				option = -2;
			} else {
				winner = v2;
				loser = v1;
			}
		} else if (option == 4) {
			System.out.println(v1.name + " zero to hundred: " + v1.zeroToHundred.value + v1.zeroToHundred.um);
			System.out.println(v2.name + " zero to hundred: " + v2.zeroToHundred.value + v2.zeroToHundred.um);
			if (v1.zeroToHundred.value < v2.zeroToHundred.value) {
				winner = v1;
				loser = v2;
			} else if (v1.zeroToHundred.value == v2.zeroToHundred.value) {
				option = -2;
			} else {
				winner = v2;
				loser = v1;
			}
		} else if (option == 5) {
			System.out.println(v1.name + " size: " + v1.size.value + v1.size.um);
			System.out.println(v2.name + " size: " + v2.size.value + v2.size.um);
			if (v1.size.value < v2.size.value) {
				winner = v1;
				loser = v2;
			} else if (v1.size.value == v2.size.value) {
				option = -2;
			} else {
				winner = v2;
				loser = v1;
			}
		} else if (option == 6) {
			System.out.println(v1.name + " weight: " + v1.weight.value + v1.weight.um);
			System.out.println(v2.name + " weight: " + v2.weight.value + v2.weight.um);
			if (v1.weight.value < v2.weight.value) {
				winner = v1;
				loser = v2;
			} else if (v1.weight.value == v2.weight.value) {
				option = -2;
			} else {
				winner = v2;
				loser = v1;
			}
		} else {
			System.err.println("Invalid entry, returning to main menu...");
			option = -1;
		}
		if (option == -2) {
			System.err.println("Draw!");
		} else if (option != -1) {
			System.out.println("The winner is: " + winner.name);
			System.out.println("The loser is: " + loser.name);
		}
	}

	public static void editVehicle() {
		System.out.println("Insert the vehicle id: ");
		int option = scan.nextInt();
		Vehicle eVehicle = new Vehicle();
		boolean vehicleFound = false;

		for (Vehicle v : vehicles) {
			if (v.id == option) {
				eVehicle = v;
				vehicleFound = true;
			}
		}

		if (vehicleFound) {
			System.out.print("\nName (old -> " + eVehicle.name + "): ");
			eVehicle.name = scan.next();
			System.out.print("\nCc (old -> " + eVehicle.cc.value + "): ");
			eVehicle.cc.value = scan.nextInt();
			System.out.print("\nStrength (old -> " + eVehicle.strength.value + "): ");
			eVehicle.strength.value = scan.nextInt();
			System.out.print("\nMaximum speed (old -> " + eVehicle.maxSpeed.value + "): ");
			eVehicle.maxSpeed.value = scan.nextInt();
			System.out.print("\nZero to hundred (old -> " + eVehicle.zeroToHundred.value + "): ");
			eVehicle.zeroToHundred.value = scan.nextInt();
			System.out.print("\nSize (old -> " + eVehicle.size.value + "): ");
			eVehicle.size.value = scan.nextInt();
			System.out.print("\nWeight (old -> " + eVehicle.weight.value + "): ");
			eVehicle.weight.value = scan.nextInt();
		} else {
			System.err.println("No vehicle found, returning to main menu...\n\n\n");
		}

	}

	public static void detailVehicle() {
		System.out.println("Insert the vehicle id: ");
		int option = scan.nextInt();
		boolean vehicleFound = false;

		for (Vehicle v : vehicles) {
			if (v.id == option) {
				System.out.print("\nName: " + v.name);
				System.out.print("\nCc: " + v.cc.value + v.cc.um);
				System.out.print("\nStrength: " + v.strength.value + v.strength.um);
				System.out.print("\nMaximum speed: " + v.maxSpeed.value + v.maxSpeed.um);
				System.out.print("\nZero to hundred: " + v.zeroToHundred.value + v.zeroToHundred.um);
				System.out.print("\nSize: " + v.size.value + v.size.um);
				System.out.print("\nWeight: " + v.weight.value + v.weight.um);
				vehicleFound = true;
				break;
			}
		}
		if (!vehicleFound) {
			System.err.println("No vehicle found, returning to main menu...\n\n\n");
		}
	}

	public static void deleteVehicle() {
		System.out.println("\nInsert de id of the vehicle to be deleted: ");
		int id = scan.nextInt();
		Boolean vehicleFound = false;
		
		for (Vehicle v : vehicles) {
			if (v.id == id) {
				vehicles.remove(v);
				System.out.println("Vehicle deleted: " + v.id + " - " + v.name);
				vehicleFound = true;
				break;
			}
		}
		
		if(!vehicleFound) {
			System.err.println("No vehicle found, returning to main menu...\n\n\n");
		}
	}

	public static void shutdown() {
		System.out.print("\nAre you sure? Type 1 to shutdown or 0 to main menu: ");
		int option = scan.nextInt();

		if (option == 1) {
			System.out.println("\nShutting system down...\n");
			System.exit(0);
		} else if (option == 0) {
			System.out.println("\nReturning to main menu...\n");
		} else {
			System.out.println("\nInvalid entry! Returning to main menu...\n");
		}
	}

	public static int menu() {
		System.out.println("\n\n");
		System.out.println("###########################");
		System.out.println("# ----------------------- #");
		System.out.println("#   WELCOME TO THE GAME   #");
		System.out.println("# ----------------------- #");
		System.out.println("#                         #");
		System.out.println("# 1 - Create a vehicle    #");
		System.out.println("# 2 - Show your vehicles  #");
		System.out.println("# 3 - Battle a rival      #");
		System.out.println("# 4 - Edit a vehicle      #");
		System.out.println("# 5 - Detail a vehicle    #");
		System.out.println("# 6 - Delete a vehicle    #");
		System.out.println("# 0 - Shutdown            #");
		System.out.println("#                         #");
		System.out.println("###########################");
		System.out.print("Enter a number: ");

		int option = scan.nextInt();

		return option;
	}

	public static void init() {
//		POPULATE VEHICLES
		Vehicle vehicle = new Vehicle();
		vehicle.name = "Fox Sportline";
		vehicle.cc = new Cc();
		vehicle.cc.setValue(1599);
		vehicle.strength = new Strength();
		vehicle.strength.setValue(101);
		vehicle.maxSpeed = new MaxSpeed();
		vehicle.maxSpeed.setValue(186);
		vehicle.zeroToHundred = new ZeroToHundred();
		vehicle.zeroToHundred.setValue(10);	// 10.8
		vehicle.size = new Size();
		vehicle.size.setValue(3804);
		vehicle.weight = new Weight();
		vehicle.weight.setValue(1040);
		vehicles.add(vehicle);
		
		vehicle = new Vehicle();
		vehicle.name = "Golf GTI";
		vehicle.cc = new Cc();
		vehicle.cc.setValue(1781);
		vehicle.strength = new Strength();
		vehicle.strength.setValue(180);
		vehicle.maxSpeed = new MaxSpeed();
		vehicle.maxSpeed.setValue(227);
		vehicle.zeroToHundred = new ZeroToHundred();
		vehicle.zeroToHundred.setValue(7);	// 7.8
		vehicle.size = new Size();
		vehicle.size.setValue(4147);
		vehicle.weight = new Weight();
		vehicle.weight.setValue(1251);
		vehicles.add(vehicle);
		
		vehicle = new Vehicle();
		vehicle.name = "Gol Power";
		vehicle.cc = new Cc();
		vehicle.cc.setValue(1781);
		vehicle.strength = new Strength();
		vehicle.strength.setValue(103);
		vehicle.maxSpeed = new MaxSpeed();
		vehicle.maxSpeed.setValue(189);
		vehicle.zeroToHundred = new ZeroToHundred();
		vehicle.zeroToHundred.setValue(10);	// 10.1
		vehicle.size = new Size();
		vehicle.size.setValue(3931);
		vehicle.weight = new Weight();
		vehicle.weight.setValue(988);
		vehicles.add(vehicle);

		vehicle = new Vehicle();
		vehicle.name = "GX3";
		vehicle.cc = new Cc();
		vehicle.cc.setValue(1600);
		vehicle.strength = new Strength();
		vehicle.strength.setValue(125);
		vehicle.maxSpeed = new MaxSpeed();
		vehicle.maxSpeed.setValue(230);
		vehicle.zeroToHundred = new ZeroToHundred();
		vehicle.zeroToHundred.setValue(5);	// 5.7
		vehicle.size = new Size();
		vehicle.size.setValue(3754);
		vehicle.weight = new Weight();
		vehicle.weight.setValue(570);
		vehicles.add(vehicle);
		
		vehicle = new Vehicle();
		vehicle.name = "Iroc";
		vehicle.cc = new Cc();
		vehicle.cc.setValue(1390);
		vehicle.strength = new Strength();
		vehicle.strength.setValue(210);
		vehicle.maxSpeed = new MaxSpeed();
		vehicle.maxSpeed.setValue(242);
		vehicle.zeroToHundred = new ZeroToHundred();
		vehicle.zeroToHundred.setValue(7);	// 7.0
		vehicle.size = new Size();
		vehicle.size.setValue(4240);
		vehicle.weight = new Weight();
		vehicle.weight.setValue(1360);
		vehicles.add(vehicle);
		
		vehicle = new Vehicle();
		vehicle.name = "Jetta";
		vehicle.cc = new Cc();
		vehicle.cc.setValue(2480);
		vehicle.strength = new Strength();
		vehicle.strength.setValue(150);
		vehicle.maxSpeed = new MaxSpeed();
		vehicle.maxSpeed.setValue(208);
		vehicle.zeroToHundred = new ZeroToHundred();
		vehicle.zeroToHundred.setValue(9);	// 9.6
		vehicle.size = new Size();
		vehicle.size.setValue(4554);
		vehicle.weight = new Weight();
		vehicle.weight.setValue(1462);
		vehicles.add(vehicle);
		
		vehicle = new Vehicle();
		vehicle.name = "Kombi";
		vehicle.cc = new Cc();
		vehicle.cc.setValue(1390);
		vehicle.strength = new Strength();
		vehicle.strength.setValue(57);
		vehicle.maxSpeed = new MaxSpeed();
		vehicle.maxSpeed.setValue(130);
		vehicle.zeroToHundred = new ZeroToHundred();
		vehicle.zeroToHundred.setValue(16);	// 16.1
		vehicle.size = new Size();
		vehicle.size.setValue(4505);
		vehicle.weight = new Weight();
		vehicle.weight.setValue(1297);
		vehicles.add(vehicle);
		
		vehicle = new Vehicle();
		vehicle.name = "Nardo";
		vehicle.cc = new Cc();
		vehicle.cc.setValue(5998);
		vehicle.strength = new Strength();
		vehicle.strength.setValue(600);
		vehicle.maxSpeed = new MaxSpeed();
		vehicle.maxSpeed.setValue(349);
		vehicle.zeroToHundred = new ZeroToHundred();
		vehicle.zeroToHundred.setValue(3);	// 3.5
		vehicle.size = new Size();
		vehicle.size.setValue(4550);
		vehicle.weight = new Weight();
		vehicle.weight.setValue(1200);
		vehicles.add(vehicle);
	}
	
	public static void main(String[] args) {
		System.out.println("System starting...\n\n");
		
		init();

		while (true) {
			int userEntry = menu();

			switch (userEntry) {
			case 1:
				createVehicle();
				break;

			case 2:
				showVehicles();
				break;

			case 3:
				battle(vehicles.get(1), vehicles.get(2));
				break;

			case 4:
				editVehicle();
				break;

			case 5:
				detailVehicle();
				break;

			case 6:
				deleteVehicle();
				break;

			case 0:
				shutdown();
				break;

			default:
				System.err.println("ERR: method not found to option " + userEntry);
				break;
			}
		}
	}
}