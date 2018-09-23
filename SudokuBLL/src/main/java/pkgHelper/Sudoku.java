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
		int region = row/iSqrtSize * iSqrtSize + col/iSqrtSize;
		return getRegion(region);
		
	}
	public boolean isPartialSudoku() {
		boolean pS = true;
		super.setbIgnoreZero(true);
		if(!super.ContainsZero()) {
			pS = false;
		}
		for(int i = 0;i<super.getLatinSquare().length;i++) {
			if(super.hasDuplicates(super.getRow(i))) {
				pS = false;
				break;
			}
		}
		for(int j = 0; j<super.getLatinSquare().length;j++) {
			if(super.hasDuplicates(super.getColumn(j))) {
				pS = false;
				break;
			}
		}
		for(int k = 0;k<super.getLatinSquare().length;k++) {
			if(super.hasDuplicates(getRegion(k))) {
				pS = false;
				break;
			}
		}
		return pS;
	}
	public boolean isSudoku() {
		boolean answer = true;
		super.setbIgnoreZero(false);
		if(!super.isLatinSquare()) {
			answer = false;
		}
		for(int k = 0;k<super.getLatinSquare().length;k++) {
			if(super.hasDuplicates(getRegion(k))) {
				answer = false;
				break;
			}
		}
		for(int j = 0; j<super.getLatinSquare().length;j++) {
			if(!super.hasAllValues(getRegion(j), super.getRow(1))) {
				answer = false;
				break;
			}
		}
		return answer;
		
	}
	public boolean isValidValue(int iRow, int iCol, int iValue) {

		boolean isValidValue = true;
		
		//iValue is only valid if between 1 and iSize
		if (iValue > iSize || iValue < 1) {
			isValidValue = false;
			return isValidValue;
		}
		
		//iValue is not valid if the specified location already has an assigned value besides 0
		if (getRow(iRow)[iCol] >= 1) {
			isValidValue = false;
			return isValidValue;
		}
		
		for (int i = 0; i<super.getRow(iRow).length;i++)
			if (getRow(iRow)[i] == iValue) {
			isValidValue = false;
			return isValidValue;
			}
			
		for (int i = 0; i<super.getColumn(iCol).length;i++)
			if (getColumn(iCol)[i] == iValue) {
			isValidValue = false;
			return isValidValue;
			}
			
		for (int i = 0; i<getRegion(iRow, iCol).length;i++)
			if (getRegion(iRow, iCol)[i] == iValue) {
			isValidValue = false;
			return isValidValue;
			}


		return isValidValue;

	}


	
}
