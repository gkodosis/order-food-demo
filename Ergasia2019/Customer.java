package Ergasia2019;

import java.util.ArrayList;

/**
 * This abstract class aims at designing the base
 * characteristics of each Customer
 *
 * @author gkodosis
 * @author kasthanos
 *
 */
public abstract class Customer {

	private String fullname; //customer's full name
	private String phoneNumber; //customer's phone number
	private String address; //customer's address
	ArrayList<Customer> customer = new ArrayList<Customer>(); //array list to store the Customers

	/**
	* Full constructor
	*
	* @param fullname
	*        Customer's full name.
	* @param phoneNumber
	*        Customer's phone number.
	* @param address
	*        Customer's address.
	*/

	public Customer(String fullname, String phoneNumber, String address) {
		this.fullname = fullname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		customer.add(this); //add object to the array list
	}

	/**
	* Default constructor
	*
	*/
	public Customer(){

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

	/* get menu based on customer's type */
	public abstract void getMenu();

	@Override
	public String toString() {
		String pdata = "----------------------" + "\n"
				+ "Customer Personal Data:" + "\n"
				+ "----------------------" + "\n"
				+ "Fullname: " + getCustomerName() + "\n"
				+ "Phone Number: " + getPhoneNumber() + "\n"
				+ "Address: " + getAddress();

		return pdata;
	}

} //End of class