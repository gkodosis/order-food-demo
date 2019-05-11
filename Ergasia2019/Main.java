package Ergasia2019;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class show-cases the functionality of our
 * java e-shop application
 * 
 * @author gkodosis
 * @author kasthanos
 *
 */
public class Main {

	/* load objects to test app's functionality */
	public static void loadObjects() {
		//Registered Customers
		RegisteredCustomer r1 = new RegisteredCustomer("Achilleas Kontis", "6954324789",
				"Tinou 2, Marousi", "ach@hotmail.com", "ach45");
		RegisteredCustomer r2 = new RegisteredCustomer("Georgios Kontosis", "6945908751",
				"Areos 78, Kipseli", "gkont@hotmail.com", "aueb15");
		RegisteredCustomer r3 = new RegisteredCustomer("Athanasios Kaselouris", "6939656208",
				"Sirakouswn 54, Chalandri", "kasthanos@gmail.com", "kast97");
		//Visitor Customers
		VisitorCustomer v1 = new VisitorCustomer("Iordanis Kaldis", "6947870993", "Artemidos 36, Patisia");
		VisitorCustomer v2 = new VisitorCustomer("Themis Koutsaftis", "6938685677", "Thivwn 23, Athens");
		VisitorCustomer v3 = new VisitorCustomer("Michalis Ioannidis", "6945908902", "Makedonias 44, Peristeri");
		//Product Examples
		Product p11 = new Product("Kalamaki Xoirino", 1.80);
		Product p12 = new Product("Sofoklis Burger", 5.30);
		Product p13 = new Product("Giros Xoirinos", 2.70);
		Product p14 = new Product("Kalamaki Kotopoulo", 1.80);
		Product p15 = new Product("Patates Tiganites", 2.60);
		Product p21 = new Product("Pizza Nachos", 9.90);
		Product p22 = new Product("Onion Rings", 3.25);
		Product p23 = new Product("Hangover Burger", 4.90);
		Product p24 = new Product("Patates Crosscut with BBQ sauce", 3.45);
		Product p25 = new Product("Skordopsomo Aplo", 2.60);
		Product p26 = new Product("Salata Mesogeiaki", 5.90);
		Product p31 = new Product("Kotosoupa", 6.00);
		Product p32 = new Product("Fakies", 4.00);
		Product p33 = new Product("Mosxaraki Lemonato", 7.00);
		Product p34 = new Product("Pastitsio", 7.00);
		Product p35 = new Product("Gigantes Fournou", 5.00);
		Product p36 = new Product("Tirokafteri", 2.50);
		Product p41 = new Product("Fava", 4.60);
		Product p42 = new Product("Gemista", 5.50);
		Product p43 = new Product("Mousakas", 6.00);
		Product p44 = new Product("Biftekia Mosxarisia", 6.00);
		Product p45 = new Product("Kotopoulo a la Creme", 7.50);
		Product p46 = new Product("Taliateles Anoiksiatikes", 5.50);
		Product p47 = new Product("Tzatziki Merida", 3.00);
		Product p48 = new Product("Patates Tiganites creepers", 2.50);
		//Shops
		ArrayList<Product> shopsProducts1 = new ArrayList<Product>();
		shopsProducts1.add(p11);
		shopsProducts1.add(p12);
		shopsProducts1.add(p13);
		shopsProducts1.add(p14);
		shopsProducts1.add(p15);
		Shop s1 = new Shop("Sofoklis", "Zagoras 2, Goudi", "210-7704677", shopsProducts1);
		ArrayList<Product> shopsProducts2 = new ArrayList<Product>();
		shopsProducts2.add(p21);
		shopsProducts2.add(p22);
		shopsProducts2.add(p23);
		shopsProducts2.add(p24);
		shopsProducts2.add(p25);
		shopsProducts2.add(p26);
		Shop s2 = new Shop("Pizza Fun", "Leof. Amarousiou 27, Pefki", "210-8022055", shopsProducts2);
		ArrayList<Product> shopsProducts3 = new ArrayList<Product>();
		shopsProducts3.add(p31);
		shopsProducts3.add(p32);
		shopsProducts3.add(p33);
		shopsProducts3.add(p34);
		shopsProducts3.add(p35);
		shopsProducts3.add(p36);
		Shop s3 = new Shop("Grande Capone", "Mavromixali 159, Gkizi", "210-6472055", shopsProducts3);
		ArrayList<Product> shopsProducts4 = new ArrayList<Product>();
		shopsProducts4.add(p41);
		shopsProducts4.add(p42);
		shopsProducts4.add(p43);
		shopsProducts4.add(p44);
		shopsProducts4.add(p45);
		shopsProducts4.add(p46);
		shopsProducts4.add(p47);
		shopsProducts4.add(p48);
		Shop s4 = new Shop("To Spitiko", "Patissiwn 97, Athens", "210-8837717", shopsProducts4);
		//Order Creation
		ArrayList<Integer[][]> idQuantities1 = new ArrayList<Integer[][]>();
		Integer[][] order1 = {{11,4},{12,1},{14,3}};
		idQuantities1.add(order1);
		Order o1 = new Order(v1, s1, idQuantities1, 17.90, "2019/05/02 17:30:24");
		ArrayList<Integer[][]> idQuantities2 = new ArrayList<Integer[][]>();
		Integer[][] order2 = {{22,1},{21,1},{24,1}};
		idQuantities2.add(order2);
		Order o2 = new Order(r1, s2, idQuantities2, 16.60, "2019/05/03 19:30:44");
		ArrayList<Integer[][]> idQuantities3 = new ArrayList<Integer[][]>();
		Integer[][] order3 = {{33,1},{34,1}};
		idQuantities3.add(order3);
		Order o3 = new Order(v2, s3, idQuantities3, 14.00, "2019/05/02 14:56:04");
		ArrayList<Integer[][]> idQuantities4 = new ArrayList<Integer[][]>();
		Integer[][] order4 = {{31,1},{35,1},{36,1}};
		idQuantities4.add(order4);
		Order o4 = new Order(r2, s3, idQuantities4, 13.50, "2019/05/10 13:39:55");
		ArrayList<Integer[][]> idQuantities5 = new ArrayList<Integer[][]>();
		Integer[][] order5 = {{23,1},{24,2}};
		idQuantities5.add(order5);
		Order o5 = new Order(v3, s2, idQuantities5, 11.80, "2019/05/06 20:20:14");
		ArrayList<Integer[][]> idQuantities6 = new ArrayList<Integer[][]>();
		Integer[][] order6 = {{12,2},{15,2}};
		idQuantities6.add(order6);
		Order o6 = new Order(r3, s1, idQuantities6, 15.80, "2019/05/05 21:45:02");
	}

