// Abstract class representing a Vehicle
abstract class Vehicle {
	// Abstract method to get the number of wheels
	public abstract int getWheel();

	// Override toString to provide a string representation of the vehicle
	public String toString() {
		return "Wheel: " + this.getWheel();
	}
}

// Concrete class representing a Car
class Car extends Vehicle {
	int wheel; // Number of wheels for the car

	// Constructor to initialize the number of wheels for the car
	Car(int wheel) {
		this.wheel = wheel;
	}

	// Implementation of the abstract method to get the number of wheels
	@Override
	public int getWheel() {
		return this.wheel;
	}
}

// Concrete class representing a Bike
class Bike extends Vehicle {
	int wheel; // Number of wheels for the bike

	// Constructor to initialize the number of wheels for the bike
	Bike(int wheel) {
		this.wheel = wheel;
	}

	// Implementation of the abstract method to get the number of wheels
	@Override
	public int getWheel() {
		return this.wheel;
	}
}

// Factory class responsible for creating instances of vehicles
class VehicleFactory {
	// Method to create an instance of a vehicle based on type and number of wheels
	public static Vehicle getInstance(String type, int wheel) {
		if (type.equals("car")) // Use .equals() to compare strings
		{
			return new Car(wheel); // Create and return a Car
		} else if (type.equals("bike")) {
			return new Bike(wheel); // Create and return a Bike
		}
		return null; // Return null if the type is not recognized
	}
}

// Main class demonstrating the Factory Pattern
public class FactoryPattern {
	public static void main(String[] args) {
		// Create a car with 4 wheels
		Vehicle car = VehicleFactory.getInstance("car", 4);
		System.out.println(car); // Output: Wheel: 4

		// Create a bike with 2 wheels
		Vehicle bike = VehicleFactory.getInstance("bike", 2);
		System.out.println(bike); // Output: Wheel: 2
	}
}
