package pkgHelper;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokoTest {

	@Test
	public void GetRegion() {
		int[][] myArray = {{1,2,3,4},
				{2,3,4,1},{3,4,1,2},{4,1,2,3}};
		Sudoku test = new Sudoku(myArray);
		int[] answer = {1,2,2,3};
		int[] answer1 = {3,4,4,1};
		assertArrayEquals(answer,test.getRegion(0));
		assertArrayEquals(answer1,test.getRegion(1));
	}
	@Test
	public void GetRegionTest() {
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

}
