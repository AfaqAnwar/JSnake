package Snake;

import java.util.ArrayList;

/**
 * Snake Object.
 * @Author Afaq Anwar
 * @Version 05/21/2019
 */
public class Snake {
    private ArrayList<Block> snakeSegments;
    private Block headBlock;
    private Block tailBlock;

    public Snake(int initialLength, GameField gameField) {
        this.snakeSegments = new ArrayList<Block>();
        int initialXLoc = gameField.getActualWidth() / 2;
        int initialYLoc = gameField.getActualHeight() / 2;
        this.headBlock = new Block(initialXLoc, initialYLoc, null, gameField);
        snakeSegments.add(headBlock);
        this.generateTail(initialXLoc, initialYLoc, headBlock, initialLength, gameField);
        tailBlock = snakeSegments.get(snakeSegments.size() - 1);
    }

    private void generateTail(int headX, int headY, Block previous, int length, GameField gameField) {
        for (int i = 1; i < length; i++) {
            Block block = new Block(headX + i, headY, previous, gameField);
            this.snakeSegments.add(block);
            previous = block;
        }
    }

    public ArrayList<Block> getSnakeSegments() { return this.snakeSegments; }
    public int getDirection() { return headBlock.getDirection(); }
    public void setDirection(int direction) {
        headBlock.setDirection(direction);
    }
    public Block getHeadBlock() { return this.headBlock; }
    public Block getTailBlock() { return this.tailBlock; }
    public void setTailBlock(Block tailBlock) { this.tailBlock = tailBlock; }
}
