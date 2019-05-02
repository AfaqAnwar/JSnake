module JSnake {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    opens Snake to javafx.fxml;
    exports Snake to javafx.graphics, javafx.fxml;
}
