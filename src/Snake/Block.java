package Snake;

import javafx.scene.shape.Rectangle;

/**
 * Defines a Block within the grid.
 * @Author Afaq Anwar
 * @Version 05/04/2019
 */
public class Block extends Rectangle {
    private int xLoc;
    private int yLoc;
    // Old position is stored to move all blocks.
    Block previousBlock;
    private int oldXLoc;
    private int oldYLoc;


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

    public void update() {

    }
}