	public static void mainMenu() {
		System.out.println("** Welcome to our e-shop! Please select one of the above: **");
		System.out.println();
		System.out.println("--- MENU ---");
		System.out.println("-- Register: Press 1");
		System.out.println("-- Login: Press 2");
		System.out.println("-- Continue as visitor: Press 3");
		System.out.println();
		System.out.println("--> Choice: ");
	}

	public static int inputCheck(int choice) {
		return choice / 10;
	}

	public static void main(String[] args) {
		//create global objects to access abstract methods
		//Registered Customer
		RegisteredCustomer r0 = new RegisteredCustomer();
		//Visitor Customer
		VisitorCustomer v0 = new VisitorCustomer();
		//Product Examples
		Product p0 = new Product();
		//Shops
		ArrayList<Product> shopsProducts = new ArrayList<Product>();
		shopsProducts.add(p0);
		Shop s0 = new Shop();
		//Orders Creation
		ArrayList<Integer[][]> idQuantities = new ArrayList<Integer[][]>();
		Integer[][] order0 = {};
		idQuantities.add(order0);
		Order o0 = new Order();

		//start main functionality
		loadObjects();
		//gather user's choices
		Scanner input = new Scanner(System.in);
		int choice = 5;

		while(choice != 0) {

			do {
				try {
					mainMenu();
					choice = input.nextInt();

					if(choice == 1) {
						System.out.println("Please provide us with the following info: ");
						System.out.println("Fullname: ");
						String fullname = input.next();
						System.out.println("Phone Number: ");
						String phoneNumber = input.next();
						System.out.println("Address: ");
						String address = input.next();
						System.out.println("Email: ");
						String email = input.next();
						System.out.println("Password: ");
						String password = input.next();

						new RegisteredCustomer( fullname, phoneNumber,
								address, email, password);

					} else if(choice == 2) {
						System.out.println("Please provide us with the following info: ");
						System.out.println("Email: ");
						String email = input.next();
						System.out.println("Password: ");
						String password = input.next();

						if(RegisteredCustomer.logIn(email, password) != null) {
							System.out.println(RegisteredCustomer.welcome(email, password) +
									" You are now loged-in to our e-shop! ");
							r0.getMenu();
							choice = input.nextInt();
						} else {
							System.out.println("Wrong credentials, please try again: ");
							System.out.println();
						}

					} else if(choice == 3) {
						v0.getMenu();
						choice = input.nextInt();

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

}//End of class