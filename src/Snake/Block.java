package Snake;

import javafx.scene.shape.Rectangle;

/**
 * Defines a Block within the grid.
 * @Author Afaq Anwar
 * @Version 05/12/2019
 */
public class Block extends Rectangle {
    private int xLoc;
    private int yLoc;
    // Old position is stored to move all blocks.
    private Block previousBlock;
    private int oldXLoc;
    private int oldYLoc;

    public static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    private int direction = LEFT;

    private int maxWidth;
    private int maxHeight;

    /**
     * Main Constructor that builds off the rectangle.
     * @param xLoc X position of the Block within the grid.
     * @param yLoc Y position of the Block within the grid.
     * @param previousBlock The old Block.
     */
    public Block(int xLoc, int yLoc, Block previousBlock, GameField gameField) {
        super(Application.blockSize, Application.blockSize);
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.previousBlock = previousBlock;
        // Translated based off each block size to keep grid consistency.
        setTranslateX(xLoc * Application.blockSize);
        setTranslateY(yLoc * Application.blockSize);
        this.maxWidth = gameField.getActualWidth();
        this.maxHeight = gameField.getActualHeight();
    }

    public int getDirection() { return this.direction; }
    public void setDirection(int direction) { this.direction = direction; }

    /**
     * Updates the movement based on the direction of the Snake.
     */
    public void update() {
        // Properties updated for the previousBlock.
        oldXLoc = xLoc;
        oldYLoc = yLoc;
        // If the head is being controlled.
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
        } else {
            xLoc = previousBlock.oldXLoc;
            yLoc = previousBlock.oldYLoc;
        }
        this.updateVisualPosition();
    }

    /**
     * Updates the blocks within the visual field.
     */
    private void updateVisualPosition() {
        setTranslateX(xLoc * Application.blockSize);
        setTranslateY(yLoc * Application.blockSize);
    }

    /**
     * Changes the position of the Snake.
     * @param direction Integer that represents the direction.
     *                  UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3
     */
    private void move(int direction) {
       if (direction == UP) {
           yLoc--;
           if (yLoc < 0) {
               yLoc = maxHeight - 1;
           }
       } else if (direction == RIGHT) {
           xLoc++;
           if (yLoc >= maxWidth) {
               xLoc = 0;
           }
       } else if (direction == DOWN) {
           yLoc++;
           if (yLoc >= maxHeight) {
               yLoc = 0;
           }
       } else if (direction == LEFT) {
           xLoc--;
           if (xLoc < 0) {
               xLoc = maxWidth - 1;
           }
       }
    }
}
