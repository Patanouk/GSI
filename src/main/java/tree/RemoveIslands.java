package tree;

import java.util.Arrays;

//https://www.youtube.com/watch?v=4tYoVx0QoN0
public class RemoveIslands {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1},
        };
        int[][] matrixNoIslands = removeIslands(matrix);
        for (int[] array : matrixNoIslands) {
            System.out.println(Arrays.toString(array));
        }
    }


    public static int[][] removeIslands(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }

        boolean[][] blackPixelsToKeep = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix, blackPixelsToKeep, i, 0);
            dfs(matrix, blackPixelsToKeep, i, matrix[0].length - 1);
        }

        for (int j = 0; j < matrix[0].length; j++) {
            dfs(matrix, blackPixelsToKeep, 0, j);
            dfs(matrix, blackPixelsToKeep, matrix.length - 1, j);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && blackPixelsToKeep[i][j] == false) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    private static void dfs(int[][] matrix, boolean[][] keep, int row, int column) {
        if (row < 0 || row >= matrix.length || column < 0 || column >= matrix[0].length) {
            return;
        }

        if (keep[row][column] || matrix[row][column] == 0) {
            return;
        }

        keep[row][column] = true;

        dfs(matrix, keep, row - 1, column);
        dfs(matrix, keep, row + 1, column);
        dfs(matrix, keep, row, column - 1);
        dfs(matrix, keep, row, column + 1);
    }
}
