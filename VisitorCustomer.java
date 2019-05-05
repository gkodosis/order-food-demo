/**
 * This class describes the visitor customers of,
 * meaning they decide to explore our platform
 * without using any credentials
 * @author gkodosis
 * @author kasthanos
 */
public class VisitorCustomer extends Customer {
	/**
	 * Full constructor
	 *
	 * @param fullname
	 *        VisitorCustomer's name.
	 * @param phoneNumber
	 *        VisitorCustomer's phone.
	 * @param address
	 *        VisitorCustomer's address.

	*/
	public VisitorCustomer(String fullname, String phoneNumber, String address) {
		super(fullname, phoneNumber, address);
	}
	
	/**
	* Default constructor
	*
	*/

	public VisitorCustomer(){

	}
	@Override
	public void getMenu() {
		System.out.println("-- Browse Available Shops: Press 1");
		System.out.println("-- Preview Shop's Products: Press 1");
	}
	
}//End of class
