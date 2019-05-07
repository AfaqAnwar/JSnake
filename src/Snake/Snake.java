package Snake;

import java.util.ArrayList;

/**
 * Snake Object.
 * @Author Afaq Anwar
 * @Version 05/06/2019
 */
public class Snake {
    private ArrayList<Block> snakeSegments;
    private Block headBlock;

    public Snake(int initialLength, GameField gameField) {
        this.snakeSegments = new ArrayList<Block>();
        int initialXLoc = gameField.getActualWidth() / 2;
        int initialYLoc = gameField.getActualHeight() / 2;
        this.headBlock = new Block(initialXLoc, initialYLoc, null, gameField);
        snakeSegments.add(headBlock);
        this.generateTail(initialXLoc, initialYLoc, headBlock, initialLength, gameField);
    }

    private void generateTail(int headX, int headY, Block previous, int length, GameField gameField) {
        for (int i = 1; i < length; i++) {
            Block block = new Block(headX + i, headY, previous, gameField);
            this.snakeSegments.add(block);
            previous = block;
        }
    }

    public ArrayList<Block> getSnakeSegments() { return this.snakeSegments; }
}
