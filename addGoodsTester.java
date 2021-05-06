package functionalities;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class addGoodsTester {
	addGoods addG;
	static ArrayList<String> goods = new ArrayList<>();
	
	@Test
	public void setUp() throws Exception{
		 addG = new addGoods();
	}
	
	@Test
	public void readInFile() {
		File file = new File("fruit");
		try {
			Scanner in = new Scanner(file);
			while(in.hasNext()) {
				goods.add(in.next());
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	@Test
	void testinitial() {
		assertEquals(goods.get(0), "coconut");
		assertEquals(goods.get(1), "fruit");
		assertEquals(goods.get(4), "apple");
		assertEquals(goods.get(5), "fruit");
	}
	@Test
	public void testReadInFile() {
		readInFile();
		assertTrue(goods.indexOf("coconut") == 0);
	}
	

}