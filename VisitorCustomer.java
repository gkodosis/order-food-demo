/**
 * This class describes the visitor customers of,
 * meaning they decide to explore our platform
 * without using any credentials
 * @author gkodosis
 * 
 */
public class VisitorCustomer extends Customer {

	public VisitorCustomer(String fullname, String phoneNumber, String address) {
		super(fullname, phoneNumber, address);
	}
	
	@Override
	public void getMenu() {
		System.out.println("-- Browse Available Shops: Press 1");
		System.out.println("-- Preview Shop's Products: Press 1");
	}
	
}
