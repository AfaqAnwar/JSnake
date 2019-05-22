package Snake;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Defines a "Food" block.
 * @Author Afaq Anwar
 * @Version 05/21/2019
 */
public class Food  extends Rectangle {
    private int xLoc;
    private int yLoc;

    public Food(int xLoc, int yLoc) {
        super(Application.blockSize, Application.blockSize);
        this.xLoc = xLoc;
        this.yLoc = yLoc;

        setTranslateX(xLoc * Application.blockSize);
        setTranslateY(yLoc * Application.blockSize);

        setFill(Color.RED);
        setStroke(Color.RED);
    }

    public int getxLoc() { return xLoc; }
    public int getyLoc() { return yLoc; }
}
