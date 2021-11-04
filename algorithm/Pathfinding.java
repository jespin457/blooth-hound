import java.lang.Math;

public class Pathfinding {
  public static void main(String[] args) {
    System.out.println("Pathfinding.java says: Hello World");

    Board mainBoard = new Board(16, 16);

    mainBoard.displayGrid();
  }
}

class Board {
  String[][] grid;
  int nOfRows;
  int nOfCols;

  //CLASS CONSTRUCTOR
  public Board(int nRows, int nCols) {
    grid = new String[nRows][nCols];
    nOfRows = nRows;
    nOfCols = nCols;

    for (String[] row : grid) {
      for (int i = 0; i < row.length; i++) {
        row[i] = "O";
      }
    }

    this.randomizeStartBorder();
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

  //RANDOMIZES THE STARTING POINT OF THE PIECE ON A BORDER SPACE
  //START IS INDICATED BY S
  private void randomizeStartBorder() {
    int start_x = (int) (Math.random() * (nOfCols - 1));
    int start_y = (int) (Math.random() * (nOfRows - 1));

    grid[start_y][start_x] = "S";
  }
}

class Piece {
  
}