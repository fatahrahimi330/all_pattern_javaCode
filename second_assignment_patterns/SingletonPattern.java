// Singleton with Eager Initialization
class SingletonEager {
  // Static variable that holds the instance of the class
  private static SingletonEager instance = new SingletonEager();

  // Private constructor prevents instantiation from other classes
  private SingletonEager() {
    // Private constructor to prevent external instantiation
  }

  // Static method to provide the instance of the class
  public static SingletonEager getInstance() {
    return instance;
  }
}

// Singleton with Lazy Initialization (not thread-safe)
class Singleton {
  private static Singleton instance; // Static variable to hold the instance of the class

  // Private constructor prevents instantiation from other classes
  private Singleton() {
    // Private constructor to prevent external instantiation
  }

  // Static method to provide the instance of the class
  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton(); // Create a new instance if it doesn't exist
    }
    return instance;
  }
}

// Singleton with Lazy Initialization and Synchronized Method (thread-safe but
// not efficient)
class SingletonSynchronizedMethod {
  private static SingletonSynchronizedMethod instance;

  private SingletonSynchronizedMethod() {
    // Private constructor to prevent external instantiation
  }

  // Static synchronized method to provide the instance of the class
  public static synchronized SingletonSynchronizedMethod getInstance() {
    if (instance == null) {
      instance = new SingletonSynchronizedMethod();
    }
    return instance;
  }
}

// Singleton with Double-Checked Locking (thread-safe and efficient)
class SingletonSynchronized {
  private static SingletonSynchronized instance;

  private SingletonSynchronized() {
    // Private constructor to prevent external instantiation
  }

  // Static method to provide the instance of the class
  public static SingletonSynchronized getInstance() {
    if (instance == null) {
      synchronized (SingletonSynchronized.class) {
        if (instance == null) {
          instance = new SingletonSynchronized(); // Create a new instance if it doesn't exist
        }
      }
    }
    return instance;
  }
}

public class SingletonPattern {
  public static void main(String[] args) {
    SingletonSynchronized instance = SingletonSynchronized.getInstance(); // Get the singleton instance
    System.out.println(instance); // Print the instance

    SingletonSynchronized instance1 = SingletonSynchronized.getInstance(); // Get the singleton instance again
    System.out.println(instance1); // Print the instance (should be the same as the first one)
  }
}
