package Snake;

import java.util.ArrayList;

/**
 * Snake Object.
 * @Author Afaq Anwar
 * @Version 05/04/2019
 */
public class Snake {
    private ArrayList<Block> snakeSegments;
    private Block headBlock;

    public Snake(int initialLength, GameField gameField) {
        this.snakeSegments = new ArrayList<Block>();
        int initialXLoc = (int) gameField.getWidth() / 2;
        int initialYLoc = (int) gameField.getHeight() / 2;
        this.headBlock = new Block(initialXLoc, initialYLoc, null);
        this.generateTail(initialXLoc, initialYLoc, headBlock, initialLength);
    }

    private void generateTail(int headX, int headY, Block previous, int length) {
        for (int i = 1; i < length; i++) {
            Block block = new Block(headX + i, headY, previous);
            this.snakeSegments.add(block);
            previous = block;
        }
    }

    public ArrayList<Block> getSnakeSegments() { return this.snakeSegments; }
}
