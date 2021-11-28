import java.awt.Color;
import java.util.Random;

class Food extends Cell {
    private Random random;
    private Snake snake;

    Food(Snake snake) {
        super(-1, -1, GameSnake.CELL_SIZE, GameSnake.FOOD_COLOR);
        random = new Random();
        this.snake = snake;
    }

    boolean isFood(int x, int y) {
        return getX() == x && getY() == y;
    }

    boolean isEaten() {
        return getX() == -1;
    }

    void eat() {
        set(-1, -1);
    }

    void appear() {
        int x, y;
        do {
            x = random.nextInt(GameSnake.CANVAS_WIDTH);
            y = random.nextInt(GameSnake.CANVAS_HEIGHT);
        } while (snake.isInSnake(x, y));
        set(x, y);
    }
}