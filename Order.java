import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class models the ordering process 
 * made from a customer 
 * @author gkodosis
 * @author kasthanos
 *
 */
public class Order {

	private int orderId; //order's id
	private int count; //count created objects
	private static Customer customer;
	private Shop shop;
	// maybe for loop for product id's
	static ArrayList<Integer[][]> orders = new ArrayList<Integer[][]>();
	private double totalOrderCost; //order's cost
	private String orderStamp; //order's date

	// gain access to non-static 
	public Order() {}
	
	/**
	* Full constructor
	*
	* @param customer
	*        Customer's object.
	* @param shop
	*        Shop's object.
	* @param shopPhoneNumber
	*        Shop's phone.
	* @param orders
	*        Order's orders.
	* @param totalOrderCost
	*        Order's cost.
	* @param orderStamp
	*        Order's date.
	*/
	
	public Order(Customer customer, Shop shop, ArrayList<Integer[][]> orders, 
			double totalOrderCost, String orderStamp) {
		
		this.customer = customer;
		this.shop = shop;
		this.orders = orders;
		setOrderId(count++);
		setOrderStamp(orderStamp);
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setCustomerOrder(Customer customer) {
		this.customer = customer;
	}
	
	public static Customer getCustomerOrder() {
		return customer;
	}
	
	public void setShopOrder(Shop shop) {
		this.shop = shop;
	}
	
	public Shop getShopOrder() {
		return shop;
	}
	
	public void setTotalOrderCost(double totalOrderCost) {
		this.totalOrderCost = totalOrderCost;
	}
	
	public double getTotalOrderCost() {
		return totalOrderCost;
	}
	
	public void setOrderStamp(String orderStamp) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.orderStamp = dateFormat.format(date);
	}
	
	public String getOrderStamp() {
		return orderStamp;
	}
	
	public String toString() {
		// check the client's "if exists" case
		return "Order's DateTime: " + getOrderStamp() + " Customer's Name: " +
				getCustomerOrder().getCustomerName() + " Shop's Brand Name: " + 
				getShopOrder().getBrand() + " Order's List: " + " -- Product's Name: " 
				+ orders.get(getOrderId())[0] + " -- Ammount: x" + orders.get(getOrderId())[1]
				+ " Order's Total Cost: " + getTotalOrderCost();
	}
	
	public static void printOrder() {
		Order temp = new Order();
		for(int i = 0; i < RegisteredCustomer.registeredCustomer.size(); i++) {
			if(getCustomerOrder().getPhoneNumber().equals(
					RegisteredCustomer.registeredCustomer.get(i).getPhoneNumber())) {
				System.out.println("Order's DateTime: " + temp.getOrderStamp());
				System.out.println("Shop's Brand Name: " + temp.getShopOrder().getBrand());
				System.out.println("Order's Total Cost: " + temp.getTotalOrderCost());
			}
		}
	}
}
