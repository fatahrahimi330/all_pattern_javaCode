// Define an abstract class for TV
abstract class TV {
    Remote remote;

    TV(Remote r) {
        this.remote = r;
    }

    abstract void on(); // Abstract method to turn on the TV

    abstract void off(); // Abstract method to turn off the TV
}

// Concrete class for Sony TV
class Sony extends TV {
    Remote remoteType;

    Sony(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    public void off() {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

// Concrete class for Philips TV
class Philips extends TV {
    Remote remoteType;

    Philips(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    public void off() {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

// Interface for remote controls
interface Remote {
    public void on(); // Method to turn on the TV

    public void off(); // Method to turn off the TV
}

// Implementation of an old remote control
class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with old Remote");
    }
}

// Implementation of a new remote control
class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with New Remote");
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        // Create a Sony TV with an old remote
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on(); // Output: "Sony TV ON: ON with Old Remote"
        sonyOldRemote.off(); // Output: "Sony TV OFF: OFF with old Remote"
        System.out.println();

        // Create a Sony TV with a new remote
        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on(); // Output: "Sony TV ON: ON with New Remote"
        sonyNewRemote.off(); // Output: "Sony TV OFF: OFF with New Remote"
        System.out.println();

        // Create a Philips TV with an old remote
        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on(); // Output: "Philips TV ON: ON with Old Remote"
        philipsOldRemote.off(); // Output: "Philips TV OFF: OFF with old Remote"
        System.out.println();

        // Create a Philips TV with a new remote
        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on(); // Output: "Philips TV ON: ON with New Remote"
        philipsNewRemote.off(); // Output: "Philips TV OFF: OFF with New Remote"
    }
}
