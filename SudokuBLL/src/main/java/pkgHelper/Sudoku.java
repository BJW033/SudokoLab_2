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
		int lowCol = r % iSqrtSize * iSqrtSize;
		System.out.println("Starting col = " +lowCol);
		int i = 0;
		for(int j = lowRow;j<lowRow+iSqrtSize;j++) {
			for(int k = lowCol;k<lowCol+iSqrtSize;k++) {
				answer[i]= LS[j][k];
				i++;
			}
		
		}System.out.println("the array is " +Arrays.toString(answer));
		return answer;
		}
	public int[] getRegion(int row, int col) {
		int region = 0;
		boolean c = true;
		boolean r = false;
		int x = 0;
		int y = 0;
		int low = 0;
		int high = iSqrtSize;
		while(c) {
			if(col>=low && col<high) {
				System.out.println("Column set Found x= " +x);
				low = 0;
				high  = iSqrtSize;
				while(true) {
					if(row>=low && row<high) {
						region = x +y*iSqrtSize;
						c = false;
						r = true;
						break;
					}
					y++;
					low+=iSqrtSize;
					high+=iSqrtSize;
					
				}
			}
			if(r) {
				break;
			}
			System.out.println("End of first while: X = "+x+ " low = "+low+" high = "+high);
			x++;
			low+=iSqrtSize;
			high+=iSqrtSize;
		}
		System.out.println("the region is "+region);
		return getRegion(region);
		
	}
	
}
