package OOPS_Design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Invetory_System {
	static HashMap<String,ArrayList<Product>> hs=new HashMap<>();
	public static void main(String[] args) {
		
		hs.put("Drinks", new ArrayList<>(Arrays.asList(
                new Product(101, "Coke", 20),
                new Product(102, "Pepsi", 25),
                new Product(103, "Sprite", 20),
                new Product(104, "Fanta", 30)
        )));

        hs.put("Snacks", new ArrayList<>(Arrays.asList(
                new Product(201, "Lays", 20),
                new Product(202, "Bingo", 25),
                new Product(203, "Kurkure", 20),
                new Product(204, "Doritos", 50)
        )));

        hs.put("Chocolates", new ArrayList<>(Arrays.asList(
                new Product(301, "Dairy Milk", 40),
                new Product(302, "KitKat", 30),
                new Product(303, "5 Star", 20),
                new Product(304, "Perk", 10)
        )));

        hs.put("Biscuits", new ArrayList<>(Arrays.asList(
                new Product(401, "Parle-G", 10),
                new Product(402, "Oreo", 40),
                new Product(403, "Good Day", 30),
                new Product(404, "Bourbon", 35)
        )));

        hs.put("Fruits", new ArrayList<>(Arrays.asList(
                new Product(501, "Apple", 120),
                new Product(502, "Banana", 60),
                new Product(503, "Orange", 80),
                new Product(504, "Mango", 100)
        )));
//        extractAllProducts("Drinks");
//        extractAllProductsCateogry();
        findCategory();

}
	private static void findCategory() {
		double maxPrice=0;
		Product product=new Product();
		System.out.println();
		for(String str:hs.keySet()) {
			for(Product pro:hs.get(str)) {
//				System.out.println(pro.toString());
				if(maxPrice<pro.getPrice()) {
					product=pro;
					maxPrice=pro.getPrice();
				}
			}
			
		}
		System.out.println(product.toString());
		
	}
	static void extractAllProducts(String str) {
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
	
	static void extractAllProductsCateogry() {
		
		
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
	private int id;
	private String name;
	private double price;
	Product(int id,String name,double price){
		this.id=id;
		this.name=name;
		this.price=price;
	}
	Product(){
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

