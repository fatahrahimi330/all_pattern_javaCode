
import java.util.ArrayList;
import java.util.List;

// Define a class 'Vehicle' which implements the Cloneable interface
class Vehicle implements Cloneable {
    private List<String> vehicleList; // List to hold vehicle names

    public Vehicle() {
        this.vehicleList = new ArrayList<String>(); // Initialize the list
    }

    public Vehicle(List<String> list) {
        this.vehicleList = list; // Initialize the list with provided data
    }

    public void insertData() {
        vehicleList.add("Honda amaze");
        vehicleList.add("Audi A4");
        vehicleList.add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    public List<String> getVehicleList() {
        return this.vehicleList; // Return the list of vehicle names
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> tempList = new ArrayList<String>();

        for (String s : this.getVehicleList()) {
            tempList.add(s); // Create a new list with the same elements
        }

        return new Vehicle(tempList); // Return a new Vehicle object with the copied list
    }
}

public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vehicle a = new Vehicle(); // Create a new Vehicle object
        a.insertData(); // Insert some vehicle names into the list

        Vehicle b = (Vehicle) a.clone(); // Create a clone of the Vehicle object 'a'
        List<String> list = b.getVehicleList(); // Get the list from the clone

        list.add("Honda new Amaze"); // Add a new vehicle name to the list of the clone

        System.out.println(a.getVehicleList()); // Print the original list
        System.out.println(list); // Print the modified list of the clone

        b.getVehicleList().remove("Audi A4"); // Remove a vehicle from the clone's list
        System.out.println(list); // Print the modified list of the clone
        System.out.println(a.getVehicleList()); // Print the original list
    }

}
