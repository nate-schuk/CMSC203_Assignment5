/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: Tests the TwoDimRaggedArrayUtility class.
 * Due: 12/3/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Nathaniel Schuknecht
*/

import static org.junit.Assert.*;

import java.io.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTest {
	private double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		dataSet1 = null;
	}

	@Test
	public void testGetAverage() {
		assertEquals(5.0, TwoDimRaggedArrayUtility.getAverage(dataSet1),.001);
	}
	
	@Test
	public void testGetColumnTotal() {
		assertEquals(11,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0),.001);
		assertEquals(14,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 1),.001);
		assertEquals(11,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 2),.001);
		assertEquals(9,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 3),.001);
	}
	
	@Test
	public void testGetHighestInArray() {
		assertEquals(9, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1),.001);
	}
	
	@Test
	public void testGetHighestInColumn() {
		assertEquals(6, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1,0),.001);
		assertEquals(7, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1,1),.001);
		assertEquals(8, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1,2),.001);
		assertEquals(9, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1,3),.001);
	}
	
	@Test
	public void testGetHighestInColumnIndex() {
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1,0),.001);
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1,1),.001);
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1,2),.001);	
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1,3),.001);
	}
	
	@Test
	public void testGetHighestInRow() {
		assertEquals(3,TwoDimRaggedArrayUtility.getHighestInRow(dataSet1,0),.001);
		assertEquals(5,TwoDimRaggedArrayUtility.getHighestInRow(dataSet1,1),.001);
		assertEquals(9,TwoDimRaggedArrayUtility.getHighestInRow(dataSet1,2),.001);
	}
	
	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1,0),.001);
		assertEquals(1,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1,1),.001);
		assertEquals(3,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1,2),.001);
	}
	
	@Test
	public void testGetLowestInArray() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1),.001);
	}
	
	@Test 
	public void testGetLowestInColumn() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1,0),.001);	
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1,1),.001);
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1,2),.001);
		assertEquals(9, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1,3),.001);
	}
	
	@Test
	public void testGetLowestInColumnIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1,0),.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1,1),.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1,2),.001);
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1,3),.001);
	}
	
	@Test
	public void testGetLowestInRow() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1,0),.001);
		assertEquals(4, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1,1),.001);
		assertEquals(6, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1,2),.001);
	}
	
	@Test
	public void testGetLowestInRowIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1,0),.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1,1),.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1,2),.001);
	}
	
	@Test
	public void testGetRowTotal() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
	}
	
	@Test
	public void testGetTotal() {
		assertEquals(45, TwoDimRaggedArrayUtility.getTotal(dataSet1),.001);
	}
	
	@Test
	public void testReadFile() throws IOException {
		File testFile = new File("testReadFile");

	    PrintWriter writer = new PrintWriter(testFile);
	    writer.println("1.0 2.0 3.0");
	    writer.println("4.0 5.0");
	    writer.println("6.0 7.0 8.0 9.0");
	    writer.close();
	   
	    for(int row = 0; row < dataSet1.length; row++) 
	    	for(int col = 0; col < dataSet1[row].length; col++)	
	    		assertEquals(dataSet1[row][col], TwoDimRaggedArrayUtility.readFile(testFile)[row][col],.001);
	}
	
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		 File testFile = new File("testWriteFile");

		 TwoDimRaggedArrayUtility.writeToFile(dataSet1, testFile);
		    
		 for(int row = 0; row < dataSet1.length; row++) 
		    for(int col = 0; col < dataSet1[row].length; col++)	
		    	assertEquals(dataSet1[row][col], TwoDimRaggedArrayUtility.readFile(testFile)[row][col],.001);
	}	
}
