package Snake;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Starts JSnake.
 * @Author Afaq Anwar
 * @Version 05/12/2019
 */
public class Application extends javafx.application.Application {
    final static int blockSize = 10;
    private int width = 40;
    private int height = 40;
    private int initialSnakeLength = 3;
    private long then = System.nanoTime();

    @Override
    public void start(Stage main) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        GameField gameField = new GameField(width, height);
        gameField.setCurrentSnake(new Snake(initialSnakeLength, gameField));


        AnimationTimer gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now - then > 1000000000 / 4) {
                    gameField.update();
                    then = now;
                }
            }
        };
        gameTimer.start();

        root.getChildren().add(gameField);
        Scene scene = new Scene(root);
        // Handles keyboard input to allow the Snake to move.
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    gameField.getCurrentSnake().setDirection(Block.UP);
                    break;
                case DOWN:
                    gameField.getCurrentSnake().setDirection(Block.DOWN);
                    break;
                case LEFT:
                    if (gameField.getCurrentSnake().getDirection() == Block.RIGHT) {
                        break;
                    }
                    gameField.getCurrentSnake().setDirection(Block.LEFT);
                    break;
                case RIGHT:
                    if (gameField.getCurrentSnake().getDirection() == Block.LEFT) {
                        break;
                    }
                    gameField.getCurrentSnake().setDirection(Block.RIGHT);
                    break;
            }
        });

        main.setResizable(false);
        main.setScene(scene);
        main.setTitle("JSnake");
        main.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
