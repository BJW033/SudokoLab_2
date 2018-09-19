package pkgHelper;
import java.math.*;
import java.util.Arrays;
public class Sudoku extends LatinSquare{
	private int iSize;
	private int iSqrtSize;
	
	public Sudoku(int iSize){
		// Make an exception if size is not a perfect square
		super();
		this.iSize = iSize;
		this.iSqrtSize = (int) Math.sqrt(iSize);
	}
	public Sudoku(int[][] puzzle) {
		// Make an exception if size is not a perfect square
		super(puzzle);
		this.iSize = puzzle.length;
		this.iSqrtSize = (int) Math.sqrt(iSize);
	}
	public int[][] getPuzzle() {
		return super.getLatinSquare();
	}
	public int[] getRegion(int r) {
		int[] answer = new int[iSize];
		int[][] LS= super.getLatinSquare();
		int lowRow = r-r%iSqrtSize;
		int lowCol = r % iSqrtSize * r;
		int i = 0;
		for(int j = lowRow;j<lowRow+iSqrtSize;j++) {
			for(int k = lowCol;k<lowCol+iSqrtSize;k++) {
				answer[i]= LS[j][k];
				i++;
			}
		
		}
		return answer;
		}
	public int[] getRegion(int row, int col) {
		int region = 0;
		int[] answer = new int[iSize];
		
		return answer;
		
	}
	
}
