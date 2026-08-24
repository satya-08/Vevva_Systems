package OOPS_Design;
import java.util.*;
public class Student_Course {
	static HashMap<String,ArrayList<Product>> hs=new HashMap<>();
	public static void main(String[] args) {
		
		hs.put("Drink", new ArrayList<>(Arrays.asList(new Product("Fizz",20),new Product("Cococola",30))));
		display("Drink");
		priceDesc();
	
	}
	static void display(String str) {
		double maxPrice=0;
		Product p1=new Product();
		for(Product pro:hs.get(str)) {
			System.out.println(pro.toString());
			if(maxPrice<pro.getPrice()) {
				p1=pro;
				maxPrice=pro.getPrice();
			}
		}
		
		System.out.println(hs.get(str).size());
		System.out.println(p1.toString());
	}
	
	static void priceDesc() {
		
		
		for(String str:hs.keySet()) {
			ArrayList<Product> dummy=hs.get(str);
			dummy.sort(Comparator.comparing(Product::getPrice).reversed());
			for(Product pro:dummy) {
				System.out.println(pro.toString());
			}
		}
	}
	

}
class Product{
	private String name;
	private double price;
	Product(String name,double price){
		this.name=name;
		this.price=price;
	}
	Product(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
}
