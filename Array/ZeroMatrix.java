/*
	Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
*/

public class ZeroMatrix
{

	static void setZero(int[][] matrix)
	{

		boolean[] row = new boolean[matrix.length];		
		boolean[] col = new boolean[matrix[0].length];
		
	
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				if(matrix[i][j]==0)
				{
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for(int i = 0; i < row.length; i++)
		{
			if(row[i])
			{
				nullifyRow(matrix, i);
			}
		}

		for(int j = 0; j < col.length; j++)
		{
			if(col[j])
			{
				nullifyCol(matrix, j);
			}
		}

		printMatrix(matrix);

		
	}

	static void nullifyRow(int[][] matrix, int row)
	{
		for(int i = 0; i < matrix[0].length; i++)
		{
			matrix[row][i] = 0;
		}

	}

	static void nullifyCol(int[][] matrix, int col)
	{
		for(int j = 0; j < matrix.length; j++)
		{
			matrix[j][col] = 0;
		}
	}

	static void printMatrix(int[][] matrix)
	{
		for(int row = 0 ; row < matrix.length; row++)
		{
			for(int col = 0; col<matrix[0].length;col++)
			{
				System.out.print(matrix[row][col]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		int[][] matrix = {{1,9,4,6},{3,2,5,1},{5,0,4,2},{5,2,3,6}};
		System.out.println("Given Matrix: ");
		printMatrix(matrix);
		System.out.println("Output Matrix: ");
		setZero(matrix);
	}

}