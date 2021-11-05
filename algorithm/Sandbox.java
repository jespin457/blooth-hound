public class Sandbox {
  public static void main(String[] args) {
    System.out.println("Sandbox.java says: Hello World");

    String[][] grid = new String[4][4];

    for (int nRow = 0; nRow < grid.length; nRow++) {
      for (int nCol = 0; nCol < grid[nRow].length; nCol++) {
        grid[nRow][nCol] = "(" + nRow + ", " + nCol + ")";
      }
    }

    for (String[] row : grid) {
      for (String space : row) {
        System.out.print(space);
      }
      System.out.println("");
    }
  }
}