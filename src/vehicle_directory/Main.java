package vehicle_directory;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Variables For User Inputs
		String make;
		String model;
		String color;
		int year;
		int mileage;

		// Boolean For Loop That Runs The Program Until User Wishes To Stop
		boolean runProgram = true;
		Scanner scnr = new Scanner(System.in);

		System.out.println("Welcome to the vehicle directory!");
		System.out.println("Select an option by typing the command associated with that action");
		System.out.println("OPTIONS: \n" + "Add New Vehicle: add \n" + "List Registered Vehicles: list \n"
				+ "List Vehicles: dir \n" + "Update Vehicle Attributes: update \n" + "Remove A Vehicle: remove");
		System.out.println("To Close The Program Enter X");

		while (runProgram == true) {
			System.out.println("Command: ");
			String userInput = scnr.nextLine().toLowerCase();
			switch (userInput) {
			case "add":
				try {
					System.out.println("Enter The Following Information:");
					System.out.print("Make: ");
					make = scnr.nextLine();
					System.out.print("Model: ");
					model = scnr.nextLine();
					System.out.print("Color: ");
					color = scnr.nextLine();
					System.out.print("Year: ");
					year = scnr.nextInt();
					System.out.print("Mileage: ");
					mileage = scnr.nextInt();
					scnr.nextLine(); // Put In To Clear scnr So It Doesn't Interfere On Next Loop

					AutomobileInventory.addVehicle(make, model, color, year, mileage);
				} catch (Exception e) {
					System.out.println("There Was A Problem Adding Your Vehicle. Error: " + e);
					scnr.nextLine();
				}
				break;
			case "list":
				try {
					System.out.println("Please Enter The Car's Number");
					System.out.println("To See The Cars Listed Number Use Command dir");
					int userNum = scnr.nextInt();
					AutomobileInventory.listVehicleByNumber(userNum);
				} catch (Exception e) {
					System.out.println("There Was A Problem Listing Your Vehicle. Error: " + e);
				}
				break;
			case "dir":
				AutomobileInventory.listVehicles();
				break;
			case "update":
				try {
					System.out.println("Please Enter The Car's Number");
					System.out.println("To See The Cars Listed Number Use Command dir");
					int userNum2 = scnr.nextInt();
					System.out.println("Please Select Which Attribute Should Be Updated.");
					System.out.println("OPTIONS: make, model, color, year, mileage");
					String userInput3 = scnr.next();
					String userInput2 = null;
					int userNum3 = 0;
					System.out.println("Please Enter The Update You Wish To Make.");
					if (userInput.equals("year") || userInput.equals("mileage")) {
						userNum3 = scnr.nextInt();
						AutomobileInventory.updateVehicle(userNum2, userInput2, userNum3, userInput3);
					} else {
						userInput2 = scnr.next();
						AutomobileInventory.updateVehicle(userNum2, userInput2, userNum3, userInput3);
					}
					scnr.nextLine();
				} catch (Exception e) {
					System.out.println("There Was A Problem Updating Your Vehicle. Error: " + e);
				}
				break;
			case "remove":
				try {
					System.out.println("Please Enter The Car's Number");
					System.out.println("To See The Cars Listed Number Use Command dir");
					int userNum4 = scnr.nextInt();
					AutomobileInventory.removeVehicle(userNum4);
				} catch (Exception e) {
					System.out.println("There Was A Problem Removing Your Vehicle. Error: " + e);
				}
				break;
			case "x":
				try {
					System.out.println("Would You Like To Write Current Directory To File Y/N?");
					String saveFile = scnr.nextLine().toLowerCase();
					if (saveFile.equals("y")) {
						AutomobileInventory.directoryToFile();
						scnr.close();
						runProgram = false;
					} else if (saveFile.equals("n")) {
						scnr.close();
						runProgram = false;
					} else {
						System.out.println("Not A Valid Option.");
					}
				} catch (Exception e) {
					System.out.println("There Was A Problem Closing The Program. Error: " + e);
				}
				break;
			default:
				System.out.println("Not A Valid Option Please Try Again");
				break;
			}
		}
	}

}
