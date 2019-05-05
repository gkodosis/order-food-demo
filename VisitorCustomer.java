package Ergasia2019;

import java.util.Scanner;

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
		System.out.println("-- Preview Shop's Products: Press 2");
		System.out.println();
		System.out.println("--> Choice: ");
		// Gather user's choice
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		Shop shop = new Shop();
		// Flow based on user's choice
		while(choice != 0) {
			if(choice == 1) {
				System.out.println("-- Please provide us with the part of brand: ");
				System.out.println();
				System.out.println("--> Choice: ");
				String line = input.next();
				if (line.length() > 0){
					shop.filterAndPrintShops(line);
				}else {
					shop.printAllShops();
				}
				getMenu();

			} else if(choice == 2) {

				getMenu();
			}
		}
	}
}//End of class
