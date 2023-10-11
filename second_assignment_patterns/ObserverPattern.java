
import java.util.ArrayList;
import java.util.List;

// Define the subject interface
interface Subject {
    void register(Observer obj); // Method to register an observer

    void unregister(Observer obj); // Method to unregister an observer

    void notifyObservers(); // Method to notify all observers
}

// Concrete subject class (DeliveryData) implementing the Subject interface
class DeliveryData implements Subject {
    private List<Observer> observers; // List to hold registered observers
    private String location; // Current location data

    public DeliveryData() {
        this.observers = new ArrayList<>(); // Initialize the list of observers
    }

    @Override
    public void register(Observer obj) {
        observers.add(obj); // Add an observer to the list
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj); // Remove an observer from the list
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update(location); // Notify each observer with the current location
        }
    }

    // Method to simulate a change in location
    public void locationChanged() {
        this.location = getLocation(); // Get the new location
        notifyObservers(); // Notify observers about the location change
    }

    // Simulated method to get the current location
    public String getLocation() {
        return "YPlace";
    }
}

// Define the observer interface
interface Observer {
    public void update(String location); // Method to update the observer with new information
}

// Concrete observer classes implementing the Observer interface
class Seller implements Observer {
    private String location; // Location information of the Seller

    @Override
    public void update(String location) {
        this.location = location; // Update the location
        showLocation(); // Display the updated location
    }

    // Method to display the current location of the Seller
    public void showLocation() {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

class User implements Observer {
    private String location; // Location information of the User

    @Override
    public void update(String location) {
        this.location = location; // Update the location
        showLocation(); // Display the updated location
    }

    // Method to display the current location of the User
    public void showLocation() {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

class DeliveryWarehouseCenter implements Observer {
    private String location; // Location information of the Warehouse Center

    @Override
    public void update(String location) {
        this.location = location; // Update the location
        showLocation(); // Display the updated location
    }

    // Method to display the current location of the Warehouse Center
    public void showLocation() {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

// Main class demonstrating the Observer Pattern
public class ObserverPattern {
    public static void main(String[] args) {
        DeliveryData topic = new DeliveryData(); // Create a subject (DeliveryData)

        Observer obj1 = new Seller(); // Create a Seller observer
        Observer obj2 = new User(); // Create a User observer
        Observer obj3 = new DeliveryWarehouseCenter(); // Create a Warehouse Center observer

        topic.register(obj1); // Register the Seller observer with the subject
        topic.register(obj2); // Register the User observer with the subject
        topic.register(obj3); // Register the Warehouse Center observer with the subject

        topic.locationChanged(); // Simulate a location change and notify all observers

        topic.unregister(obj3); // Unregister the Warehouse Center observer

        System.out.println();
        topic.locationChanged(); // Simulate another location change and notify remaining observers
    }
}
