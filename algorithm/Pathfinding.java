import java.lang.Math;

public class Pathfinding {
  public static void main(String[] args) {
    System.out.println("Pathfinding.java says: Hello World");

    Board mainBoard = new Board(10, 10);

    mainBoard.displayGrid();
    System.out.println("=========");
    mainBoard.setStartAndFinish(new int[]{2, 2}, new int[]{3, 3});

    mainBoard.displayGrid();

    Piece player = new Piece("&");

    // mainBoard.displayGrid();
    System.out.println("===");

    player.pathfindToFinish(mainBoard);

    mainBoard.displayGrid();
  }
}

class Board {
  String[][] grid;

  int nOfRows; //ACTUAL COUNT
  int nOfCols; //ACTUAL COUNT
  
  int rowStart; //index
  int colStart; //index

  int rowFinish; //index
  int colFinish; //index

  //CLASS CONSTRUCTOR
  public Board(int nRows, int nCols) {
    grid = new String[nRows][nCols];
    nOfRows = nRows;
    nOfCols = nCols;

    for (String[] row : grid) {
      for (int i = 0; i < row.length; i++) {
        row[i] = "o";
      }
    }
  }

  //DISPLAY GRID METHOD
  public void displayGrid() {
    for (String[] row : grid) {
      for (String space : row) {
        System.out.print(space + " ");
      }
      System.out.println("");
    }
  }

  //PROVIDED IN [x, y]
  //NOT INDICIES, ACTUAL COUNTS
  public void setStartAndFinish(int[] start, int[] finish) {
    if (
      start[0] > this.nOfCols || start[1] > this.nOfRows
      ||
      finish[0] > this.nOfCols || finish[1] > this.nOfRows
    ) {
      System.out.println("Error: start or finish coordinates invalid.");
    } else {
      this.rowStart = start[0] - 1;
      this.colStart = start[1] - 1;
      this.grid[start[0] - 1][start[1] - 1] = "S";

      this.rowFinish = finish[0] - 1;
      this.colFinish = finish[1] - 1;
      this.grid[finish[0] - 1][finish[1] - 1] = "X";
    }
  }

  //RANDOMIZES THE STARTING POINT OF THE PIECE ON A BORDER SPACE
  //START IS INDICATED BY S
  public void randomizeStartOnBorder() {
    double random1 = Math.random(); //double between 0.0 and 1.0
    double random2;

    int xStart;
    int yStart;

    if (random1 < 0.5) {
      xStart = (int) (Math.random() * (nOfCols - 1));
      colStart = xStart;
      random2 = Math.random();
      if (random2 < 0.5) {
        yStart = 0;
        rowStart = yStart;
      } else {
        yStart = nOfRows - 1;
        rowStart = yStart;
      }
    } else {
      yStart = (int) (Math.random() * (nOfRows - 1));
      rowStart = yStart;
      random2 = Math.random();
      if (random2 < 0.5) {
        xStart = 0;
        colStart = xStart;
      } else {
        xStart = nOfCols - 1;
        colStart = xStart;
      }
    }

    grid[yStart][xStart] = "S";
  }

  public void randomizeCornerFinish() {
    int vertMidpoint = (int) Math.ceil((nOfCols+1) / 2) - 1; // -1 due to 0 index
    int horzMidpoint = (int) Math.ceil((nOfRows+1) / 2) - 1;

    if (this.rowStart <= vertMidpoint) {
      rowFinish = nOfRows - 1;
    } else {
      rowFinish = 0;
    }

    if (this.colStart <= horzMidpoint) {
      colFinish = nOfCols - 1;
    } else {
      colFinish = 0;
    }

    this.grid[rowFinish][colFinish] = "X";
  }
}

class Piece {
  String piece;
  int steps = 0;

  int vertSpacesToFinish; //spaces, neg or pos
  int horzSpacesToFinish; //spaces, neg or pos

  String vertDir; // "N" or "S"
  String horzDir; //"W" or "E"

  public Piece(String p) {
    piece = p;
  }

  private void calcCardinalDirections(Board b) {
    vertSpacesToFinish = b.rowStart - b.rowFinish;
    horzSpacesToFinish = b.colFinish - b.colStart;

    System.out.println("Must head " + vertSpacesToFinish + " vertically.");
    System.out.println("Must head " + horzSpacesToFinish + " horizontally.");

    vertDir = (vertSpacesToFinish > 0) ? "N" : "S";
    horzDir = (horzSpacesToFinish > 0) ? "E" : "W";

    System.out.println("Directions: " + vertDir + " and " + horzDir);
  }

  public void pathfindToFinish(Board b) {
    b.grid[b.rowStart][b.colStart] = this.piece;

    this.calcCardinalDirections(b);

    if (this.vertDir == "N") {
      for (int i = 0; i <= this.vertSpacesToFinish; i++) {
        b.grid[b.rowStart - i][b.colStart] = "Λ";
      }
    } else {
      for (int i = 0; i >= this.vertSpacesToFinish; i--) {
        b.grid[b.rowStart - i][b.colStart] = "V";
      }
    }

    if (this.horzDir == "E") {
      System.out.println("horzSpacesToFinish: " + this.horzSpacesToFinish);
      System.out.println("vertSpacesToFinish: " + this.vertSpacesToFinish);
      for (int i = 0; i <= this.horzSpacesToFinish; i++) {
        b.grid[b.rowStart - this.vertSpacesToFinish][b.colStart + i] = ">";
      }
    } else {
      for (int i = 0; i >= this.horzSpacesToFinish; i--) {
        b.grid[b.rowStart - this.vertSpacesToFinish][b.colStart + i] = "<";
      }
    }
  }
}