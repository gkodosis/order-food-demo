import java.util.ArrayList;

/**
 * This abstract class aims at designing the base 
 * characteristics of each customer
 * @author gkodosis
 *
 */
public abstract class Customer {
	
	private String fullname;
	private String phoneNumber;
	private String address;
	ArrayList<Customer> customer = new ArrayList<Customer>();
	
	public Customer(String fullname, String phoneNumber, String address) {
		this.fullname = fullname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		customer.add(this);
	}

	public void setCustomerName(String fullname) {
		this.fullname = fullname;
	}
	
	public String getCustomerName() {
		return fullname;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	// get menu based on user's type
	public abstract void getMenu();
	
	@Override
	public String toString() {
		return "--Fullname: " + getCustomerName() + " --Phone Number: " + getPhoneNumber()
			+ " --Address: " + getAddress();
	}
		
}
