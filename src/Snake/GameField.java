package Snake;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Defines the game's borders.
 * @Author Afaq Anwar
 * @Verison 05/21/2019
 */
public class GameField extends Pane {
    private int width;
    private int height;

    private Snake currentSnake;
    private ArrayList<Block> visualBlocks = new ArrayList<Block>();

    Food food;
    int score;

    public GameField(int width, int height) {
        this.width = width;
        this.height = height;

        // Boiler plate code to setup window.
        this.setMinSize(width * Application.blockSize, height * Application.blockSize);
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

        food = this.addFood();
    }

    // Getters. These were implemented since the Pane methods cannot be overwritten.
    public int getActualWidth() { return width; }
    public int getActualHeight() { return height; }
    public Snake getCurrentSnake() { return currentSnake; }

    public void setCurrentSnake(Snake currentSnake) {
        this.currentSnake = currentSnake;
        for (Block currBlock : this.currentSnake.getSnakeSegments()) {
            this.addVisualBlock(currBlock);
        }
    }

    private void addVisualBlock(Block block) {
        this.getChildren().add(block);
        this.visualBlocks.add(block);
    }

    public void update() {
        for (Block currBlock : visualBlocks) {
            currBlock.update();
        }
        if (isEaten(food)) {
            this.getChildren().remove(food);
            this.increaseSnakeLength();
            score++;
            food = this.addFood();
        }
    }

    public Food addFood() {
        int randomXPos = (int) (Math.random() * width);
        int randomYPos = (int) (Math.random() * height);

        Food food = new Food(randomXPos, randomYPos);
        this.getChildren().add(food);
        return food;
    }

    public void increaseSnakeLength() {
        Block block = new Block(currentSnake.getTailBlock().getOldXLoc(), currentSnake.getTailBlock().getOldYLoc(), currentSnake.getTailBlock(), this);
        currentSnake.setTailBlock(block);
        this.addVisualBlock(block);
    }

    public boolean isEaten(Food food) {
        return food.getxLoc() == currentSnake.getHeadBlock().getxLoc() && food.getyLoc() == currentSnake.getHeadBlock().getyLoc();
    }
}
