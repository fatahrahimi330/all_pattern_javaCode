// Define an interface for different types of dresses
interface Dress {
	public void assemble(); // Method to assemble the dress
}

// Concrete class representing a basic dress
class BasicDress implements Dress {
	@Override
	public void assemble() {
		System.out.println("Basic Dress Features");
	}
}

// Abstract class for dress decorators, implementing the Dress interface
class DressDecorator implements Dress {
	protected Dress dress; // Reference to the base dress

	// Constructor to initialize the base dress
	public DressDecorator(Dress c) {
		this.dress = c;
	}

	@Override
	public void assemble() {
		this.dress.assemble(); // Delegate assembly to the base dress
	}
}

// Concrete class representing a casual dress decorator
class CasualDress extends DressDecorator {
	// Constructor to initialize the base dress
	public CasualDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble(); // Call the assembly of the base dress
		System.out.println("Adding Casual Dress Features"); // Add casual dress features
	}
}

class SportyDress extends DressDecorator {
	public SportyDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble(); // Call the assembly of the base dress
		System.out.println("Adding Sporty Dress Features"); // Add sporty dress features
	}
}

class FancyDress extends DressDecorator {
	public FancyDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble(); // Call the assembly of the base dress
		System.out.println("Adding Fancy Dress Features"); // Add fancy dress features
	}
}

public class DecoratorPattern {
	public static void main(String[] args) {
		Dress sportyDress = new SportyDress(new BasicDress()); // Create a sporty dress on top of a basic dress
		sportyDress.assemble(); // Assemble the dress
		System.out.println();

		Dress fancyDress = new FancyDress(new BasicDress()); // Create a fancy dress on top of a basic dress
		fancyDress.assemble(); // Assemble the dress
		System.out.println();

		Dress casualDress = new CasualDress(new BasicDress()); // Create a casual dress on top of a basic dress
		casualDress.assemble(); // Assemble the dress
		System.out.println();

		Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress())); // Create a sporty fancy dress
		sportyFancyDress.assemble(); // Assemble the dress
		System.out.println();

		Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress())); // Create a casual fancy dress
		casualFancyDress.assemble(); // Assemble the dress
	}
}
