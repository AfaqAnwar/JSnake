package Snake;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Defines the game's borders.
 * @Author Afaq Anwar
 * @Verison 05/04/2019
 */
public class GameField extends Pane {
    private int width;
    private int height;

    private Snake currentSnake;
    private ArrayList<Block> visualBlocks = new ArrayList<Block>();

    public GameField(int width, int height) {
        this.width = width;
        this.height = height;

        // Boiler plate code to setup window.
        this.setMinSize(width * Application.blockSize, height * Application.blockSize);
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
    }

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
}
