public class Pathfinding {
  public static void main(String[] args) {
    System.out.println("Pathfinding.java says: Hello World");

    Board mainBoard = new Board(16, 16);

    mainBoard.displayGrid();
  }
}

class Board {
  String[][] grid;

  //CLASS CONSTRUCTOR
  public Board(int nRows, int nCols) {
    grid = new String[nRows][nCols];

    for (String[] row : grid) {
      for (int i = 0; i < row.length; i++) {
        row[i] = "O";
      }
    }
  }

  //DISPLAY GRID METHOD
  public void displayGrid() {
    for (String[] row : grid) {
      for (String space : row) {
        System.out.print(space);
        System.out.print(" ");
      }
      System.out.println("");
    }
  }
}

class Piece {
  
}