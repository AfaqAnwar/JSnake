package Snake;

public class Block {
    private int xPos;
    private int yPos;
    private boolean isWall;
    private boolean containsApple;
    private boolean isOccupied;

    public Block(int xPos, int yPos, boolean isWall, boolean containsApple, boolean isOccupied) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.isWall = false;
        this.containsApple = false;
        this.isOccupied = false;
    }

    public int getxPos() { return xPos; }
    public int getyPos() { return yPos; }

    public boolean isWall() { return isWall; }
    public void setWall(boolean wall) { isWall = wall; }

    public boolean isContainsApple() { return containsApple; }
    public void setContainsApple(boolean containsApple) { this.containsApple = containsApple; }

    public boolean isOccupied() { return this.isOccupied; }
    public void setOccupied(boolean isOccupied) { this.isOccupied = isOccupied; }
}
