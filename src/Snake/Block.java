package Snake;

import javafx.scene.shape.Rectangle;

/**
 * Defines a Block within the grid.
 * @Author Afaq Anwar
 * @Version 05/06/2019
 */
public class Block extends Rectangle {
    private int xLoc;
    private int yLoc;
    // Old position is stored to move all blocks.
    Block previousBlock;
    private int oldXLoc;
    private int oldYLoc;

    private static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    private int direction = LEFT;

    /**
     * Main Constructor that builds off the rectangle.
     * @param xLoc X position of the Block within the grid.
     * @param yLoc Y position of the Block within the grid.
     * @param previousBlock The old Block.
     */
    public Block(int xLoc, int yLoc, Block previousBlock) {
        super(Application.blockSize, Application.blockSize);
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.previousBlock = previousBlock;
        // Translated based off each block size to keep grid consistency.
        setTranslateX(xLoc * Application.blockSize);
        setTranslateY(yLoc * Application.blockSize);
    }

    /**
     * Updates the movement based on the direction of the Snake.
     */
    public void update() {
        if (previousBlock == null) {
            switch (direction) {
                case UP:
                    this.move(UP);
                    break;
                case RIGHT:
                    this.move(RIGHT);
                    break;
                case DOWN:
                    this.move(DOWN);
                    break;
                case LEFT:
                    this.move(LEFT);
                    break;
            }
        }
    }

    /**
     * Changes the position of the Snake.
     * @param Direction Integer that represents the direction.
     *                  UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3
     */
    public void move(int Direction) {
       if (direction == UP) {
           yLoc--;
       } else if (direction == RIGHT) {
           xLoc++;
       } else if (direction == DOWN) {
           yLoc++;
       } else if (direction == LEFT) {
           xLoc--;
       }
    }
}
