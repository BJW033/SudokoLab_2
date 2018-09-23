package pkgHelper;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokoTest {

	@Test
	public void GetRegion() throws Exception{
		int[][] myArray = {{1,2,3,4},
				{2,3,4,1},{3,4,1,2},{4,1,2,3}};
		Sudoku test = new Sudoku(myArray);
		int[] answer = {1,2,2,3};
		int[] answer1 = {3,4,4,1};
		assertArrayEquals(answer,test.getRegion(0));
		assertArrayEquals(answer1,test.getRegion(1));
	}
	@Test
	public void GetRegionTest() throws Exception{
		int[][] myArray = {{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}};
		Sudoku test = new Sudoku(myArray);
		int[] answer = {1,2,3,1,2,3,1,2,3};
		int[] answer2 = {4,5,6,4,5,6,4,5,6};
		int[] answer1 = {7,8,9,7,8,9,7,8,9};
		assertArrayEquals(answer,test.getRegion(0, 0));
		assertArrayEquals(answer1,test.getRegion(1, 7));
		assertArrayEquals(answer,test.getRegion(3, 2));
		assertArrayEquals(answer2,test.getRegion(3, 3));
		assertArrayEquals(answer1,test.getRegion(3, 7));
	}
	
	@Test
	public void IsPartialSudokuTest() throws Exception{
		int[][] myArray = {{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3}};
		int[][] myArray2 = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		int[][] myArray3 = {{1,4,0,2},{3,2,4,1},{4,1,2,3},{2,3,1,4}};

		Sudoku test1 = new Sudoku(myArray);
		Sudoku test2 = new Sudoku(myArray2);
		Sudoku test3 = new Sudoku(myArray3);
		assertFalse(test1.isPartialSudoku());
		assertTrue(test2.isPartialSudoku());
		assertTrue(test3.isPartialSudoku());
	}
	@Test
	public void IsSudokuTest() throws Exception{
		int[][] myArray = {{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3}};
		int[][] myArray2 = {{1,4,0,2},{3,2,4,1},{4,1,2,3},{2,3,1,4}};
		int[][] myArray3 = {{1,4,3,2},{3,2,4,1},{4,1,2,3},{2,3,1,4}};

		Sudoku test1 = new Sudoku(myArray);
		Sudoku test2 = new Sudoku(myArray2);
		Sudoku test3 = new Sudoku(myArray3);
		assertFalse(test1.isSudoku());
		assertFalse(test2.isSudoku());
		assertTrue(test3.isSudoku());


	}
	@Test
	public void IsValidValueTest() throws Exception{
		int[][] myArray = {{0,0,5,0,0,0,0,1,0},
						   {8,0,9,0,1,0,2,0,7},
						   {0,6,3,0,0,2,0,0,8},	
						   {0,0,0,2,3,8,0,0,9},
						   {3,9,0,6,0,4,0,8,5},
						   {4,0,0,9,5,1,0,0,0},
						   {9,0,0,8,0,0,5,2,0},
						   {7,0,6,0,2,0,8,0,3},
						   {0,2,0,0,0,0,6,0,0}};
		Sudoku test = new Sudoku(myArray);
		assertFalse(test.isValidValue(3,1,8));
		assertFalse(test.isValidValue(1,6,7));
		assertFalse(test.isValidValue(7,7,5));
		assertTrue(test.isValidValue(2,0,1));
		assertTrue(test.isValidValue(7,7,9));
	}


}
