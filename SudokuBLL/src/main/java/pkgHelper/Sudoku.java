package pkgHelper;
import java.math.*;
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
	protected int[][] getPuzzle() {
		return super.getLatinSquare();
	}
	
}
