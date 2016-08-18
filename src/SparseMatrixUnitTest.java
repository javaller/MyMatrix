

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SparseMatrixUnitTest {

	private static Stream<Integer> inputStreamA;
	private static Stream<Integer> inputStreamB;
	private static Matrix matrixA1;
	private static Matrix matrixB1;
	private static Matrix matrixC1;
	private static Matrix matrixA2;
	private static Matrix matrixB2;
	private static Matrix matrixC2;

	private static SparseMatrix sparseMatrix = new SparseMatrix();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
		setUpStreamA();
		setUpStreamB();

		Integer rowCountA1 = 5;
		Integer columnCountA1 = 6;
		MatrixRow[] rowsA1 = new MatrixRow[rowCountA1];
		rowsA1[0] = new MatrixRow(new Integer[] { 1, 2, 8 }, new Integer[] { 0, 3, 5 });
		rowsA1[1] = new MatrixRow(new Integer[] { 3, 4, 5 }, new Integer[] { 0, 1, 3 });
		rowsA1[2] = new MatrixRow(new Integer[] { 6, 7, 8, 9 }, new Integer[] { 0, 2, 3, 4 });
		rowsA1[3] = new MatrixRow(new Integer[] { 10, 11, 1 }, new Integer[] { 2, 3, 5 });
		rowsA1[4] = new MatrixRow(new Integer[] { 12, 3 }, new Integer[] { 4, 5 });
		matrixA1 = new Matrix(rowsA1, rowCountA1, columnCountA1);

		Integer rowCountB1 = 6;
		Integer columnCountB1 = 5;
		MatrixRow[] rowsB1 = new MatrixRow[rowCountB1];
		rowsB1[0] = new MatrixRow(new Integer[] { 7, 1 }, new Integer[] { 1, 4 });
		rowsB1[1] = new MatrixRow(new Integer[] { 2, 10 }, new Integer[] { 1, 2 });
		rowsB1[2] = new MatrixRow(new Integer[] { 6, 7, 8, 9 }, new Integer[] { 0, 2, 3, 4 });
		rowsB1[3] = new MatrixRow(new Integer[] { 4, 1, 1 }, new Integer[] { 2, 3, 4 });
		rowsB1[4] = new MatrixRow(new Integer[] { 4, 2 }, new Integer[] { 1, 2 });
		rowsB1[5] = new MatrixRow(new Integer[] { 5, 5 }, new Integer[] { 2, 3 });
		matrixB1 = new Matrix(rowsB1, rowCountB1, columnCountB1);
		
		
		Integer rowCountC1 = 5;
		Integer columnCountC1 = 5;
		MatrixRow[] rowsC1 = new MatrixRow[rowCountC1];
		rowsC1[0] = new MatrixRow(new Integer[] {7,48, 42,3}, new Integer[] {1,2,3,4});
		rowsC1[1] = new MatrixRow(new Integer[] {29,60,5,8}, new Integer[] {1,2,3,4});
		rowsC1[2] = new MatrixRow(new Integer[] {42,78,99,64,77}, new Integer[] {0,1,2,3,4});
		rowsC1[3] = new MatrixRow(new Integer[] {60,119,96,101}, new Integer[] {0,2,3,4});
		rowsC1[4] = new MatrixRow(new Integer[] {48,39,15}, new Integer[] {1,2,3});
		matrixC1 = new Matrix(rowsC1, rowCountC1, columnCountC1);

		Integer rowCountA2 = 5;
		Integer columnCountA2 = 6;
		MatrixRow[] rowsA2 = new MatrixRow[rowCountA2];
		rowsA2[0] = new MatrixRow(new Integer[] { 1, 2, 8 }, new Integer[] { 0, 3, 5 });
		rowsA2[1] = new MatrixRow(new Integer[] { 3, 4, 5 }, new Integer[] { 0, 1, 3 });
		rowsA2[2] = new MatrixRow(new Integer[] { 6, 7, 8, 9 }, new Integer[] { 0, 2, 3, 4 });
		rowsA2[3] = new MatrixRow(new Integer[] { 10, 11, 1 }, new Integer[] { 2, 3, 5 });
		rowsA2[4] = new MatrixRow(new Integer[] { 12, 3 }, new Integer[] { 4, 5 });
		matrixA2 = new Matrix(rowsA2, rowCountA2, columnCountA2);

		Integer rowCountB2 = 6;
		Integer columnCountB2 = 5;
		MatrixRow[] rowsB2 = new MatrixRow[rowCountB2];
		rowsB2[0] = new MatrixRow(new Integer[] { 7, 1 }, new Integer[] { 1, 4 });
		rowsB2[1] = new MatrixRow(new Integer[] { 2, 10 }, new Integer[] { 1, 2 });
		rowsB2[2] = new MatrixRow(new Integer[] { 6, 7, 8, 9 }, new Integer[] { 0, 2, 3, 4 });
		rowsB2[3] = new MatrixRow(new Integer[] { }, new Integer[] { });
		rowsB2[4] = new MatrixRow(new Integer[] { 4, 2 }, new Integer[] { 1, 2 });
		rowsB2[5] = new MatrixRow(new Integer[] { 5, 5 }, new Integer[] { 2, 3 });
		matrixB2 = new Matrix(rowsB2, rowCountB2, columnCountB2);
		
		
		Integer rowCountC2 = 5;
		Integer columnCountC2 = 5;
		MatrixRow[] rowsC2 = new MatrixRow[rowCountC2];
		rowsC2[0] = new MatrixRow(new Integer[] {7,40, 40,1}, new Integer[] {1,2,3,4});
		rowsC2[1] = new MatrixRow(new Integer[] {29,40,3}, new Integer[] {1,2,4});
		rowsC2[2] = new MatrixRow(new Integer[] {42,78,67,56,69}, new Integer[] {0,1,2,3,4});
		rowsC2[3] = new MatrixRow(new Integer[] {60,75,85,90}, new Integer[] {0,2,3,4});
		rowsC2[4] = new MatrixRow(new Integer[] {48,39,15}, new Integer[] {1,2,3});
		matrixC2 = new Matrix(rowsC2, rowCountC2, columnCountC2);
		
	}

	@After
	public void tearDown() throws Exception {
		inputStreamA = null;
		inputStreamB = null;
		matrixA1 = null;
		matrixB1 = null;
		matrixA2 = null;
		matrixB2 = null;
	}

	@Test
	public void testToStream() {
		System.out.println("\nSTART TEST testToStream");
		
		System.out.println("Given matrix");
		matrixA1.printMatrix();

		Stream<Integer> resultStream = sparseMatrix.toStream(matrixA1);
		System.out.println("\nResult stream");
		resultStream.forEach((n) -> System.out.print(n + " "));
		
		System.out.println("\nGiven stream");
		inputStreamA.forEach((n) -> System.out.print(n + " "));

		resultStream = sparseMatrix.toStream(matrixA1);
		setUpStreamA();
		Iterator<Integer> iter = resultStream.iterator();
		Iterator<Integer> iterA = inputStreamA.iterator();

		while (iter.hasNext() && iterA.hasNext()) {
			assertEquals(iterA.next(), iter.next());
		}
		
		System.out.println("\nEND TEST testToStream");

	}

	@Test
	public void testFromStream() {
		System.out.println("\nSTART TEST testFromStream");
		
		System.out.println("\nGiven stream");
		inputStreamA.forEach((n) -> System.out.print(n + " "));
		setUpStreamA();
		
		Matrix resultMatrix = sparseMatrix.fromStream(inputStreamA);
		System.out.println("\nResult matrix");
		resultMatrix.printMatrix();
		
		System.out.println("\nExpected matrix");
		matrixA1.printMatrix();
		
		for (int rowPosition = 0; rowPosition < resultMatrix.getRowsCount(); rowPosition++) {
			for (int colPosition = 0; colPosition <  resultMatrix.getColumnsCount(); colPosition++) {
				Integer resultMatixValue = resultMatrix.getRows()[rowPosition].getValue(colPosition);
				Integer expectedMatrixValue =matrixA1.getRows()[rowPosition].getValue(colPosition) ;
				assertEquals("expected value at position["+rowPosition+","+colPosition+"] "+expectedMatrixValue+"not equals actual value"+resultMatixValue,expectedMatrixValue,resultMatixValue);
			}
		}
		
		System.out.println("\nEND TEST testFromStream");
		
	}

	@Test
	public void testMultiply1() {
		System.out.println("\nSTART TEST1 testMultiply");
		
		System.out.println("Given matrix A1");
		matrixA1.printMatrix();
		
		System.out.println("Given matrix B1");
		matrixB1.printMatrix();
		
		Matrix resultMatrix1 = sparseMatrix.multiply(matrixA1, matrixB1);
		System.out.println("Result matrix C1");
		resultMatrix1.printMatrix();
		
		System.out.println("Expected matrix");
		matrixC1.printMatrix();
		
		for (int rowPosition = 0; rowPosition < resultMatrix1.getRowsCount(); rowPosition++) {
			for (int colPosition = 0; colPosition <  resultMatrix1.getColumnsCount(); colPosition++) {
				Integer resultMatixValue = resultMatrix1.getRows()[rowPosition].getValue(colPosition);
				Integer expectedMatrixValue =matrixC1.getRows()[rowPosition].getValue(colPosition) ;
				assertEquals("expected value at position["+rowPosition+","+colPosition+"] "+expectedMatrixValue+"not equals actual value"+resultMatixValue,expectedMatrixValue,resultMatixValue);
			}
		}
		
		System.out.println("\nEND TEST1 testMultiply");
		

	}

	@Test
	public void testMultiply2() {
		
		System.out.println("\nSTART TEST2 testMultiply");
		
		System.out.println("Given matrix A2");
		matrixA2.printMatrix();
		
		System.out.println("Given matrix B2");
		matrixB2.printMatrix();
		
		Matrix resultMatrix2 = sparseMatrix.multiply(matrixA2, matrixB2);
		System.out.println("Result matrix C2");
		resultMatrix2.printMatrix();
		
		System.out.println("Expected matrix");
		matrixC2.printMatrix();
		
		for (int rowPosition = 0; rowPosition < resultMatrix2.getRowsCount(); rowPosition++) {
			for (int colPosition = 0; colPosition <  resultMatrix2.getColumnsCount(); colPosition++) {
				Integer resultMatixValue = resultMatrix2.getRows()[rowPosition].getValue(colPosition);
				Integer expectedMatrixValue =matrixC2.getRows()[rowPosition].getValue(colPosition) ;
				assertEquals("expected value at position["+rowPosition+","+colPosition+"] "+expectedMatrixValue+"not equals actual value"+resultMatixValue,expectedMatrixValue,resultMatixValue);
			}
		}
		
		System.out.println("\nEND TEST2 testMultiply");
	}
	
	private void setUpStreamA() {
		ArrayList<Integer> dataValueA = new ArrayList<>(Arrays.asList(
				// 5 rows, 6 columns matrix
				5, 6, 
				   1, 0, 0,  2,  0,  8, 
				   3, 4, 0,  5,  0,  0, 
				   6, 0, 7,  8,  9,  0, 
				   0, 0, 10, 11, 0,  1, 
				   0, 0,  0,  0, 12, 3));

		inputStreamA = dataValueA.stream();
	}

	private void setUpStreamB() {
		ArrayList<Integer> dataValueB = new ArrayList<>(Arrays.asList(
				// 6 rows, 5 columns matrix
				6, 5, 
				      0, 7, 0,  0, 1, 
				      0, 2, 10, 0, 0, 
				      6, 0, 7,  8, 9, 
				      0, 0, 4,  1, 1, 
				      0, 4, 2,  0, 0, 
				      0, 0, 5,  5, 0));

		inputStreamB = dataValueB.stream();
	}

}
