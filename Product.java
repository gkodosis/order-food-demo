/**
 * This class includes all the products distributed
 * from our platform and their specifications 
 * @author gkodosis
 * 
 */
public class Product {
	
	private int productId;
	private int count;
	private String productName;
	private double price;
	
	public Product(int productId, String productName, double price) {
		this.productName = productName;
		this.price = price;
		setProductId(count++);
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
