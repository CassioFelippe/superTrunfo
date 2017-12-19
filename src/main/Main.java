package main;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

// import java.util.Scanner;
// import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


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
	public static Computer player2 = new Computer("Computer");
	
	public static void addVehicle(Vehicle v) {
		vehicles.add(v);
	}
	
	public static void removeVehicle(Vehicle v) {
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
		System.err.println("Unavailabe option! Returning to main menu...");
	}

	public static void showVehicles() {
		System.out.println("Insert 1 to " + player1.getName() + " vehicles");
		System.out.println("Insert 2 to " + player2.getName() + " vehicles");
		
		Integer option = scan.nextInt();
		
		if(option == 1) {
			System.out.println(player1.getName() + " vehicles:");
			for (Vehicle v : player1.getVehicles()) {
				System.out.println(v.getId() + " - " + v.getName());
			}
		}else if(option == 2) {
			System.out.println(player2.getName() + " vehicles:");
			for (Vehicle v : player2.getVehicles()) {
				System.out.println(v.getId() + " - " + v.getName());
			}
		}else {
			System.err.println("Invalid entry! Returning to main menu...");
		}
	}

	public static void battle() {
		if(player1.getVehicles().size() > 0 && player2.getVehicles().size() > 0) {
			Vehicle v1 = player1.getVehicles().iterator().next();
			Vehicle v2 = player2.getVehicles().iterator().next();
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("###########################");
			System.out.println("# ----------------------- #  --- " + player1.getName() + " ---");
			System.out.println("#          BATTLE         #  Id: " + v1.getId());
			System.out.println("# ----------------------- #  Name: " + v1.getName());
			System.out.println("#     Choose a skill:     #");
			System.out.println("#                         #  --- " + player2.getName() + " ---");
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

			if(option == 0) {
				System.out.println("Returning to main menu...");
				return;
			}
			
			for(Attribute a : v1.getAttributes()) {
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
						foundAttribute = TRUE;
						final Attribute v1Attribute = v1.getAttributes().get(a.getId()-1);
						final Attribute v2Attribute = v2.getAttributes().get(a.getId()-1);
						System.out.println(v1.getName() + " " + v1Attribute.getName() + " -> " + v1Attribute.getValue());
						System.out.println(v2.getName() + " " + v2Attribute.getName() + " -> " + v2Attribute.getValue());
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
		}else {
			System.err.println("There are no vehicles enough to the battle! Returning to main menu...");
		}
		System.out.println(player1.getName() + " score: " + player1.getScore());
		System.out.println(player2.getName() + " score: " + player2.getScore());
		
		if(player1.getScore() > player2.getScore()) {
			System.out.println("CURRENT WINNER IS: " + player1.getName() + "!");
		}else if(player1.getScore() < player2.getScore()) {
			System.out.println("CURRENT WINNER IS: " + player2.getName() + "!");
		}else {
			System.out.println("GAME IS TIED!");
		}
	}

	public static void editVehicle() {
		System.out.println("Insert 1 to " + player1.getName() + " vehicles");
		System.out.println("Insert 2 to " + player2.getName() + " vehicles");
		Integer option = scan.nextInt();
		Vehicle eVehicle = new Vehicle();
		Boolean vehicleFound = FALSE;
		
		if(option == 1) {
			for(Vehicle v : player1.getVehicles()) {
				System.out.println(v.getId() + " - " + v.getName());
			}
			System.out.println("");
			System.out.println("Insert the vehicle id: ");
			option = scan.nextInt();
			for (Vehicle v : player1.getVehicles()) {
				if (v.getId() == option) {
					eVehicle = v;
					vehicleFound = TRUE;
					break;
				}
			}
		}else if(option == 2) {
			for(Vehicle v : player2.getVehicles()) {
				System.out.println(v.getId() + " - " + v.getName());
			}
			System.out.println("");
			System.out.println("Insert the vehicle id: ");
			option = scan.nextInt();
			for (Vehicle v : player2.getVehicles()) {
				if (v.getId() == option) {
					eVehicle = v;
					vehicleFound = TRUE;
					break;
				}
			}
		}else {
			System.err.println("Invalid entry! Returning to main menu...");
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
		System.out.println("Insert 1 to " + player1.getName() + " vehicles");
		System.out.println("Insert 2 to " + player2.getName() + " vehicles");
		Integer option = scan.nextInt();
		Vehicle dVehicle = new Vehicle();
		Boolean vehicleFound = FALSE;
		
		if(option == 1) {
			for(Vehicle v : player1.getVehicles()) {
				System.out.println(v.getId() + " - " + v.getName());
			}
			System.out.println("");
			System.out.println("Insert the vehicle id: ");
			option = scan.nextInt();
			for (Vehicle v : player1.getVehicles()) {
				if (v.getId() == option) {
					dVehicle = v;
					vehicleFound = TRUE;
					break;
				}
			}
		}else if(option == 2) {
			for(Vehicle v : player2.getVehicles()) {
				System.out.println(v.getId() + " - " + v.getName());
			}
			System.out.println("");
			System.out.println("Insert the vehicle id: ");
			option = scan.nextInt();
			for (Vehicle v : player2.getVehicles()) {
				if (v.getId() == option) {
					dVehicle = v;
					vehicleFound = TRUE;
					break;
				}
			}
		}else {
			System.err.println("Invalid entry! Returning to main menu...");
		}

		if (dVehicle.getId() == option) {
			System.out.print("\n\nName: " + dVehicle.getName());
			for (Attribute a : dVehicle.getAttributes()) {
				System.out.println(a.getName() + " - " + a.getValue() + " " + a.getUm());
			}
			
			vehicleFound = true;
		}
		
		if (!vehicleFound) {
			System.err.println("No vehicle found, returning to main menu...\n\n\n");
		}
	}

	public static void deleteVehicle() {
		System.out.println("Insert 1 to " + player1.getName() + " vehicles");
		System.out.println("Insert 2 to " + player2.getName() + " vehicles");
		Integer option = scan.nextInt();
		Boolean vehicleFound = FALSE;
		
		if(option == 1) {
			for(Vehicle v : player1.getVehicles()) {
				System.out.println(v.getId() + " - " + v.getName());
			}
			System.out.println("");
			System.out.println("Insert the vehicle id: ");
			option = scan.nextInt();
			for (Vehicle v : player1.getVehicles()) {
				if (v.getId() == option) {
					vehicleFound = TRUE;
					player1.removeVehicle(v);
					System.out.println("Vehicle deleted: " + v.getId() + " - " + v.getName());
					break;
				}
			}
		}else if(option == 2) {
			for(Vehicle v : player2.getVehicles()) {
				System.out.println(v.getId() + " - " + v.getName());
			}
			System.out.println("");
			System.out.println("Insert the vehicle id: ");
			option = scan.nextInt();
			for (Vehicle v : player2.getVehicles()) {
				if (v.getId() == option) {
					vehicleFound = TRUE;
					player2.removeVehicle(v);
					System.out.println("Vehicle deleted: " + v.getId() + " - " + v.getName());
					break;
				}
			}
		}else {
			System.err.println("Invalid entry! Returning to main menu...");
		}

		if(!vehicleFound) {
			System.err.println("No vehicle found, returning to main menu...\n\n\n");
		}
	}
	
	public static void showAllAttributes() {
		for(Vehicle v : player1.getVehicles()) {
			System.out.println(v.getName() + ":");
			for (Attribute a : v.getAttributes()) {
				System.out.println(a.getId() + " - " + a.getName() + " - " + a.getValue() + " - " + a.getUm());
			}
			System.out.println("");
		}
		
		for(Vehicle v : player2.getVehicles()) {
			System.out.println(v.getName() + ":");
			for (Attribute a : v.getAttributes()) {
				System.out.println(a.getId() + " - " + a.getName() + " - " + a.getValue() + " - " + a.getUm());
			}
			System.out.println("");
		}
	}
	
	public static void showScore() {
		System.out.println(player1.getName() + " score: " + player1.getScore());
		System.out.println(player2.getName() + " score: " + player2.getScore());
		if(player1.getScore() > player2.getScore()) {
			System.out.println("CURRENT WINNER IS: " + player1.getName() + "!");
		}else if(player1.getScore() < player2.getScore()) {
			System.out.println("CURRENT WINNER IS: " + player2.getName() + "!");
		}else {
			System.out.println("GAME IS TIED!");
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
		System.out.println("# 7 - Show all attributes #");
		System.out.println("# 8 - Show players score  #");
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
				
			case 7:
				showAllAttributes();
				break;
				
			case 8:
				showScore();
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
		Vehicle v1 = new Vehicle("Fox Sportline");
		v1.generateAttributes(186, 1599, 18, 101, 3804, 1040);
		addVehicle(v1);
		
		Vehicle v2 = new Vehicle("Golf GTI");
		v2.generateAttributes(227, 1781, 7, 180, 4147, 1251);
		addVehicle(v2);

		Vehicle v3 = new Vehicle("Gol Power");
		v3.generateAttributes(189, 1781, 10, 103, 3931, 988);
		addVehicle(v3);

		Vehicle v4 = new Vehicle("GX3");
		v4.generateAttributes(230, 1600, 5, 125, 3754, 570);
		addVehicle(v4);

		Vehicle v5 = new Vehicle("Iroc");
		v5.generateAttributes(242, 1390, 7, 210, 4240, 1360);
		addVehicle(v5);

		Vehicle v6 = new Vehicle("Jetta");
		v6.generateAttributes(208, 2480, 9, 150, 4554, 1462);
		addVehicle(v6);

		Vehicle v7 = new Vehicle("Kombi");
		v7.generateAttributes(130, 1390, 16, 57, 4505, 1297);
		addVehicle(v7);

		Vehicle v8 = new Vehicle("Nardo");
		v8.generateAttributes(349, 5998, 3, 600, 4550, 1200);
		addVehicle(v8);
		
		randomVehicles();
	}
	
	private static void populatePlayers() {
		System.out.println("Insira o seu nome: ");
		player1.setName(scan.nextLine());
		player2.setName("Computer");
		
		getRandomVehicles();
	}
	
	private static void randomVehicles() {
		Vehicle vehicle = new Vehicle();
		List<Vehicle> randomVehicles = new ArrayList<>();
		Random rnd = ThreadLocalRandom.current();
		
		for(Integer j = 0; j < 8; j++) {
			Integer index = rnd.nextInt(vehicles.size());
			vehicle = vehicles.get(index);
			randomVehicles.add(vehicle);
			vehicles.remove(vehicle);
		}
		
		vehicles = randomVehicles;
	}
	
	private static void getRandomVehicles() {
		Vehicle vehicle = new Vehicle();

		player1.getVehicles().clear();
		player2.getVehicles().clear();
		
		for(Integer j = 0; j < 8; j++) {
			vehicle = vehicles.iterator().next();
			vehicles.remove(vehicle);
			
			if(j < 4) {
				player1.addVehicle(vehicle);
			} else {
				player2.addVehicle(vehicle);
			}
		}
	}
}

//		vehicles.shuffle
//		emilio.wuerges@uffs.edu.br