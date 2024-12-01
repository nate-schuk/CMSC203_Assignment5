/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: Calculates the holiday bonus for the parameter matrix and can find the total 
 * bonus amount for that matrix. Uses TwoDimRaggedArrayUtility class to get information about
 * the matrix and assigns bonuses to each store. 
 * Due: 12/3/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Nathaniel Schuknecht
*/

public class HolidayBonus {

	private static final double MAX_BONUS = 5000;
	private static final double OTHER_BONUS	= 2000;
	private static final double MIN_BONUS = 1000;
	
	//Calculates the holiday bonus for each row in the matrix
	public static double[] calculateHolidayBonus(double[][] data) {
		
		double[] toRet = new double[data.length];
		
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				
				//Find min and max for each column
			   	double min = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);
				double max = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
				
				if(data[row][col] > 0) {
					
					//Assign bonus to each element
					if(min == max || data[row][col] == max)
						toRet[row] += MAX_BONUS;
					else if(data[row][col] == min) 
						toRet[row] += MIN_BONUS;
					else	
						toRet[row] += OTHER_BONUS;
				}
			}
		}
		
		return toRet;
	}
	
	//Returns the sum of all bonuses
	public static double calculateTotalHolidayBonus(double[][] data) {
		double total = 0;
		
		for(double bonus : calculateHolidayBonus(data))
			total+= bonus;
		
		return total;
	}
}
