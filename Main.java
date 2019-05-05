import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class show-cases the functionality of our
 * java e-shop application
 * @author gkodosis
 *
 */
public class Main {

	// load objects to test app's functionality
	public static void loadObjects() {
		// Registered Customer
		RegisteredCustomer r1 = new RegisteredCustomer(1, "Achilleas Kontis", "6954324789", 
				"Tinou 2, Marousi", "ach@hotmail.com", "theo45");
		// Visitor Customer
		VisitorCustomer v1 = new VisitorCustomer("Iordanis Kaldis", "6987414598", "Artemis 36, Patisia");
		// Product Examples
		Product p1 = new Product(1, "Milk Fage 2%", 2.05);
		// Shops
		ArrayList<Product> shopsProducts = new ArrayList<Product>();
		shopsProducts.add(p1);
		Shop s1 = new Shop(1, "Fage", "Marti 3, Athens", "210-8976455", shopsProducts);
		// Order Creation
		ArrayList<Integer[][]> idQuantities = new ArrayList<Integer[][]>();
		Integer[][] order1 = {{1,4}};
		idQuantities.add(order1);
		Order o1 = new Order(v1, s1, idQuantities, 0, "2019/05/02 17:30:24");
	}

	public static void mainMenu() {
		System.out.println("** Welcome to our e-shop! Please select one of the above: **");
		System.out.println();
		System.out.println("-- Register: Press 1");
		System.out.println("-- Login: Press 2");
		System.out.println("-- Continue as visitor: Press 3");	
		System.out.println();
		System.out.println("--> Choice: ");		
	}

	public static void main(String[] args) {
		// create global objects to access abstract methods
		// Registered Customer
		RegisteredCustomer r0 = new RegisteredCustomer(1, "Achilleas Kontis", "6954324789", 
				"Tinou 2, Marousi", "ach@hotmail.com", "theo45");
		// Visitor Customer
		VisitorCustomer v0 = new VisitorCustomer("Iordanis Kaldis", "6987414598", "Artemis 36, Patisia");
		// Product Examples
		Product p0 = new Product(1, "Milk Fage 2%", 2.05);
		// Shops
		ArrayList<Product> shopsProducts = new ArrayList<Product>();
		shopsProducts.add(p0);
		Shop s0 = new Shop(1, "Fage", "Marti 3, Athens", "210-8976455", shopsProducts);
		// Order Creation
		ArrayList<Integer[][]> idQuantities = new ArrayList<Integer[][]>();
		Integer[][] order0 = {{1,4}};
		idQuantities.add(order0);
		Order o0 = new Order(v0, s0, idQuantities, 0, "2019/05/02 17:30:24");
		// start main functionality
		loadObjects();
		Scanner input = new Scanner(System.in);
		int choice = 1;

		while(choice != 0) {
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

				new RegisteredCustomer(r0.registeredCustomer.size() + 1, fullname, phoneNumber, 
						address, email, password);
				mainMenu();
				choice = input.nextInt();

			} else if(choice == 2) {
				System.out.println("Please provide us with the following info: ");
				System.out.println("Email: ");
				String email = input.next();
				System.out.println("Password: ");
				String password = input.next();

				if(RegisteredCustomer.logIn(email, password) != null) {
					System.out.println(RegisteredCustomer.welcome(email, password) +
							" you are now loged-in to our e-shop! ");
					r0.getMenu();
					choice = input.nextInt();
				} else {
					System.out.println("Wrong credentials, please try again: ");
					mainMenu();
					choice = input.nextInt();
				}

			} else if(choice == 3) {
				v0.getMenu();
				choice = input.nextInt();
			} else {
				System.out.println("Wrong choice, please press enter and try again: ");
				choice = input.nextInt();
			}
		}
	}

}
