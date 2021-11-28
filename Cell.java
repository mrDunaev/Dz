import java.awt.Color;
import java.awt.Graphics2D;

class Cell {
    private int x, y;
    private int size;
    private Color color;

    Cell (int x, int y, int size, Color color) {
        set(x, y);
        this.size = size;
        this.color = color;
    }

    void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void paint(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x * size, y * size, size, size);
    }
}