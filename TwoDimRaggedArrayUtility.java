/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This class permits getting different types of information based on a jagged matrix
 * passed as a parameter. Can also read and write a matrix to and from a file.
 * Due: 12/3/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Nathaniel Schuknecht
*/

import java.io.*;
import java.util.*;

public final class TwoDimRaggedArrayUtility {

	//Returns the average of all data in the matrix
	public static double getAverage(double[][] data) {
		
		double total = 0;
		int numElements = 0;
		
		for(int row = 0; row < data.length; row++) { 
			for(int col = 0; col < data[row].length; col++) {
			
				total+= data[row][col];
				numElements++;
			}
		}
		
		return total / numElements;
	}
	
	///Returns the sum for all elements in col
	public static double getColumnTotal(double[][] data, int col) {
		
		double total = 0;
		
		for(int row = 0; row < data.length; row++)
			if(col < data[row].length)
				total += data[row][col];
		
		return total;
	}
	
	//Returns the largest element in the matrix
	public static double getHighestInArray(double[][] data) {
		
		double max = Double.MIN_VALUE;
		
		for(int row = 0; row < data.length; row++)
			for(int col = 0; col < data[row].length; col++) 
				if(data[row][col] > max)
					max = data[row][col];
		
		return max;
	}
	
	//Returns the max element in col
	public static double getHighestInColumn(double[][] data, int col) {
		
		double max = Double.MIN_VALUE;
		
		for(int row = 0; row < data.length; row++)
			if(col < data[row].length)
				if(data[row][col] > max)
					max = data[row][col];
		
		return max;
	}
	
	//Returns the index of the max element in col
	public static int getHighestInColumnIndex(double[][] data, int col) {
		
		double max = Double.MIN_VALUE;
		int index = -1;
		
		for(int row = 0; row < data.length; row++)
			if(col < data[row].length && data[row][col] > max) {
				max = data[row][col];
				index = row;
			}
		
		return index;
	}
	
	//Returns the highest element in row
	public static double getHighestInRow(double[][] data, int row) {
		
		double max = Double.MIN_VALUE;
		
		for(int col = 0; col < data[row].length; col++) 
			if(data[row][col] > max)
				max = data[row][col];
		
		return max;
	}
	
	//Returns the index of the highest element in row
	public static int getHighestInRowIndex(double[][] data, int row) {
		
		double max = Double.MIN_VALUE;
		int index = -1;
		
		for(int col = 0; col < data[row].length; col++)
			if(data[row][col] > max) {
				max = data[row][col];
				index = col;
			}
		
		return index;
	}
	
	//Returns the lowest element in the matrix
	public static double getLowestInArray(double[][] data) {
		
		double min = Double.MAX_VALUE;
		
		for(int row = 0; row < data.length; row++)
			for(int col = 0; col < data[row].length; col++) 
				if(data[row][col] < min)
					min = data[row][col];
		
		return min;
	}
	
	//Returns the lowest element in col
	public static double getLowestInColumn(double[][] data, int col) {
		
		double min = Double.MAX_VALUE;
		
		for(int row = 0; row < data.length; row++)
			if(col < data[row].length && data[row][col] < min)
				min = data[row][col];
		
		return min;
	}
	
	//Returns the index of the lowest element in col
	public static int getLowestInColumnIndex(double[][] data, int col) {
		
		double min = Double.MAX_VALUE;
		int index = -1;
		
		for(int row = 0; row < data.length; row++)
			if(col < data[row].length && data[row][col] < min) {
				min = data[row][col];
				index = row;
			}
		
		return index;
	}
	
	//Returns the lowest element in row
	public static double getLowestInRow(double[][] data, int row) {
		
		double min = Double.MAX_VALUE;
		
		for(int col = 0; col < data[row].length; col++)
			if(data[row][col] < min)
				min = data[row][col];
		
		return min;
	}
	
	//Returns the index of the lowest element in row
	public static int getLowestInRowIndex(double[][] data, int row) {
		
		double min = Double.MAX_VALUE;
		int index = -1;
		
		for(int col = 0; col < data[row].length; col++)
			if(data[row][col] < min) {
				min = data[row][col];
				index = col;
			}
		
		return index;
	}
	
	//Returns the total of all elements in row
	public static double getRowTotal(double[][] data, int row) {
		
		double total = 0;
		
		for(int col = 0; col < data[row].length; col++) 
			total+= data[row][col];
		
		return total;
	}
	
	//Returns the sum of all elements in the matrix
	public static double getTotal(double[][] data) {
		
		double total = 0;

		for(int row = 0; row < data.length; row++)
			for(int col = 0; col < data[row].length; col++)
				total+= data[row][col];

		return total;
	}
	
	//Reads the file and returns a matrix from it
	public static double[][] readFile(File file) throws FileNotFoundException{
		
		if(file == null)
			return null;
		
		String[][] temp = new String[10][10];
		Scanner fileIn = new Scanner(file);
		
		//Create temp String matrix to store file text
		int row = 0;
		while(fileIn.hasNextLine() && row < 10) {
			String[] values = fileIn.nextLine().split(" ");
			
			for(int col = 0; col < values.length && col < 10; col++)
				temp[row][col] = values[col];
			
			row++;
		}
		
		fileIn.close();
		
		//Create a jagged matrix if needed and parse values to it
		double[][] toRet = new double[row][];
		for(int newRow = 0; newRow < row; newRow++) {
			
			int col = 0;
			while(col < 10 && temp[newRow][col] != null)
				col++;
			
			toRet[newRow] = new double[col];
			
			//Parse each double from the string matrix to the double matrix
			for(int newCol = 0; newCol < col; newCol ++)
				toRet[newRow][newCol] = Double.parseDouble(temp[newRow][newCol]);
		}
		
		return toRet;
	}
	
	//Writes the data from the matrix to the outputFile
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		
		PrintWriter outFile = new PrintWriter(outputFile);
		
		//Write all data into outputFile
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				outFile.write(data[row][col] + " ");
			}
			outFile.write("\n");
		}
		
		outFile.close();
	}
}
