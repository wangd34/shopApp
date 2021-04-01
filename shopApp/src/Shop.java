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
	 
	public void addProduct() throws IOException {
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
        
        File myObj = new File("CommodityList.txt");
        Scanner myReader = new Scanner(myObj); 
        String data;
        while (myReader.hasNextLine()) {
          data = myReader.nextLine();
          System.out.println(data);
          if (data.contains("fruit")) {
        	  File file1 = new File("fruit.txt");
              FileWriter fw1 = new FileWriter(file1,true);
              BufferedWriter bw1 = new BufferedWriter(fw1);
              bw1.write(prodInf.toString());
              bw1.newLine();
              bw1.close();
          }
          if (data.contains("drinks")) {
        	  File file2 = new File("drinks.txt");
              FileWriter fw2 = new FileWriter(file2,true);
              BufferedWriter bw2 = new BufferedWriter(fw2);
              bw2.write(prodInf.toString());
              bw2.newLine();
              bw2.close();
          }
          if (data.contains("meat")) {
        	  File file3 = new File("meat.txt");
              FileWriter fw3 = new FileWriter(file3,true);
              BufferedWriter bw3 = new BufferedWriter(fw3);
              bw3.write(prodInf.toString());
              bw3.newLine();
              bw3.close();
          }
          if (data.contains("spices")) {
        	  File file4 = new File("spices.txt");
              FileWriter fw4 = new FileWriter(file4,true);
              BufferedWriter bw4 = new BufferedWriter(fw4);
              bw4.write(prodInf.toString());
              bw4.newLine();
              bw4.close();
          }
          
        }
        myReader.close();
		
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