public class Player {
    private int row;
    private int col;

    public Player(int startRow, int startCol) {
        setPosition(startRow, startCol);
    }

    public void tryMove(int rowDelta, int colDelta, Maze maze) {
        int nextRow = row + rowDelta;
        int nextCol = col + colDelta;
        if (maze.canMoveTo(nextRow, nextCol)) {
            row = nextRow;
            col = nextCol;
        }
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
