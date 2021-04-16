package shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class shopCart {

	public static void main(String[] args) throws IOException {

		ArrayList<String> cartInfo = new ArrayList<>();
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter what you want to buy");
		String user = myObj.nextLine();

		BufferedReader objReader = null;
		String strCurrentLine;
		objReader = new BufferedReader(new FileReader("products.txt"));
		while ((strCurrentLine = objReader.readLine()) != null) {
			//System.out.println(strCurrentLine);
			int i = strCurrentLine.indexOf("\t");
			cartInfo.add(strCurrentLine.substring(0, i+1));
			String temp = strCurrentLine.substring(0, i+1);
			if (temp.contains(user)) {
				System.out.println(cartInfo);
			}
		}
		if (objReader != null)
			objReader.close();
	}

}
