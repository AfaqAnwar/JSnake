package Snake;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Starts JSnake.
 * @Author Afaq Anwar
 * @Version 05/21/2019
 */
public class Application extends javafx.application.Application {
    final static int blockSize = 10;
    private int width = 40;
    private int height = 40;
    private int initialSnakeLength = 3;
    private long then = System.nanoTime();
    private boolean directionChanged = false;
    private boolean hasNext = false;
    private int nextUpdate = 0;

    @Override
    public void start(Stage main) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        GameField gameField = new GameField(width, height);
        gameField.setCurrentSnake(new Snake(initialSnakeLength, gameField));

        Label score = new Label("Score: 0");
        score.setFont(Font.font("Arial", 18));

        AnimationTimer gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now - then > 1000000000 / 10) {
                    gameField.update();
                    then = now;
                    score.setText("Score: " + gameField.getScore());
                    directionChanged = false;
                    if (hasNext) {
                        setDirection(gameField.getCurrentSnake(), nextUpdate);
                        hasNext = false;
                    }
                }
            }
        };
        gameTimer.start();

        root.getChildren().addAll(gameField, score);
        Scene scene = new Scene(root);
        // Handles keyboard input to allow the Snake to move.
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    if (gameField.getCurrentSnake().getDirection() == Block.DOWN) {
                        break;
                    }
                    this.setDirection(gameField.getCurrentSnake(), Block.UP);
                    break;
                case DOWN:
                    if (gameField.getCurrentSnake().getDirection() == Block.UP) {
                        break;
                    }
                    this.setDirection(gameField.getCurrentSnake(), Block.DOWN);
                    break;
                case LEFT:
                    if (gameField.getCurrentSnake().getDirection() == Block.RIGHT) {
                        break;
                    }
                    this.setDirection(gameField.getCurrentSnake(), Block.LEFT);
                    break;
                case RIGHT:
                    if (gameField.getCurrentSnake().getDirection() == Block.LEFT) {
                        break;
                    }
                    this.setDirection(gameField.getCurrentSnake(), Block.RIGHT);
                    break;
            }
        });

        main.setResizable(false);
        main.setScene(scene);
        main.setTitle("JSnake");
        main.show();
    }

    /**
     * Sets the direction of a Snake.
     * This is used so that two inputs can be made and it will pass them through, removing any sort of perceived delay.
     * @param snake The current Snake within the GameField.
     * @param direction Integer that represents a Direction.
     */
    public void setDirection(Snake snake, int direction) {
        if (!directionChanged) {
            snake.setDirection(direction);
            directionChanged = true;
        } else {
            hasNext = true;
            nextUpdate = direction;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
