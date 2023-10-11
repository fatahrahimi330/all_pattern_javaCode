import java.util.HashMap;
import java.util.Random;

// Define an interface for employees
interface Employee {
  public void assignSkill(String skill); // Method to assign a skill to an employee

  public void task(); // Method to perform a task
}

// Concrete class representing a Developer employee
class Developer implements Employee {

  private final String JOB; // Final job description for Developers
  private String skill; // Skill assigned to the Developer

  // Constructor
  public Developer() {
    JOB = "Fix the issue";
  }

  @Override
  public void assignSkill(String skill) {
    this.skill = skill;
  }

  @Override
  public void task() {
    System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
  }

}

// Concrete class representing a Tester employee
class Tester implements Employee {
  private final String JOB; // Final job description for Testers
  private String skill; // Skill assigned to the Tester

  // Constructor
  public Tester() {
    JOB = "Test the issue";
  }

  @Override
  public void assignSkill(String skill) {
    this.skill = skill;
  }

  @Override
  public void task() {
    System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
  }
}

// Factory class for creating and managing employees
class EmployeeFactory {
  private static HashMap<String, Employee> m = new HashMap<String, Employee>(); // HashMap to store created employees

  // Method to get an employee instance
  public static Employee getEmployee(String type) {
    Employee p = null;
    if (m.get(type) != null) // If the employee type is already created, return it
    {
      p = m.get(type);
    } else // If not, create a new employee of the specified type
    {
      switch (type) {
        case "Developer":
          System.out.println("Developer Created");
          p = new Developer();
          break;
        case "Tester":
          System.out.println("Tester Created");
          p = new Tester();
          break;
        default:
          System.out.println("No Such Employee");
      }

      m.put(type, p); // Store the created employee for future use
    }
    return p;
  }
}

// Main class demonstrating the Flyweight Pattern
public class FlyweightPattern {
  private static String employeeType[] = { "Developer", "Tester" }; // Available employee types
  private static String skills[] = { "Java", "C++", ".Net", "Python" }; // Available skills for employees

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      Employee e = EmployeeFactory.getEmployee(getRandEmployee()); // Get a random employee type
      e.assignSkill(getRandSkill()); // Assign a random skill to the employee
      e.task(); // Perform a task
    }
  }

  public static String getRandEmployee() {
    Random r = new Random();
    int randInt = r.nextInt(employeeType.length);
    return employeeType[randInt]; // Return a random employee type
  }

  public static String getRandSkill() {
    Random r = new Random();
    int randInt = r.nextInt(skills.length);
    return skills[randInt]; // Return a random skill
  }
}
