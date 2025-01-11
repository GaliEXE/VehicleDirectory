package vehicle_directory;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

class Car {
	// Initiating Private Variables
	private String make;
	private String model;
	private String color;
	private int year;
	private int mileage;

	// Default Constructor
	public Car() {
		this.make = "N/A";
		this.model = "N/A";
		this.color = "N/A";
		this.year = 0;
		this.mileage = 0;
	}

	// Parameterized Constructor
	public Car(String make, String model, String color, int year, int mileage) {
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.mileage = mileage;
	}

	// Method To Convert The Object TO A String
	@Override
	public String toString() {
		return "Make: " + make + ", Model: " + model + ", Color: " + color + ", Year: " + year + ", Mileage: "
				+ mileage;
	}

	// Methods For Getting Individual Attributes Of An Object
	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public int getYear() {
		return year;
	}

	public int getMileage() {
		return mileage;
	}

	// Methods For Updating Specific Attributes Of An Object
	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
}

public class AutomobileInventory {

	// Stores All Car Objects
	static ArrayList<Car> carList = new ArrayList<>();

	// Add Vehicles Method
	public static void addVehicle(String make, String model, String color, int year, int mileage) {
		try {
			carList.add(new Car(make, model, color, year, mileage));
			System.out.println("Vehicle added successfully!");
		} catch (Exception e) {
			System.out.println("Failed To Add Vehicle! Error: " + e);
		}
	}

	// Lists All Vehicles Method
	public static void listVehicles() {
		try {
			if (carList.isEmpty()) {
				System.out.println("There Are Currently No Vehicles To Display!");
				System.out.println("To Add A Car Use The add Command.");
			} else {
				int i = 0;
				for (Car Car : carList) {
					i = i + 1;
					System.out.println("#" + i + " " + Car);
				}
			}	
		} catch (Exception e) {
			System.out.println("Failed To List Vehicles. Error: " + e);
		}
	}

	// Lists A Specific Vehicle Method
	public static void listVehicleByNumber(int userNum) {
		try {
			if (carList.isEmpty()) {
				System.out.println("There Are Currently No Vehicles To Display!");
				System.out.println("To Add A Car Use The add Command.");
			} else {
				System.out.println(carList.get(userNum - 1));
			}	
		} catch (Exception e) {
			System.out.println("Failed To List Vehicle. Error: " + e);
		}
	}

	// Method For Updating Vehicle Attributes
	public static void updateVehicle(int userNum2, String userInput3, int userNum3, String userInput2) {
		try {
			if (carList.isEmpty()) {
				System.out.println("There Are Currently No Vehicles To Update!");
				System.out.println("To Add A Car Use The add Command.");
			} else if (userNum2 <= 0 || userNum2 > carList.size()) {
				System.out.println("Invalid vehicle number.");
			} else {
				Car carToUpdate = carList.get(userNum2 - 1);

				switch (userInput2.toLowerCase()) {
				case "make":
					carToUpdate.setMake(userInput3);
					break;
				case "model":
					carToUpdate.setModel(userInput3);
					break;
				case "color":
					carToUpdate.setColor(userInput3);
					break;
				case "year":
					carToUpdate.setYear(userNum3);
					break;
				case "mileage":
					carToUpdate.setMileage(userNum3);
					break;
				default:
					System.out.println("Not A Valid Attribute!");
					break;
				}
				System.out.println("Vehicle updated successfully!");
			}	
		} catch (Exception e) {
			System.out.println("Failed To Update Vehicle. Error: " + e);
		}
	}

	// Method For Removing A Specific Vehicle
	public static void removeVehicle(int userNum4) {
		try {
			if (carList.isEmpty()) {
				System.out.println("There Are Currently No Vehicles To Remove!");
				System.out.println("To Add A Car Use The add Command.");
			} else {
				carList.remove(userNum4 - 1);
				System.out.println("Vehicle removed successfully!");
			}	
		} catch (Exception e) {
			System.out.println("Failed To Remove Vehicle. Error: " + e);
		}
	}

	// Method For Writing Current Directory To A File
	public static void directoryToFile() {
		try {
			LocalDate fileCreationRaw = LocalDate.now();
			String fileCreation = fileCreationRaw.toString();
			FileWriter write = new FileWriter("inventoryDir" + fileCreation + ".txt");
			for (Car Car : carList) {
				write.write(Car.toString() + "\n");
			}
			System.out.println("Directory Succesfully Wrote To File");
			write.close();
		} catch (IOException e) {
			System.out.println("Failed To Write To File. Error: " + e);
		}
	}

}
