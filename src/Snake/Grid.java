package Snake;

public class Grid {
    private int rowSize;
    private int colSize;
    private Block[][] gridMap;

    public Grid(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
        gridMap = new Block[rowSize][colSize];
        this.buildMap();
    }

    private void buildMap() {
        for (int x = 0; x < gridMap.length; x++) {
            for (int y = 0; y < gridMap[0].length; y++) {
                if (x == 0 || x == rowSize - 1 || y == 0 || y == colSize - 1) {
                    gridMap[x][y] = new Block(x, y, true, false, false);
                } else {
                    gridMap[x][y] = new Block(x, y, false, false, false);
                }
            }
        }
    }
}
