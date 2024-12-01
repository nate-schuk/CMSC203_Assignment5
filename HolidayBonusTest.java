/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: Tests the holiday  bonus class.
 * Due: 12/3/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Nathaniel Schuknecht
*/

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTest {

	private double[][] dataSet1 = { { 22.1, 42.4, 3 }, { 6.6, 3.2 }, { 8, 1, 34.5 } };

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		dataSet1 = null;
	}

	@Test
	public void testCalculateHolidayBonusA() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
			assertEquals(11000.0, result[0], .001);
			assertEquals(3000.0, result[1], .001);
			assertEquals(8000.0, result[2], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}

	}

	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(22000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
	}

}
