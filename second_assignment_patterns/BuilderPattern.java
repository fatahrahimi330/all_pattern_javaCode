// Define a class representing a Vehicle
class Vehicle {
  private String engine; // Engine of the vehicle
  private int wheel; // Number of wheels
  private int airbags; // Number of airbags

  // Getter for the engine
  public String getEngine() {
    return this.engine;
  }

  // Getter for the wheel count
  public int getWheel() {
    return this.wheel;
  }

  // Getter for the number of airbags
  public int getAirbags() {
    return this.airbags;
  }

  // Private constructor that takes a VehicleBuilder
  private Vehicle(VehicleBuilder builder) {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }

  // Define a static inner class for building a Vehicle
  public static class VehicleBuilder {
    private String engine; // Engine of the vehicle
    private int wheel; // Number of wheels
    private int airbags; // Number of airbags

    // Constructor requires mandatory attributes
    public VehicleBuilder(String engine, int wheel) {
      this.engine = engine;
      this.wheel = wheel;
    }

    // Method to set the optional attribute airbags
    public VehicleBuilder setAirbags(int airbags) {
      this.airbags = airbags;
      return this;
    }

    // Method to build the Vehicle object
    public Vehicle build() {
      return new Vehicle(this);
    }
  }
}

// Main class demonstrating the Builder Pattern
public class BuilderPattern {
  public static void main(String[] args) {
    // Create a car using the VehicleBuilder with mandatory and optional attributes
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();

    // Create a bike using the VehicleBuilder with only mandatory attributes
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

    // Print information about the car
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.getAirbags());

    // Print information about the bike
    System.out.println(bike.getEngine());
    System.out.println(bike.getWheel());
    System.out.println(bike.getAirbags());
  }
}
