package Ergasia2019;

import java.util.ArrayList;

/**
 * This class references to every shop hosted in
 * our platform, including their characteristics
 * and their unique products
 * 
 * @author gkodosis
 * @author kasthanos
 *
 */
public class Shop {

	private static int count; //count created objects
	private int shopId; //shop's id
	private String brand; //shop's brand
	private String address; //shop's address
	private String shopPhoneNumber; //shop's phone
	ArrayList<Product> inhouseProducts  = new ArrayList<Product>(); //array list to store the Products
	static ArrayList<Shop> shops = new ArrayList<Shop>(); //array list to store the Shops

	/**
	 * Full constructor
	 *
	 * @param brand
	 *        Shop's brand.
	 * @param address
	 *        Shop's address.
	 * @param shopPhoneNumber
	 *        Shop's phone.
	 * @param inhouseProducts
	 *        Shop's products.
	 */
	public Shop(String brand, String address, String shopPhoneNumber,
			ArrayList<Product> inhouseProducts) {

		this.brand = brand;
		this.address = address;
		this.setShopPhoneNumber(shopPhoneNumber);
		this.inhouseProducts = inhouseProducts;
		setShopId(count++);
		shops.add(this); //add object to the array list
	}

	/**
	 * Default constructor
	 *
	 */
	public Shop() {

	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getShopId() {
		return shopId;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setShopAddress(String address) {
		this.address = address;
	}

	public String getShopAddress() {
		return address;
	}

	public void setShopPhoneNumber(String shopPhoneNumber) {
		this.shopPhoneNumber = shopPhoneNumber;
	}

	public String getShopPhoneNumber() {
		return shopPhoneNumber;
	}

	/* method to check existence of product in shop
	   product's list */
	public boolean productIdExists(int idCheck) {
		boolean existence = false;
		for(int i = 0; i < inhouseProducts.size(); i++) {
			if(idCheck == inhouseProducts.get(i).getProductId()) {
				existence = true;
			}
		}
		return existence;
	}

	/* print product's name - description */
	public String printProductName(int idCheck) {
		return inhouseProducts.get(idCheck).getProductName();
	}

	/* print product's price */
	public double printProductPrice(int idCheck) {
		return inhouseProducts.get(idCheck).getPrice();
	}

	public String searchProductName(int idCheck) {
		String name = null;
		for(int i = 0; i < inhouseProducts.size(); i++) {
			if (idCheck == inhouseProducts.get(i).getProductId()){
				name = inhouseProducts.get(i).getProductName();
			}
		}
		return name;
	}

	/* print product's price */
	public double searchProductPrice(int idCheck) {
		double price = 0;
		for(int i = 0; i < inhouseProducts.size(); i++) {
			if (idCheck == inhouseProducts.get(i).getProductId()){
				price = inhouseProducts.get(i).getPrice();
			}
		}
		return price;
	}

	/* print list of products (check the per shopId) */
	public void printCatalogue() {
		for(int i = 0; i < inhouseProducts.size(); i++) {
			System.out.println( "Id: " + inhouseProducts.get(i).getProductId() + " Name: " +
					printProductName(i) + " Price: " + printProductPrice(i));
		}
	}

	/* search for shop's existence by id */
	public static Shop searchById(int idCheck) {
		Shop existence = null;
		for(int i = 0; i < shops.size(); i++) {
			if(idCheck == shops.get(i).getShopId()) {
				existence = shops.get(i);
			}
		}
		return existence;
	}

	/* print all shops */
	public void printAllShops() {
		for(int i = 0; i < shops.size(); i++)
			System.out.println(shops.get(i).toString());
	}

	/* prints shops containing the nameCheck value
	   at their brand name - description */
	public void filterAndPrintShops(String nameCheck) {
		for(int i = 0; i < shops.size(); i++) {
			if(shops.get(i).getBrand().contains(nameCheck)) {
				System.out.println(shops.get(i).toString());
			}
		}
	}

	public String toString() {
		return "Id: " + getShopId() + " Brand: " + getBrand() + " Address: "
				+ getShopAddress() + " Phone: " + getShopPhoneNumber();
	}
} //End of class