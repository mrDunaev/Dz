import java.util.Scanner;
import java.util.Random;

class TicTacToe {
    final char SIGN_X = 'X';
    final char SIGN_O = 'O';
    final char SIGN_EMPTY = '.';
    char[][] table;
    Scanner scanner;
    Random random;

    public static void main (String[] args) {
        new TicTacToe().game();
    }

    TicTacToe() {
        scanner = new Scanner(System.in);
        random = new Random();
        table = new char[3][3];
    }

    void game() {
        initTable();
        while (true) {
            humanTurn();
            if (checkWin(SIGN_X)) {
                System.out.println("YOU WON");
                break;
            }
            if (checkDraw()) {
                System.out.println("DRAW");
                break;
            }
            aiTurn();
            printTable();
            if (checkWin(SIGN_O)) {
                System.out.println("AI WON");
                break;
            }
            if (checkDraw()) {
                System.out.println("DRAW");
                break;
            }
        }
        printTable();
        System.out.println("GAME OVER");
    }

    void initTable() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                table[y][x] = SIGN_EMPTY;
            }
        }
    }

    void printTable() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(table[y][x] + " ");
            }
            System.out.println();
        }
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.print("Your turn, choose x and y (1..3): ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while(!isCellValid(x,y));
        table[y][x] = SIGN_X;
    }

    boolean isCellValid (int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) return false;
        if (table[y][x] == SIGN_EMPTY) return true;
        return false;        
    }

    void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while(!isCellValid(x,y));
        table[y][x] = SIGN_O;
    }

    boolean checkWin (char sign) {
        boolean isWin = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                isWin = isWin && table[i][j] == sign;
            }
            if (isWin) return isWin; else isWin = true;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                isWin = isWin && table[j][i] == sign;
            }
            if (isWin) return isWin; else isWin = true;
        }
        for (int i = 0; i < 3; i++) {
            isWin = isWin && table[i][i] == sign;
        }
        if (isWin) return isWin; else isWin = true;
        for (int i = 0; i < 3; i++) {
            isWin = isWin && table[2-i][i] == sign;
        }
        if (isWin) return isWin;
        return false;
    }

    boolean checkDraw() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (table[y][x] == SIGN_EMPTY) return false;
            }
        }
        return true;
    }
}