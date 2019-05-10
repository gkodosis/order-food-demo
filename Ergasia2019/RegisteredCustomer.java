package Ergasia2019;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class describes the registered customers of our
 * application, in specific the ones who have successfully
 * registered and are able to login using their credentials
 *
 * @author gkodosis
 * @author kasthanos
 *
 */
public class RegisteredCustomer extends Customer {

	private static int count; //count created objects
	private int regCustomerId; //registered customer's id
	private String email; //registered customer's email
	private String password; //registered customer's password
	private boolean continueLoop;
	//array list to store the Registered Customers
	static ArrayList<RegisteredCustomer> registeredCustomer = new ArrayList<RegisteredCustomer>();

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
		setRegCustomerId(count++); //assign the current value of the counter to the id
		this.email = email;
		this.password = password;
		registeredCustomer.add(this); //add object to the array list
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

	/* register's customer menu */
	@Override
	public void getMenu() {
		System.out.println();
		System.out.println("-- Show Previous Orders: Press 1");
		System.out.println("-- Browse Available Shops: Press 2");
		System.out.println("-- Preview Catalogue & Order: Press 3");
		System.out.println();
		System.out.println("--> Choice: ");
		//Gather user's choice
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		double totalcost = 0;
		int count = 0;
		Shop shop = new Shop();
		Order order = new Order();
		//Flow based on user's choice
		while(choice != 0) {

			do {
				try {

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
						} else {
							shop.printAllShops();
						}
						getMenu();

					} else if(choice == 3) {
						System.out.println("-- Please provide us with the id of shop: ");
						System.out.println();

						do {
							try {
								String s = input.next();
								int id = Integer.parseInt(s);
								continueLoop = false;

								do {
									try {
										System.out.println("-- Id doesn't exist! ");
										System.out.println("-- Please provide us with a valid id of shop: ");
										System.out.println();
										input.nextLine();
										s = input.nextLine();
										id = Integer.parseInt(s);

									} catch(NumberFormatException e) {
										getMenu();

									} catch(NullPointerException e) {
										getMenu();
									}

								} while(shop.searchById(id) == null);

								shop.searchById(id).printCatalogue();
								ArrayList<Integer[][]> idQuantities = new ArrayList<Integer[][]>();

								System.out.println("-- Please provide us with the id of product: ");
								System.out.println();
								String s2 = input.next().trim();
								int productid = Integer.parseInt(s2);
								int amount;

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

								} else {

									do {
										try {
											System.out.println("-- Id doesn't exist! ");
											System.out.println("-- Please provide us with a valid id of product: ");
											System.out.println();
											input.nextLine();
											s2 = input.nextLine();
											productid = Integer.parseInt(s2);
										} catch(InputMismatchException e) {
											getMenu();
										} catch(NullPointerException e) {
											getMenu();
										}
									} while(shop.searchById(id).productIdExists(productid) != true);

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
								count = count + 1;

								if ((shop.searchById(id) != null) && (shop.searchById(id).productIdExists(productid) == true)) {
									totalcost = totalcost + shop.searchById(id).searchProductPrice(productid) * amount;
								}
								System.out.println("-- Please provide us another id of product: ");
								System.out.println();
								s2 = input.next();
								productid = Integer.parseInt(s2);
								s2 ="";

								String pdata = "----------------------" + "\n"
										+ "Your Order:" + "\n"
										+ "----------------------" + "\n"
										+ "Brand: " + shop.searchById(id).getBrand() + "\n"
										+ "----------------------" + "\n";
								System.out.println(pdata);
								for(int i = 0; i < count; i ++) {

									System.out.println("Product Name: " + shop.searchById(id).searchProductName(idQuantities.get(i)[i][0]) + " ~~ Amount: " + idQuantities.get(i)[i][1]+ "\n" + "----------------------" + "\n");
								}
								System.out.println("Order's Total Cost : " + totalcost );
								System.out.println();
								System.out.println("-- Do you want to save your order? ");
								System.out.println("-- Type N if you want ");
								System.out.println();
								char save = input.next().trim().charAt(0);
								if (save == 'N') {
									Order or = new Order(this, shop.searchById(id), idQuantities, totalcost,"yyyy/MM/dd HH:mm:ss");
									System.out.println(or.toString());
								} else {
									getMenu();
								}
								getMenu();

							} catch(NumberFormatException e) {
								System.out.println("Sorry something went wrong, please try again!");
								System.out.println();
								getMenu();

							} catch(NullPointerException e) {
								getMenu();
							}

						} while(continueLoop);

					} else {
						throw new InputMismatchException();
					}

				} catch(InputMismatchException e) {
					System.out.println("Wrong choice, please try again: ");
					System.out.println();
					input.nextLine();
				}
			} while(choice < 0);
		}
	}

	/* check if user is registered */
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

	/* bring user's name, pointing at the specific
	   credentials combination inserted */
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
} //End of class