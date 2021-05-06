package Login_Sys;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class LoginTester {
	
	static ArrayList<String> acc = new ArrayList<>();
	static ArrayList<String> pswd = new ArrayList<>();
	
	@Test
	public void testMatch() {
		
		acc.add("zehua");
		acc.add("patrick");
		acc.add("wangz");
		pswd.add("zehua123");
		pswd.add("patrick123");
		pswd.add("wangz123");
		assertTrue(match("zehua", "zehua123"));
		assertTrue(match("patrick", "patrick123"));
		assertFalse(match("patrick1", "patrick123"));
	}
	
	@Test
	public void testReadInFile() {
		readInFile();
		assertTrue(acc.indexOf("Zehua") == 0);
		assertTrue(acc.indexOf("justin") == 5);
		assertTrue(acc.indexOf("Justin123") == -1);
		assertTrue(pswd.indexOf("Justin123") == -1);
		assertTrue(pswd.indexOf("goodm123") == 4);
		assertTrue(pswd.indexOf("Jb123...") == 6);
	}
	
	public static boolean match(String s, String p) {
		int flag = acc.indexOf(s);
		if(flag == -1) {
			return false;
		} else {
			if(pswd.get(flag).equals(p)) {
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
				acc.add(in.next());
				pswd.add(in.next());
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}