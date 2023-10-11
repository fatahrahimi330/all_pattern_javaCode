// Define an interface for common web driver operations
interface WebDriver {
    // Method to get an element
    public void getElement();

    // Method to select an element
    public void selectElement();
}

// Concrete class implementing WebDriver for Chrome
class ChromeDriver implements WebDriver {
    @Override
    public void getElement() {
        System.out.println("Get element from ChromeDriver");
    }

    @Override
    public void selectElement() {
        System.out.println("Select element from ChromeDriver");
    }
}

// Another concrete class (not implementing WebDriver interface)
class IEDriver {
    // Method to find an element
    public void findElement() {
        System.out.println("Find element from IEDriver");
    }

    // Method to click an element
    public void clickElement() {
        System.out.println("Click element from IEDriver");
    }
}

// Adapter class implementing WebDriver by utilizing IEDriver
class WebDriverAdapter implements WebDriver {
    IEDriver ieDriver;

    // Constructor takes an IEDriver object
    public WebDriverAdapter(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() {
        // Adapt the method to IEDriver's findElement
        ieDriver.findElement();
    }

    @Override
    public void selectElement() {
        // Adapt the method to IEDriver's clickElement
        ieDriver.clickElement();
    }
}

// Main class to demonstrate the Adapter pattern
public class AdapterPattern {
    public static void main(String[] args) {
        // Create a ChromeDriver object
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.getElement(); // Output: "Get element from ChromeDriver"
        chromeDriver.selectElement(); // Output: "Select element from ChromeDriver"

        // Create an IEDriver object
        IEDriver ieDriver = new IEDriver();
        ieDriver.findElement(); // Output: "Find element from IEDriver"
        ieDriver.clickElement(); // Output: "Click element from IEDriver"

        // Use the Adapter to treat IEDriver as a WebDriver
        WebDriver webDriverAdapter = new WebDriverAdapter(ieDriver);
        webDriverAdapter.getElement(); // Output: "Find element from IEDriver"
        webDriverAdapter.selectElement(); // Output: "Click element from IEDriver"
    }
}
