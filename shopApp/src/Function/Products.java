package Function;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Products {
	
	private static ArrayList<Products> products = new ArrayList<>();
	private String name, kind;
	private double quantity, price;
	
	public Products() {
		
	}
	
	
	public Products(String name, String kind, double quantity, double price) {
		this.name = name;
		this.kind = kind;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Products(String name) {
		this(name, "undefined", 0, 0);
	}
	
	public void inQuantity(double q) {
		setQuantity(this.quantity + q);
	}
	
	public void deQuantity(double q) {
		setQuantity(this.quantity - q);
	}
	
	public String appendP() {
		return String.format("%s\t%s\t%.2f\t%.2f", this.name,this.kind, this.quantity, this.price);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the kind
	 */
	public String getKind() {
		return kind;
	}
	/**
	 * @param kind the kind to set
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}
	/**
	 * @return the quatity
	 */
	public double getQuantity() {
		return quantity;
	}
	/**
	 * @param quatity the quatity to set
	 */
	public void setQuantity(double quatity) {
		this.quantity = quatity;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
