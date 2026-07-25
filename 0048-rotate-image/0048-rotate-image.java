class Solution {
   public static int[][] rotate(int[][] matrix){
          int temp[][] = new int[matrix.length][matrix[0].length];
          int k=0,x;
          for (int i = 0; i<matrix.length ;i++) {
            x=0;
            for (int j = matrix.length-1; j >=0; j--) {
                temp[k][x] = matrix[j][i];
                x++;
            }
            k++;
        }
        for (int l = 0; l < matrix.length; l++) {
            for (int m = 0; m < matrix[0].length; m++) {
                matrix[l][m] = temp[l][m];
            }
        }
        return matrix;
    }
    public static void printarr( int[][] matrix){
          for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        printarr(rotate(matrix));
    }
}