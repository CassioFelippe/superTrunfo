// import java.util.Scanner;
// import java.util.ArrayList;
import java.util.*;

public class main {
  public static Scanner scan = new Scanner(System.in);

  public static int idVehicle = 0;
  public static int idCc = 0;
  public static int idZeroToHundred = 0;
  public static int idMaxSpeed = 0;

  // INCREMENTA id AUTOMATICAMENTE
  public static int getId(String classType){
    switch(classType){
      case "vehicle":
        return ++idVehicle;
      
      case "cc":
        return ++idCc;

      case "zeroToHundred":
        return ++idZeroToHundred;

      case "maxSpeed":
        return ++idMaxSpeed;
      
      default:
        System.err.println("Failed to switch in getId() method!");
        return 0;
    }
  }

  public static class Cc {
    private final int id = getId("cc");  
    private int value;
    private final String um = "CV";
  }
  
  public static class ZeroToHundred {
    private final int id = getId("zeroToHundred");  
    private int value;
    private final String um = "s";
  }

  public static class MaxSpeed {
  	private final int id = getId("maxSpeed");
  	private int value;
  	private final String um = "km/h";
  }

  public static class Vehicle {
    private final int id = getId("vehicle");
    private String name = "";
    private Cc cc = new Cc();
    private int strength = 0;
    private MaxSpeed maxSpeed = new MaxSpeed();
    private Double engine = 0.0;
    private ZeroToHundred zeroToHundred = new ZeroToHundred();
  }

    public static List<Vehicle> vehicles = new ArrayList<Vehicle>();
  // public static class Vehicles {
  //   public static List<Vehicle> vehicles = new ArrayList<Vehicle>();

  //   public static void add(Vehicle vehicle){
  //     vehicles.add(vehicle);
  //   }
  // }

  public static void createVehicle(){
    Vehicle vehicle = new Vehicle();

    System.out.println("\nInsert the vehicle name: ");
    scan.nextLine();
    vehicle.name = scan.nextLine();
    System.out.println("\nInsert the vehicle cc: ");
    vehicle.cc.value = scan.nextInt();
    System.out.println("\nInsert the vehicle strength: ");
    vehicle.strength = scan.nextInt();
    System.out.println("\nInsert the vehicle maximum speed: ");
    vehicle.maxSpeed.value = scan.nextInt();
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

  public static void battle(Vehicle v1, Vehicle v2){
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
    System.out.println("# 4 - Engine              #");
    System.out.println("# 5 - Zero to hundred     #");
    System.out.println("# 0 - Cancel              #");
    System.out.println("#                         #");
    System.out.println("###########################");

    int option = scan.nextInt();

    if(option == 1){
    	System.out.println(v1.name + " cc: " + v1.cc.value + v1.cc.um);
    	System.out.println(v2.name + " cc: " + v2.cc.value + v2.cc.um);
    	if(v1.cc.value > v2.cc.value){
    		winner = v1;
    		loser = v2;
    	}else if(v1.cc.value == v2.cc.value){
    		option = -2;
    	}else{
    		winner = v2;
    		loser = v1;
    	}
    }else if(option == 2){
    	System.out.println(v1.name + " strength: " + v1.strength);
    	System.out.println(v2.name + " strength: " + v2.strength);
    	if(v1.strength > v2.strength){
    		winner = v1;
    		loser = v2;
    	}else if(v1.strength == v2.strength){
    		option = -2;
    	}else{
    		winner = v2;
    		loser = v1;
    	}
    }else if(option == 3){
    	System.out.println(v1.name + " maximum speed: " + v1.maxSpeed.value + v1.maxSpeed.um);
    	System.out.println(v2.name + " maximum speed: " + v2.maxSpeed.value + v2.maxSpeed.um);
    	if(v1.maxSpeed.value > v2.maxSpeed.value){
    		winner = v1;
    		loser = v2;
    	}else if(v1.maxSpeed.value == v2.maxSpeed.value){
    		option = -2;
    	}else{
    		winner = v2;
    		loser = v1;
    	}
    }else if(option == 4){
    	System.out.println(v1.name + " engine: " + v1.engine);
    	System.out.println(v2.name + " engine: " + v2.engine);
    	if(v1.engine > v2.engine){
    		winner = v1;
    		loser = v2;
    	}else if(v1.engine == v2.engine){
    		option = -2;
    	}else{
    		winner = v2;
    		loser = v1;
    	}
    }else if(option == 5){
    	System.out.println(v1.name + " zero to hundred: " + v1.zeroToHundred.value + v1.zeroToHundred.um);
    	System.out.println(v2.name + " zero to hundred: " + v2.zeroToHundred.value + v2.zeroToHundred.um);
    	if(v1.engine < v2.engine){
    		winner = v1;
    		loser = v2;
    	}else if(v1.engine == v2.engine){
    		option = -2;
    	}else{
    		winner = v2;
    		loser = v1;
    	}
    }else{
      System.err.println("Invalid entry, returning to main menu...");
      option = -1;
    }
    if(option == -2){
      System.err.println("Draw!");
    }else if(option != -1){
      System.out.println("The winner is: " + winner.name);
      System.out.println("The loser is: " + loser.name);
    }
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
    System.out.println("###########################");    System.out.print("Enter a number: ");

    int option = scan.nextInt();

    return option;
  }

  public static void main(String[] args){
    System.out.println("System starting...\n\n");

    Vehicle gallardo = new Vehicle();
    gallardo.name = "Lamborghini Gallardo";
    gallardo.cc.value = 50;
    gallardo.strength = 700;
    gallardo.maxSpeed.value = 340;
    gallardo.engine = 3.2;
    gallardo.zeroToHundred.value = 5;
    vehicles.add(gallardo);


    Vehicle mustang = new Vehicle();
    mustang.name = "Ford Mustang GT";
    mustang.cc.value = 40;
    mustang.strength = 800;
    mustang.maxSpeed.value = 320;
    mustang.engine = 3.5;
    mustang.zeroToHundred.value = 8;
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
          battle(gallardo, mustang);
          break;

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