package Ergasia2019;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class describes the registered customers of our
 * application, in specific the ones who have successfully
 * registered and are able to login using their credentials
 *
 * @author gkodosis
 * @author kasthanos
 *
 *
 */
public class RegisteredCustomer extends Customer {

	private static int count; //count created objects
	private int regCustomerId; //registeredcustomer's id
	private String email; //registeredcustomer's email
	private String password; //registeredcustomer's password
	static ArrayList<RegisteredCustomer> registeredCustomer = new ArrayList<RegisteredCustomer>(); //arraylist to store the RegisteredCustomers

	/**
	 * Full constructor
	 *
	 * @param fullname
	 *        RegisteredCustomer's name.
	 * @param phoneNumber
	 *        RegisteredCustomer's phone.
	 * @param address
	 *        RegisteredCustomer's address.
	 * @param email
	 *        RegisteredCustomer's email.
	 * @param password
	 *        RegisteredCustomer's password.
	*/
	public RegisteredCustomer(String fullname, String phoneNumber,
			String address, String email, String password) {

		super(fullname, phoneNumber, address);
		setRegCustomerId(count++); //assign the current value of the static variable count to the id
		this.email = email;
		this.password = password;
		registeredCustomer.add(this); //add object to the arraylist
	}

	/**
	* Default constructor
	*
	*/

	public RegisteredCustomer(){

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
		double totalcost = 0;
		Shop shop = new Shop();
		Order order = new Order();
		// Flow based on user's choice
		while(choice != 0) {
			if(choice == 1) {
				order.printOrder();
				getMenu();

			} else if(choice == 2) {
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

			} else if(choice == 3) {
				System.out.println("-- Please provide us with the id of shop: ");
				System.out.println();
				String s = input.next();
				int id = Integer.parseInt(s);

				if (s.length() > 0) {
					while (shop.searchById(id) == null) {
						System.out.println("-- Id doesn't exist! ");
						System.out.println("-- Please provide us with a valid id of shop: ");
						System.out.println();
						s = input.next();
						id = Integer.parseInt(s);
						if (s.length() == 0) {
							getMenu();
						}
					}
				} else {
					getMenu();
				}
				shop.searchById(id).printCatalogue();
				ArrayList<Integer[][]> idQuantities = new ArrayList<Integer[][]>();
				System.out.println("-- Please provide us with the id of product: ");
				System.out.println();
				String s2 = input.next();
				int productid = Integer.parseInt(s2);
				int amount;
				while (s2.length() > 0) { //PROBLEM DON'TS ACCEPT ENTER KEY

					if (shop.searchById(id).productIdExists(productid) == true) {
						System.out.println("-- Please provide us with the amount of product: ");
						System.out.println();
						amount = input.nextInt();
						while ((amount < 1) || (amount > 20)) {
							System.out.println("-- Amount out of bounds! ");
							System.out.println("-- Please provide us with a valid amount of product: ");
							System.out.println();
							amount = input.nextInt();
						}

					}else {
						while (shop.searchById(id).productIdExists(productid) != true){
							System.out.println("-- Id doesn't exist! ");
							System.out.println("-- Please provide us with a valid id of product: ");
							System.out.println();
							s2 = input.next();
							productid = Integer.parseInt(s2);
							if (s2.length() == 0) {
								getMenu();
							}
						}
						System.out.println("-- Please provide us with the amount of product: ");
						System.out.println();
						amount = input.nextInt();
						while ((amount < 1) || (amount > 20)) {
							System.out.println("-- Amount out of bounds! ");
							System.out.println("-- Please provide us with a valid amount of product: ");
							System.out.println();
							amount = input.nextInt();
						}
					}
					Integer[][] order0 = {{productid, amount}};
					idQuantities.add(order0);
					totalcost = totalcost + shop.searchById(id).printProductPrice(productid);
					System.out.println("-- Please provide us another id of product: ");
					System.out.println();
					s2 = input.next();
					productid = Integer.parseInt(s2);
					s2 ="";
				} //UNTIL HERE IT'S FINE
				String pdata = "----------------------" + "\n"
								+ "Your Order:" + "\n"
								+ "----------------------" + "\n"
								+ "Brand: " + shop.searchById(id).getBrand() + "\n";
				System.out.println(pdata);
				for(int i = 0; i < idQuantities.get(0).size(); i ++) {
				System.out.println("Products: " + idQuantities.get(i)[0] + "\n"
								+ "Amounts: " + idQuantities.get(i)[1]);
				}
				System.out.println();
				System.out.println("-- Do you want to save your order? ");
				System.out.println("-- Type N if you want ");
				System.out.println();
				String save = input.next();
				if (save == "N") {
					order.printOrder();
				}
				getMenu();

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
		return super.toString() + "ID: " + getRegCustomerId() + "\n" + "Email: " +
				getEmail() + "\n" + "Password: " + getPassword();
	}
}