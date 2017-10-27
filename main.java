// import java.util.Scanner;
// import java.util.ArrayList;
import java.util.*;

public class main {
	public static Scanner scan = new Scanner(System.in);

	public static int idVehicle = 0;
	public static int idCc = 0;
	public static int idZeroToHundred = 0;

	// INCREMENTA id AUTOMATICAMENTE
	public static int getId(String classType){
		switch(classType){
			case "vehicle":
				return ++idVehicle;
			
			case "cc":
				return ++idCc;

			case "zeroToHundred":
				return ++idZeroToHundred;
			
			default:
				System.err.println("Failed to switch in getId() method!");
				return 0;
		}
	}

	public static class Cc {
		private int id = getId("cc");	
		private int value;
		private String um = "CV";
	}
	
	public static class ZeroToHundred {
		private int id = getId("zeroToHundred");	
		private int value;
		private String um = "s";
	}

	public static class Vehicle {
		private final int id = getId("vehicle");
		private String name = "";
		private Cc cc = new Cc();
		private int strength = 0;
		private int maxSpeed = 0;
		private Double engine = 0.0;
		private ZeroToHundred zeroToHundred = new ZeroToHundred();
	}

		public static List<Vehicle> vehicles = new ArrayList<Vehicle>();
	// public static class Vehicles {
	// 	public static List<Vehicle> vehicles = new ArrayList<Vehicle>();

	// 	public static void add(Vehicle vehicle){
	// 		vehicles.add(vehicle);
	// 	}
	// }

	public static void createVehicle(){
		Vehicle vehicle = new Vehicle();

		System.out.println("\nInsert the vehicle name: ");
		scan.nextLine();
		vehicle.name = scan.nextLine();
		vehicle.cc.id = getId("cc");
		System.out.println("\nInsert the vehicle cc: ");
		vehicle.cc.value = scan.nextInt();
		System.out.println("\nInsert the vehicle strength: ");
		vehicle.strength = scan.nextInt();
		System.out.println("\nInsert the vehicle maximum speed: ");
		vehicle.maxSpeed = scan.nextInt();
		vehicle.engine = 1.6;
		System.out.println("\nInsert the vehicle zero to hundred: ");
		vehicle.zeroToHundred.value = scan.nextInt();

		vehicles.add(vehicle);
	}

	public static void showVehicles(){
		for(Vehicle v : vehicles){
			System.out.println(v.id + " - " + v.name);
		}
	}

	public static Vehicle draw(Vehicle v1, Vehicle v2){
		Vehicle winner;
		Vehicle loser;

		winner = v1;
		loser = v2;

		System.out.println("The winner is: " + winner.id + " - " + winner.name);
		System.out.println("The loser is: " + loser.id + " - " + loser.name);

		return winner;
	}

	public static void deleteVehicle(){
		System.out.println("\nInsert de id of the vehicle to be deleted: ");
		int id = scan.nextInt();

		System.out.println("Vehicles length: " + vehicles.size());
		for(Vehicle v : vehicles){
			if(v.id == id){
				vehicles.remove(v);		
				break;
			}
		}
		System.out.println("Vehicles length: " + vehicles.size());

	}

	public static void shutdown(){
		System.out.print("\nAre you sure? Type 1 to shutdown or 0 to main menu: ");
		int option = scan.nextInt();

		if(option == 1){
			System.out.println("\nShutting system down...\n");
			System.exit(0);
		}else if(option == 0){
			System.out.println("\nReturning to main menu...\n");
		}else{
			System.out.println("\nInvalid entry! Returning to main menu...\n");
		}
	}

	public static int menu(){
		System.out.println("###########################");
		System.out.println("# ----------------------- #");
		System.out.println("#   WELCOME TO THE GAME   #");
		System.out.println("# ----------------------- #");
		System.out.println("#                         #");
		System.out.println("# 1 - Create a vehicle    #");
		System.out.println("# 2 - Show your vehicles  #");
		System.out.println("# 3 - Battle a rival      #");
		System.out.println("# 4 - Delete a vehicle    #");
		System.out.println("# 0 - Shutdown            #");
		System.out.println("#                         #");
		System.out.println("###########################");
		System.out.print("Enter a number: ");

		int option = scan.nextInt();

		return option;
	}

	public static void main(String[] args){
		System.out.println("System starting...\n\n");

		Vehicle gallardo = new Vehicle();
		gallardo.name = "Lamborghini Gallardo";
		vehicles.add(gallardo);


		Vehicle mustang = new Vehicle();
		mustang.name = "Ford Mustang GT";
		vehicles.add(mustang);

		while(true){
			int userEntry = menu();

			switch(userEntry){
				case 1:
					createVehicle();
					break;

				case 2:
					showVehicles();
					break;

				case 3:
					draw(gallardo, mustang);

				case 4:
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