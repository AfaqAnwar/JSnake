package Snake;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Starts JSnake.
 * @Author Afaq Anwar
 * @Version 05/04/2019
 */
public class Application extends javafx.application.Application {
    final static int blockSize = 10;
    private int width = 50;
    private int height = 50;
    private int initialSnakeLength = 3;

    @Override
    public void start(Stage main) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        GameField gameField = new GameField(width, height);
        gameField.setCurrentSnake(new Snake(initialSnakeLength, gameField));
        root.getChildren().add(gameField);
        Scene scene = new Scene(root);
        main.setResizable(false);
        main.setScene(scene);
        main.setTitle("JSnake");
        main.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
