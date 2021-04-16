package pages;
	
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
	
	class homePageTest {
		homePage hp;
		static ArrayList<String> initial = new ArrayList<>();
		static ArrayList<String> textarea = new ArrayList<>();
		static ArrayList<String> account = new ArrayList<>();
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
	
	}
