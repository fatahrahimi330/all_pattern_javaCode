// Define an interface for executing database queries
interface DatabaseExecuter {
    public void executeDatabase(String query) throws Exception;
}

// Implementation of the DatabaseExecuter interface
class DatabaseExecuterImpl implements DatabaseExecuter {
    @Override
    public void executeDatabase(String query) throws Exception {
        System.out.println("Going to execute Query: " + query);
    }
}

// Proxy class that acts as a gatekeeper to the real DatabaseExecuter
class DatabaseExecuterProxy implements DatabaseExecuter {
    boolean ifAdmin; // Flag to determine if the user is an admin or not
    DatabaseExecuterImpl dbExecuter; // Reference to the real DatabaseExecuter implementation

    // Constructor that takes username and password
    public DatabaseExecuterProxy(String name, String passwd) {
        if (name.equals("Admin") && passwd.equals("Admin@123")) {
            ifAdmin = true; // If username and password match, the user is an admin
        }
        dbExecuter = new DatabaseExecuterImpl(); // Initialize the real DatabaseExecuter
    }

    @Override
    public void executeDatabase(String query) throws Exception {
        if (ifAdmin) {
            dbExecuter.executeDatabase(query); // If the user is an admin, execute the query directly
        } else {
            if (query.equals("DELETE")) {
                throw new Exception("DELETE not allowed for non-admin user"); // Non-admin users are not allowed to
                                                                              // execute DELETE queries
            } else {
                dbExecuter.executeDatabase(query); // Execute other queries for non-admin users
            }
        }
    }
}

public class ProxyPattern {
    public static void main(String[] args) throws Exception {
        // Create a non-admin DatabaseExecuter using the proxy
        DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuter.executeDatabase("DELEE"); // Try to execute a query (misspelled DELETE)

        // Create another non-admin DatabaseExecuter using the proxy
        DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuterDELETE.executeDatabase("DELETE"); // Try to execute a DELETE query

        // Create an admin DatabaseExecuter using the proxy
        DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
        adminExecuter.executeDatabase("DELETE"); // Execute a DELETE query (allowed for admin)
    }
}
