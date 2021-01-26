package controller;

public class Points {
    private int x;
    private int y;
    private Points point;

    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public Points getPoint() {
        return point;
    }

    public void setY(int y) {
        this.y = y;
    }
}
