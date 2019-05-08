package Ergasia2019;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class describes the visitor customers of,
 * meaning they decide to explore our platform
 * without using any credentials
 * 
 * @author gkodosis
 * @author kasthanos
 * 
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
		//Gather user's choice
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		double totalcost = 0;
		int count = 0;
		Shop shop = new Shop();
		Order order = new Order();
		//Flow based on user's choice
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
				String s2 = input.next().trim();
				int productid = Integer.parseInt(s2);
				int amount;
				while (!s2.isEmpty()) { //PROBLEM DON'TS ACCEPT ENTER KEY

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
					count = count + 1;

					if ((shop.searchById(id) != null) && (shop.searchById(id).productIdExists(productid) == true)) {
						totalcost = totalcost + shop.searchById(id).searchProductPrice(productid) * amount;
					}
					System.out.println("-- Please provide us another id of product: ");
					System.out.println();
					s2 = input.next();
					productid = Integer.parseInt(s2);
					s2 ="";
				} //UNTIL HERE IT'S FINE
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
				System.out.println(save == 'N');
				if (save == 'N') {
					System.out.println("Please provide us with the following info: ");
					System.out.println("Fullname: ");
					String fullname = input.next();
					System.out.println("Phone Number: ");
					String phoneNumber = input.next();
					System.out.println("Address: ");
					String address = input.next();
					VisitorCustomer v = new VisitorCustomer( fullname, phoneNumber,
						address);
					Order or = new Order(v, shop.searchById(id), idQuantities, totalcost,"yyyy/MM/dd HH:mm:ss");
					System.out.println(or.toString());
				} else {
					getMenu();
				}
			 getMenu();

			}

		}
	}
} //End of class