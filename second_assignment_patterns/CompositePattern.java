
import java.util.ArrayList;
import java.util.List;

// Define an abstract class for Account
abstract class Account {
  public abstract float getBalance(); // Abstract method to get the balance
}

// Concrete class for Deposit Account
class DepositAccount extends Account {
  private String accountNo;
  private float accountBalance;

  // Constructor to initialize account details
  public DepositAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  // Implementation of abstract method to get balance
  public float getBalance() {
    return accountBalance;
  }
}

// Concrete class for Savings Account
class SavingsAccount extends Account {
  private String accountNo;
  private float accountBalance;

  // Constructor to initialize account details
  public SavingsAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  // Implementation of abstract method to get balance
  public float getBalance() {
    return accountBalance;
  }
}

// Composite class for managing multiple accounts
class CompositeAccount extends Account {
  private float totalBalance;
  private List<Account> accountList = new ArrayList<Account>();

  // Implementation of abstract method to get balance
  public float getBalance() {
    totalBalance = 0;
    for (Account acc : accountList) {
      totalBalance = totalBalance + acc.getBalance();
    }
    return totalBalance;
  }

  // Method to add an account to the list
  public void addAccount(Account acc) {
    accountList.add(acc);
  }

  // Method to remove an account from the list
  public void removeAccount(Account acc) {
    accountList.remove(acc);
  }
}

// Main class demonstrating the Composite Pattern
public class CompositePattern {
  public static void main(String[] args) {
    CompositeAccount compositeAccount = new CompositeAccount();

    compositeAccount.addAccount(new DepositAccount("DA001", 100));
    compositeAccount.addAccount(new DepositAccount("DA002", 150));
    compositeAccount.addAccount(new SavingsAccount("SA001", 200));

    float totalBalance = compositeAccount.getBalance();
    System.out.println("Total Balance : " + totalBalance);
  }
}
