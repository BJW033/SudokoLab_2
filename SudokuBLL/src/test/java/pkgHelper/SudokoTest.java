package pkgHelper;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokoTest {

	@Test
	public void GetRegion() {
		int[][] myArray = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
		Sudoku test = new Sudoku(myArray);
		int[] answer = {1,2,1,2};
		assertArrayEquals(answer,test.getRegion(0));
	}

}
