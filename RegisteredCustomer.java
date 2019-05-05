import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class describes the registered customers of our
 * application, in specific the ones who have successfully
 * registered and are able to login using their credentials
 * @author gkodosis
 * 
 */
public class RegisteredCustomer extends Customer {

	private int count;
	private int regCustomerId;
	private String email;
	private String password;
	static ArrayList<RegisteredCustomer> registeredCustomer = new ArrayList<RegisteredCustomer>();
	
	public RegisteredCustomer(int regCustomerId, String fullname, String phoneNumber,
			String address, String email, String password) {
		
		super(fullname, phoneNumber, address);
		setRegCustomerId(count++);
		this.email = email;
		this.password = password;
		registeredCustomer.add(this);
	}
	
	public void setRegCustomerId(int regCustomerId) {
		this.regCustomerId = regCustomerId;
	}
	
	public int getRegCustomerId() {
		return regCustomerId;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	// register's customer menu
	@Override
	public void getMenu() {
		System.out.println();
		System.out.println("-- Show Previous Orders: Press 1");
		System.out.println("-- Browse Available Shops: Press 2");
		System.out.println("-- Preview Catalogue & Order: Press 3");
		System.out.println();
		System.out.println("--> Choice: ");
		// Gather user's choice
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		Shop temp = new Shop();
		// Flow based on user's choice
		while(choice != 0) {
			if(choice == 1) {
				Order.printOrder();
				getMenu();
				
			} else if(choice == 2) {
				temp.filterAndPrintShops(input.next());
				getMenu();
				
			} else if(choice == 3) {
				
			}
		}
	}
	
	// check if user is registered
	public static RegisteredCustomer logIn(String email, String password) {
		RegisteredCustomer customerFound = null;
		for(int i = 0; i < registeredCustomer.size(); i++) {
			if(registeredCustomer.get(i).getEmail().equals(email) &&
					registeredCustomer.get(i).getPassword().equals(password)) {
				customerFound = registeredCustomer.get(i);
			}
		}
		return customerFound;
	}
	
	// bring user's name, pointing at the specific 
	// credentials combination inserted
	public static String welcome(String email, String password) {
		String customerName = null;
		for(int i = 0; i < registeredCustomer.size(); i++) {
			if(registeredCustomer.get(i).getEmail().equals(email) &&
					registeredCustomer.get(i).getPassword().equals(password)) {
				customerName = registeredCustomer.get(i).getCustomerName();
			}
		}
		return customerName;
	}
	
	@Override
	public String toString() {
		return super.toString() + " --Id: " + getRegCustomerId() + " --Email: " +
				getEmail() + " --Password: " + getPassword();
	}
}
