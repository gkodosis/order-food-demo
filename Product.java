/**
 * This class includes all the products distributed
 * from our platform and their specifications 
 * @author gkodosis
 * @author kasthanos
 */
public class Product {
	
	private int productId; //product's id
	private int count; //count created objects
	private String productName; //product's name
	private double price; //product's price
	
	/**
	 * Full constructor
	 *
	 * @param productName
	 *        Product's name.
	 * @param price
	 *        Product's price.
	*/
	
	public Product(String productName, double price) {
		this.productName = productName;
		this.price = price;
		setProductId(count++);
	}
	
	/**
	* Default constructor
	*
	*/

	public Product(){

	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return "Product's Name: " + productName + "Price: " + price;
	}
}
