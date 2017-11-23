package main;

import static java.lang.Boolean.TRUE;

// import java.util.Scanner;
// import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static Scanner scan = new Scanner(System.in);

	public static Integer idVehicle = 0;

	// INCREMENTA id AUTOMATICAMENTE
	public static Integer generateVehicleId() {
		return ++idVehicle;
	}

	public static List<Vehicle> vehicles = new ArrayList<Vehicle>();

	public static void addVehicle(Vehicle v) {
		vehicles.add(v);
	}
	
	public static void createVehicle() {
		Vehicle vehicle = new Vehicle();

		System.out.println("\nInsert the vehicle name: ");
		vehicle.setName(scan.nextLine());
		System.out.println("\nInsert the vehicle cc: ");

		vehicles.add(vehicle);
	}

	public static void showVehicles() {
		for (Vehicle v : vehicles) {
			System.out.println(v.getId() + " - " + v.getName());
		}
	}

	public static void battle(Vehicle v1, Vehicle v2) {
		Vehicle winner = new Vehicle();
		Vehicle loser = new Vehicle();

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("###########################");
		System.out.println("# ----------------------- #  --- Vehicle 1 ---");
		System.out.println("#          BATTLE         #  Id: " + v1.getId());
		System.out.println("# ----------------------- #  Name: " + v1.getName());
		System.out.println("#     Choose a skill:     #");
		System.out.println("#                         #  --- Vehicle 2 ---");
		System.out.println("# 1 - Maximum speed       #  Id: " + v2.getId());
		System.out.println("# 2 - Cc                  #  Name: " + v2.getName());
		System.out.println("# 3 - Zero to hundred     #");
		System.out.println("# 4 - Strength            #");
		System.out.println("# 5 - Size                #");
		System.out.println("# 6 - Weight              #");
		System.out.println("# 0 - Cancel              #");
		System.out.println("#                         #");
		System.out.println("###########################");

		Integer option = scan.nextInt();

		for(Attribute a : v1.getAttributes()) {
			if(a.getId() == option) {
				
			}
		}
		
//		if (option == 1) {
//			System.out.println(v1.getName() + " cc: " + v1.cc.value + v1.cc.um);
//			System.out.println(v2.getName() + " cc: " + v2.cc.value + v2.cc.um);
//			if (v1.cc.value > v2.cc.value) {
//				winner = v1;
//				loser = v2;
//			} else if (v1.cc.value == v2.cc.value) {
//				option = -2;
//			} else {
//				winner = v2;
//				loser = v1;
//			}
//		} else if (option == 2) {
//			System.out.println(v1.name + " strength: " + v1.strength.value + v1.strength.um);
//			System.out.println(v2.name + " strength: " + v2.strength.value + v2.strength.um);
//			if (v1.strength.value > v2.strength.value) {
//				winner = v1;
//				loser = v2;
//			} else if (v1.strength == v2.strength) {
//				option = -2;
//			} else {
//				winner = v2;
//				loser = v1;
//			}
//		} else if (option == 3) {
//			System.out.println(v1.name + " maximum speed: " + v1.maxSpeed.value + v1.maxSpeed.um);
//			System.out.println(v2.name + " maximum speed: " + v2.maxSpeed.value + v2.maxSpeed.um);
//			if (v1.maxSpeed.value > v2.maxSpeed.value) {
//				winner = v1;
//				loser = v2;
//			} else if (v1.maxSpeed.value == v2.maxSpeed.value) {
//				option = -2;
//			} else {
//				winner = v2;
//				loser = v1;
//			}
//		} else if (option == 4) {
//			System.out.println(v1.name + " zero to hundred: " + v1.zeroToHundred.value + v1.zeroToHundred.um);
//			System.out.println(v2.name + " zero to hundred: " + v2.zeroToHundred.value + v2.zeroToHundred.um);
//			if (v1.zeroToHundred.value < v2.zeroToHundred.value) {
//				winner = v1;
//				loser = v2;
//			} else if (v1.zeroToHundred.value == v2.zeroToHundred.value) {
//				option = -2;
//			} else {
//				winner = v2;
//				loser = v1;
//			}
//		} else if (option == 5) {
//			System.out.println(v1.name + " size: " + v1.size.value + v1.size.um);
//			System.out.println(v2.name + " size: " + v2.size.value + v2.size.um);
//			if (v1.size.value < v2.size.value) {
//				winner = v1;
//				loser = v2;
//			} else if (v1.size.value == v2.size.value) {
//				option = -2;
//			} else {
//				winner = v2;
//				loser = v1;
//			}
//		} else if (option == 6) {
//			System.out.println(v1.name + " weight: " + v1.weight.value + v1.weight.um);
//			System.out.println(v2.name + " weight: " + v2.weight.value + v2.weight.um);
//			if (v1.weight.value < v2.weight.value) {
//				winner = v1;
//				loser = v2;
//			} else if (v1.weight.value == v2.weight.value) {
//				option = -2;
//			} else {
//				winner = v2;
//				loser = v1;
//			}
//		} else {
//			System.err.println("Invalid entry, returning to main menu...");
//			option = -1;
//		}
//		if (option == -2) {
//			System.err.println("Draw!");
//		} else if (option != -1) {
//			System.out.println("The winner is: " + winner.name);
//			System.out.println("The loser is: " + loser.name);
//		}
	}

	public static void editVehicle() {
//		System.out.println("Insert the vehicle id: ");
//		int option = scan.nextInt();
//		Vehicle eVehicle = new Vehicle();
//		boolean vehicleFound = false;
//
//		for (Vehicle v : vehicles) {
//			if (v.id == option) {
//				eVehicle = v;
//				vehicleFound = true;
//			}
//		}
//
//		if (vehicleFound) {
//			System.out.print("\nName (old -> " + eVehicle.name + "): ");
//			eVehicle.name = scan.next();
//			System.out.print("\nCc (old -> " + eVehicle.cc.value + "): ");
//			eVehicle.cc.value = scan.nextInt();
//			System.out.print("\nStrength (old -> " + eVehicle.strength.value + "): ");
//			eVehicle.strength.value = scan.nextInt();
//			System.out.print("\nMaximum speed (old -> " + eVehicle.maxSpeed.value + "): ");
//			eVehicle.maxSpeed.value = scan.nextInt();
//			System.out.print("\nZero to hundred (old -> " + eVehicle.zeroToHundred.value + "): ");
//			eVehicle.zeroToHundred.value = scan.nextInt();
//			System.out.print("\nSize (old -> " + eVehicle.size.value + "): ");
//			eVehicle.size.value = scan.nextInt();
//			System.out.print("\nWeight (old -> " + eVehicle.weight.value + "): ");
//			eVehicle.weight.value = scan.nextInt();
//		} else {
//			System.err.println("No vehicle found, returning to main menu...\n\n\n");
//		}
	}

	public static void detailVehicle() {
		System.out.println("Insert the vehicle id: ");
		int option = scan.nextInt();
		boolean vehicleFound = false;

		for (Vehicle v : vehicles) {
			if (v.getId() == option) {
				System.out.print("\nName: " + v.getName());
				
				for (Attribute a : v.getAttributes()) {
					System.out.println(a.getName() + " - " + a.getValue() + " - " + a.getUm());
				}
				
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
		Integer id = scan.nextInt();
		Boolean vehicleFound = false;
		
		for (Vehicle v : vehicles) {
			if (v.getId() == id) {
				vehicles.remove(v);
				System.out.println("Vehicle deleted: " + v.getId() + " - " + v.getName());
				vehicleFound = TRUE;
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
		populateVehicles();
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

	private static void populateVehicles() {
		Vehicle v1 = new Vehicle();
		v1.setName("Fox Sportline");
		v1.init(186, 1599, 18, 101, 3804, 1040);
		addVehicle(v1);
		
		Vehicle v2 = new Vehicle("Golf GTI");
		v2.setName("Golf GTI");
		v2.init(227, 1781, 7, 180, 4147, 1251);
		addVehicle(v2);

		Vehicle v3 = new Vehicle();
		v3.setName("Gol Power");
		v3.init(189, 1781, 10, 103, 3931, 988);
		addVehicle(v3);

		Vehicle v4 = new Vehicle();
		v4.setName("GX3");
		v4.init(230, 1600, 5, 125, 3754, 570);
		addVehicle(v4);

		Vehicle v5 = new Vehicle();
		v5.setName("Iroc");
		v5.init(242, 1390, 7, 210, 4240, 1360);
		addVehicle(v5);

		Vehicle v6 = new Vehicle();
		v6.setName("Jetta");
		v6.init(208, 2480, 9, 150, 4554, 1462);
		addVehicle(v6);

		Vehicle v7 = new Vehicle();
		v7.setName("Kombi");
		v7.init(130, 1390, 16, 57, 4505, 1297);
		addVehicle(v7);

		Vehicle v8 = new Vehicle();
		v8.setName("Nardo");
		v8.init(349, 5998, 3, 600, 4550, 1200);
		addVehicle(v8);
	}
}