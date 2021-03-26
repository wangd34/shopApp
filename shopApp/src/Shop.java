import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
	
public class Shop {
	
	 static ArrayList<Product> prodInf = new ArrayList<>();
	 
	public void addProduct() {
		System.out.println("Which product do you want to add?");
		System.out.println("Please enter following four requirments: Name, Kind, Num, Price.");
		Product prod = new Product(getName(), getKind(), getNum(), getPrice());
		boolean bool = prodInf.add(prod);
        if (bool == true) {
            System.out.println("Added Successfully!");
        } else {
            System.out.println("Added Failed!");
        }
        System.out.print(prodInf.toString());
		
	}
	
	
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		Shop shop = new Shop();
		boolean flag = true;
		System.out.println("Please choice what you want to do?");
		System.out.println("1. AddProduct");
		System.out.println("2. Exit");
		if (flag) {
			 switch (sc.nextInt()) {
	            case 1:
	                shop.addProduct();
	                File file = new File("CommodityList.txt");
	                FileWriter fw = new FileWriter(file,true);
	                BufferedWriter bw = new BufferedWriter(fw);
	                bw.write(prodInf.toString());
	                bw.newLine();
	                bw.close();
	                break;
	            case 2:
	            	flag = false;
	            	break;
	        }
		}
     }
	
	 public static String getName() {
	        Scanner a = new Scanner(System.in);
	        return a.next();
	    }
	 
	 public static String getKind() {
	        Scanner b = new Scanner(System.in);
	        return b.next();
	    }

	    public static int getNum() {
	        Scanner c = new Scanner(System.in);
	        return c.nextInt();
	    }

	    public static double getPrice() {
	        Scanner d = new Scanner(System.in);
	        return d.nextDouble();
	    }
	    
}