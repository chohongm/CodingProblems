package code;

import java.util.Arrays;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix =
				{
				  { 5, 1, 9,11},
				  { 2, 4, 8,10},
				  {13, 3, 6, 7},
				  {15,14,12,16}
				};
		rotate(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}
	
    public static void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        // 1. transpose
        for (int i = 0; i < r; i++) {
            for (int j = i + 1; j < c; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                
            }
        }
        
        // 2. flip each row
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][c - 1 - j];
                matrix[i][c - 1 - j] = temp;
            }
        }
    }

}
