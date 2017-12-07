package main;

import static java.lang.Boolean.FALSE;
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
	
	public static Integer idPlayer = 0;
	
	// INCREMENTA id AUTOMATICAMENTE
	public static Integer generatePlayerId() {
		return ++idVehicle;
	}

	public static List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public static Player player1 = new Player();
	public static Player player2 = new Player();
	
	public static void addVehicle(Vehicle v) {
		vehicles.add(v);
	}
	
	public static void createVehicle() {
//		Vehicle vehicle = new Vehicle();
//
//		System.out.println("\nInsert the vehicle name: ");
//		vehicle.setName(scan.nextLine());
//		System.out.println("\nInsert the vehicle cc: ");
//
//		vehicles.add(vehicle);
	}

	public static void showVehicles() {
		for (Vehicle v : vehicles) {
			System.out.println(v.getId() + " - " + v.getName());
		}
	}

	public static void battle() {
		System.out.println(">>>>>");
		System.out.println(player1.getName());
		System.out.println(player2.getName());
		
		Vehicle v1 = player1.getVehicles().iterator().next();
		Vehicle v2 = player2.getVehicles().iterator().next();
		for (Attribute x : v1.getAttributes()) {
			System.out.println(x.getId());
		}
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("###########################");
		System.out.println("# ----------------------- #  --- Player 1 ---");
		System.out.println("#          BATTLE         #  Id: " + v1.getId());
		System.out.println("# ----------------------- #  Name: " + v1.getName());
		System.out.println("#     Choose a skill:     #");
		System.out.println("#                         #  --- Player 2 ---");
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

		Boolean foundAttribute = FALSE;
		
		for(Attribute a : v1.getAttributes()) {
			System.out.println(a.getId());
			if(a.getId() == option) {
				foundAttribute = TRUE;
				if(a.getNegative()) {
					final Attribute v1Attribute = v1.getAttributes().get(a.getId());
					final Attribute v2Attribute = v2.getAttributes().get(a.getId());
					if(v1Attribute.getValue() < v2Attribute.getValue()) {
						System.out.println(
							"Winner is " + v1.getName() +
							" -> " + v1Attribute.getValue() +
							" " + v1Attribute.getUm()
						);
						System.out.println(
							"Loser is " + v2.getName() +
							" -> " + v2Attribute.getValue() +
							" " + v2Attribute.getUm()
						);
						
						player1.addScore();
						player1.removeVehicle(v1);
						player2.removeVehicle(v2);
						
					}else if(v1Attribute.getValue() == v2Attribute.getValue()) {
						System.out.println("Draw!");
						System.out.println(a.getName() + " -> " + a.getValue() + " " + a.getUm());
						player1.removeVehicle(v1);
						player2.removeVehicle(v2);
					}else {
						System.out.println(
							"Winner is " + v2.getName() +
							" -> " + v2Attribute.getValue() +
							" " + v2Attribute.getUm()
						);
						System.out.println(
							"Loser is " + v1.getName() +
							" -> " + v1Attribute.getValue() +
							" " + v1Attribute.getUm()
						);
						player2.addScore();
						player1.removeVehicle(v1);
						player2.removeVehicle(v2);
					}
				}else {
					final Attribute v1Attribute = v1.getAttributes().get(a.getId()-1);
					final Attribute v2Attribute = v2.getAttributes().get(a.getId()-1);
					System.out.println("-> " + v2.getAttributes().iterator().next().getId());
					System.out.println("-> " + v2.getAttributes().iterator().next().getName());
					System.out.println("1: " + v1Attribute.getName() + " -> " + v1Attribute.getValue());
					System.out.println("2: " + v2Attribute.getName() + " -> " + v2Attribute.getValue());
					if(v1Attribute.getValue() > v2Attribute.getValue()) {
						System.out.println(
							"Winner is " + v1.getName() +
							" -> " + v1Attribute.getValue() +
							" " + v1Attribute.getUm()
						);
						System.out.println(
							"Loser is " + v2.getName() +
							" -> " + v2Attribute.getValue() +
							" " + v2Attribute.getUm()
						);
						player1.addScore();
						player1.removeVehicle(v1);
						player2.removeVehicle(v2);
					}else if(v1Attribute.getValue() == v2Attribute.getValue()) {
						System.out.println("Draw!");
						System.out.println(a.getName() + " -> " + a.getValue() + " " + a.getUm());
						player1.removeVehicle(v1);
						player2.removeVehicle(v2);
					}else {
						System.out.println(
							"Winner is " + v2.getName() +
							" -> " + v2Attribute.getValue() +
							" " + v2Attribute.getUm()
						);
						System.out.println(
							"Loser is " + v1.getName() +
							" -> " + v1Attribute.getValue() +
							" " + v1Attribute.getUm()
						);
						player2.addScore();
						player1.removeVehicle(v1);
						player2.removeVehicle(v2);
					}
					
				}
			}
		}
		if(!foundAttribute) {
			System.err.println("Invalid entry! Returning to main menu...");
		}
	}

	public static void editVehicle() {
		System.out.println("Insert the vehicle id: ");
		int option = scan.nextInt();
		Vehicle eVehicle = new Vehicle();
		boolean vehicleFound = false;

		for (Vehicle v : vehicles) {
			if (v.getId() == option) {
				eVehicle = v;
				vehicleFound = true;
			}
		}

		if (vehicleFound) {
//			System.out.print("\nName (old -> " + eVehicle.getName() + "): ");
//			eVehicle.setName(scan.nextLine());
			
			for (Attribute a : eVehicle.getAttributes()) {
				System.out.print("\n" + a.getName() + " (old -> " + a.getValue() + "): ");
				a.setValue(scan.nextInt());
			}
		} else {
			System.err.println("No vehicle found, returning to main menu...\n\n\n");
		}
	}

	public static void detailVehicle() {
		System.out.println("Insert the vehicle id: ");
		int option = scan.nextInt();
		boolean vehicleFound = false;

		for (Vehicle v : vehicles) {
			if (v.getId() == option) {
				System.out.print("\n\nName: " + v.getName());
				System.out.println("\n");
				for (Attribute a : v.getAttributes()) {
					System.out.println(a.getName() + " - " + a.getValue() + " " + a.getUm());
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
		populatePlayers();
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
				battle();
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
	
	private static void populatePlayers() {
		Player p1 = new Player();
		Player p2 = new Player();
		
		System.out.println("Insira o seu nome: ");
		p1.setName(scan.nextLine());
		p2.setName("Computer");
		
		p1.setVehicles(getRandomVehicles());
		for(Vehicle v : p1.getVehicles()) {
			vehicles.remove(v);
		}
		p2.setVehicles(getRandomVehicles());
		
		System.out.println("Player 1 vehicles:");
		for(Vehicle v : p1.getVehicles()) {
			System.out.println(v.getId()+" - "+v.getName());
		}
		System.out.println("");
		System.out.println("Player 2 vehicles:");
		for(Vehicle v : p1.getVehicles()) {
			System.out.println(v.getId()+" - "+v.getName());
		}
		
		player1 = p1;
		player2 = p2;
	}
	
	private static List<Vehicle> getRandomVehicles() {
		Vehicle vehicle = new Vehicle();
		List<Vehicle> vehiclesToBeAdded = new ArrayList<Vehicle>();
//		vehicles.shuffle
//		emilio.wuerges@uffs.edu.br
		for(Integer j = 0; j < 4; j++) {
			vehicle = vehicles.stream().findAny().get();
			vehiclesToBeAdded.add(vehicle);
			vehicles.remove(vehicle);
		}
		
		return vehiclesToBeAdded;
	}
}