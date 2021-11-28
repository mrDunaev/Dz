import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Java 1. Homework 8
 * 
 * @author Dunaev
 * @version 28.11.2021
 */

public class GameSnake extends JFrame {
    final String TITLE_OF_PROGRAM = "Game Snake";
    final String GAME_OVER_MSG = "GAME OVER";
    final String GAME_PAUSED_MSG = "GAME PAUSED";   //message for paused game
    final static int CELL_SIZE = 20; 
    final static int CANVAS_WIDTH = 30;
    final static int CANVAS_HEIGHT = 25;
    final static Color SNAKE_COLOR = Color.green;   //i decided to change colors: my snake is green
    final static Color FOOD_COLOR = Color.gray;
    final static int KEY_LEFT = 37;
    final static int KEY_UP = 38;
    final static int KEY_RIGHT = 39;
    final static int KEY_DOWN = 40;
    final static int KEY_PAUSE = 32;                //game paused by pressing space button
    final int START_SNAKE_SIZE = 5;
    final int START_SNAKE_X = CANVAS_WIDTH/2;
    final int START_SNAKE_Y = CANVAS_HEIGHT/2;
    final int SNAKE_DELAY = 150;
    int snakeSize = 0;
    static boolean gameOver = false;
    boolean gamePaused = false;                     //is game paused or not

    Canvas canvas;
    Snake snake;
    Food food;

    public static void main(String[] args) {
        new GameSnake().game();
    }

    GameSnake() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new Canvas();
        canvas.setBackground(Color.white);
        canvas.setPreferredSize(new Dimension(
                CELL_SIZE * CANVAS_WIDTH,
                CELL_SIZE * CANVAS_HEIGHT));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
                pause(e.getKeyCode());  //to pause the game
            }
        });

        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void game() {
        snake = new Snake(
                START_SNAKE_X,
                START_SNAKE_Y,
                START_SNAKE_SIZE,
                KEY_RIGHT);
        food = new Food(snake);
        snake.setFood(food);

        while (!gameOver) {
            if (!gamePaused)    //snake moves if game is not paused
                snake.move();

            if (snake.size() > snakeSize) {
                snakeSize = snake.size();
                setTitle(TITLE_OF_PROGRAM + " : " + snakeSize);
            }

            if (food.isEaten())
                food.appear();

            canvas.repaint();
            sleep(SNAKE_DELAY);
        }
        JOptionPane.showMessageDialog(this, GAME_OVER_MSG);
        System.exit(0);
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //pause game
    void pause(int code) {
        if (code == KEY_PAUSE) {
            gamePaused = true;
            JOptionPane.showMessageDialog(this, GAME_PAUSED_MSG);
            gamePaused = false;
        }
    }

    class Canvas extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            snake.paint(g2D);
            food.paint(g2D);
        }
    }
}