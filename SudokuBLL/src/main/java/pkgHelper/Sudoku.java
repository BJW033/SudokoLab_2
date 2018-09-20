package pkgHelper;
import java.math.*;
import java.util.Arrays;
public class Sudoku extends LatinSquare{
	private int iSize;
	private int iSqrtSize;
	
	public Sudoku(int iSize) throws Exception{
		super();this.iSize = iSize;
		try {
			if((Math.sqrt(iSize) - Math.floor(Math.sqrt(iSize)))!=0) {
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		
		this.iSqrtSize = (int) Math.sqrt(iSize);
		
	}
	public Sudoku(int[][] puzzle) throws Exception{
		super(puzzle);
		this.iSize = puzzle.length;
		this.iSqrtSize = (int) Math.sqrt(iSize);
		try {
			if((Math.sqrt(iSize) - Math.floor(Math.sqrt(iSize)))!=0) {
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	public int[][] getPuzzle() {
		return super.getLatinSquare();
	}
	public int[] getRegion(int r) {
		int[] answer = new int[iSize];
		
		int[][] LS= super.getLatinSquare();
		int lowRow = r-r%iSqrtSize;
		int lowCol = r % iSqrtSize * iSqrtSize;
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
		int region = 0;int cCount = 0;int rCount = 0;
		boolean colSpan = true;boolean rowSpan = false;
		int low = 0;int high = iSqrtSize;
		while(colSpan) {
			if(col>=low && col<high) {
				low = 0;
				high  = iSqrtSize;
				while(true) {
					if(row>=low && row<high) {
						region = cCount +rCount*iSqrtSize;
						colSpan = false;
						rowSpan = true;
						break;
					}
					rCount++;
					low+=iSqrtSize;
					high+=iSqrtSize;
					
				}
			}
			if(rowSpan) {
				break;
			}
			cCount++;
			low+=iSqrtSize;
			high+=iSqrtSize;
		}
		return getRegion(region);
		
	}
	
}
