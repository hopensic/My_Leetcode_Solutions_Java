package leetcode;

public class MaxIncreaseToKeepCitySkyline {

  public static void main(String[] args) {
    int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
    //int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}};
    System.out.println(new MaxIncreaseToKeepCitySkyline().maxIncreaseKeepingSkyline(grid));
  }

  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int rowLen = grid.length;
    int colLen = grid[0].length;
    int maxRow[] = new int[rowLen];
    int maxCol[] = new int[colLen];
    for (int i = 0; i < rowLen; i++) {
      int temp = 0;
      for (int j = 0; j < colLen; j++) temp = grid[i][j] > temp ? grid[i][j] : temp;
      maxRow[i] = temp;
    }
    for (int j = 0; j < colLen; j++) {
      int temp = 0;
      for (int i = 0; i < rowLen; i++) temp = grid[i][j] > temp ? grid[i][j] : temp;
      maxCol[j] = temp;
    }
    int sum = 0;
    for (int i = 0; i < rowLen; i++) {
      for (int j = 0; j < colLen; j++) {
        int temp = maxRow[i] > maxCol[j] ? maxCol[j] : maxRow[i];
        sum += temp > grid[i][j] ? temp - grid[i][j] : 0;
      }
    }

    return sum;
  }
}
