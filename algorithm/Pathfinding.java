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
    double random1 = Math.random(); //double between 0.0 and 1.0
    double random2;

    int xStart;
    int yStart;

    if (random1 < 0.5) {
      xStart = (int) (Math.random() * (nOfCols - 1));
      random2 = Math.random();
      if (random2 < 0.5) {
        yStart = 0;
      } else {
        yStart = nOfRows - 1;
      }
    } else {
      yStart = (int) (Math.random() * (nOfRows - 1));
      random2 = Math.random();
      if (random2 < 0.5) {
        xStart = 0;
      } else {
        xStart = nOfCols - 1;
      }
    }

    grid[yStart][xStart] = "S";
  }
}

class Piece {
  
}