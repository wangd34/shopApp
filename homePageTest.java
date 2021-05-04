package pages;
	
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import Function.Products;
	
	class homePageTest {
		homePage hp;
		static ArrayList<String> initial = new ArrayList<>();
		static ArrayList<String> textarea = new ArrayList<>();
		static ArrayList<String> account = new ArrayList<>();
		ArrayList<String> name = new ArrayList<>();
		private static ArrayList<String> products = new ArrayList<>();
		private static ArrayList<String> shoppingCart = new ArrayList<>();
		
		@Test
		public void setUp() throws Exception{
			 hp = new homePage();
		}
		
		@Test
		public void testinitial() {
			initial.add("10");
			textarea.add("10");
			initial.add("kiwi");
			textarea.add("kiwi");
			initial.add("meat");
			textarea.add("meat");
			initial.add("drinks");
			textarea.add("drinks");
			assertEquals(initial.get(0), textarea.get(0));
			assertEquals(initial.get(1), textarea.get(1));
			assertTrue(initial.get(3).equals(textarea.get(3)));
			assertFalse(initial.get(2).equals(textarea.get(3)));
		}
		
		@Test
		public void testreadInFile() {
			readInFile();
			assertTrue(account.indexOf("Zehua") == 0);
			assertTrue(account.indexOf("justin") == 5);
			assertTrue(account.indexOf("Justin123") == -1);
			assertTrue(account.indexOf("Justin123") == -1);
			assertFalse(account.indexOf("Jb123...") == 6);
			assertFalse(account.indexOf("goodm123") == 4);
	}
		
		@Test
		public void testaddSC() {
			shoppingCart.add("apple");
			shoppingCart.add("meat");
			shoppingCart.add("orange");
			shoppingCart.add("computer");
			shoppingCart.add("sprite");
			assertTrue(shoppingCart.indexOf("apple") == 0);
			assertFalse(shoppingCart.indexOf("apple") == 1);
			assertTrue(shoppingCart.indexOf("meat") == 1);
			assertFalse(shoppingCart.indexOf("orange") == 5);
			assertTrue(shoppingCart.indexOf("computer") == 3);
			assertTrue(shoppingCart.indexOf("sprite") == 4);
	}
		@Test
		public void testsearchPro() {
			products.add("apple");
			name.add("apple");
			products.add("orange");
			name.add("meat");
			products.add("meat");
			name.add("beaf");
			products.add("computer");
			name.add("computer");
			assertTrue(products.indexOf("apple") == name.indexOf("apple"));
			assertFalse(products.indexOf("orange") == name.indexOf("apple"));
			assertFalse(products.indexOf("meat") == name.indexOf("meat"));
			assertTrue(products.indexOf("apple") == name.indexOf("apple"));
			assertTrue(products.indexOf("computer") == name.indexOf("computer"));
		}
		
		@Test
		public void testemptyShoppingCart() {
			emptyShoppingCart();
			assertTrue(shoppingCart.isEmpty());
		}
		
	public static boolean initial(String text, String button) {
		int frame = account.indexOf(text);
		if(frame == -1) {
			return false;
		} else {
			if(initial.get(frame).equals(button)) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public void readInFile() {
		File file = new File("Account");
		try {
			Scanner in = new Scanner(file);
			while(in.hasNextLine()) {
				account.add(in.next());
				initial.add(in.next());
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void addSC(String p){
		shoppingCart.add(p);
	}
	
	
	public int searchPro(Products p) {
		ArrayList<String> name = new ArrayList<>();
		for(String a : products) {
			name.add(a);
		}		
		int index = name.indexOf(p);
		return index;
	}
	
	public void emptyShoppingCart() {
		
		shoppingCart.clear();
	}
	
	}
