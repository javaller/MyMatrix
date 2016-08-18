

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class SparseMatrix implements SparseMatrixSupport<Matrix> {
    
	public SparseMatrix(){}
	
	@Override
	public Stream<Integer> toStream(Matrix matrix) {
		List<Integer> data = new ArrayList<Integer>();
		data.add(matrix.getRowsCount());
		data.add(matrix.getColumnsCount());
		MatrixRow[] rows = matrix.getRows();
		for (MatrixRow row : rows) {
			for (int column = 0; column < matrix.getColumnsCount(); column++) {
				data.add(row.getValue(column));
			}
		}
		return data.stream();
	}

	@Override
	public Matrix fromStream(Stream<Integer> stream) {
		Iterator<Integer> iter = stream.iterator();
		Integer rowCount = iter.next();
		Integer columnCount = iter.next();
		MatrixRow[] rows = new MatrixRow[rowCount];
		for (int rowPosition = 0; rowPosition < rowCount; rowPosition++) {
			rows[rowPosition] = new MatrixRow();
			for (int colPosition = 0; colPosition < columnCount; colPosition++) {
				Integer value = iter.next();
				if (value.compareTo(0) != 0) {
					rows[rowPosition].addValue(value, colPosition);
				}
			}
		}

		return new Matrix(rows, rowCount, columnCount);
	}

	@Override
	public Matrix multiply(Matrix first, Matrix second) {
		if (canMatrixesBeMultiplied(first, second)) {

			Integer rowCount = first.getRowsCount();
			Integer columnCount = second.getColumnsCount();
			MatrixRow[] rows = new MatrixRow[rowCount];
			for (int rowPosition = 0; rowPosition < rowCount; rowPosition++) {
				rows[rowPosition] = new MatrixRow();
				for (int colPosition = 0; colPosition < columnCount; colPosition++) {
					Integer newValue = getValueOfMultiplication(rowPosition, colPosition, first, second);
					if (newValue.compareTo(0) != 0) {
						rows[rowPosition].addValue(newValue, colPosition);
					}
				}
			}
			
			return new Matrix(rows,rowCount,columnCount);
		}
		return null;
	}

	private boolean canMatrixesBeMultiplied(Matrix first, Matrix second) {
		if (!(first.getColumnsCount().equals(second.getRowsCount()))) {
			System.out.println("Умножение невозможно. Измените размерности матриц");
			return false;
		}

		return true;
	}

	private Integer getValueOfMultiplication(int rowIndex, int colIndex, Matrix first, Matrix second) {
		Integer sum = 0;
		for (int i = 0; i < first.getColumnsCount(); i++) {
			Integer firstMatrixValue = first.getRows()[rowIndex].getValue(i);
			Integer secondMatrixValue = second.getRows()[i].getValue(colIndex);
			if (firstMatrixValue.compareTo(0) != 0 && secondMatrixValue.compareTo(0) != 0) {
				sum = sum + firstMatrixValue * secondMatrixValue;
			}
		}
		return sum;
	}

}
