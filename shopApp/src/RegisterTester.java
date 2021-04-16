import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.Test;

public class RegisterTester {

	static ArrayList<String> fullName = new ArrayList<>();
	static ArrayList<String> userName= new ArrayList<>();
	static ArrayList<String> pass = new ArrayList<>();
	static ArrayList<String> compass = new ArrayList<>();
	
	@Test
	public void testPass() {
		pass.add("123456");
		compass.add("123456");
		pass.add("abcdef");
		compass.add("abcdef");
		pass.add("fedcba");
		compass.add("abcdef");
		pass.add("ABCDEF");
		compass.add("ABCDEF");
		assertEquals(pass.get(0), compass.get(0));
		assertEquals(pass.get(1), compass.get(1));
		assertFalse(pass.get(2).equals(compass.get(2)));
		assertTrue(pass.get(3).equals(compass.get(3)));
	}
	
	
}
