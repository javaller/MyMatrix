

public class Matrix {
	private MatrixRow[] rows;
	private Integer rowsCount;
	private Integer columnsCount;

	public Matrix(MatrixRow[] rows, Integer rowsCount, Integer columnsCount) {
		this.rows = rows;
		this.rowsCount = rowsCount;
		this.columnsCount = columnsCount;
	}
	
	public void printMatrix(){
		System.out.println("Matrix");
		for (int rowPosition = 0; rowPosition < rowsCount; rowPosition++) {
			System.out.println();
			for (int colPosition = 0; colPosition < columnsCount; colPosition++) {
				System.out.print(getRows()[rowPosition].getValue(colPosition)+" ");
			}
		}
		System.out.println("\n");
	}

	public Integer getRowsCount() {
		return rowsCount;
	}

	public Integer getColumnsCount() {
		return columnsCount;
	}

	public MatrixRow[] getRows() {
		return rows;
	}
	
}
