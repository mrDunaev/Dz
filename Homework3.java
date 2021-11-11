/**
 *  Java 1. Homework 3
 * 
 * @author Dunaev
 * @version 10.11.2021
 */
import java.util.Arrays;
 
class Homework3 {

    public static void main (String[] args) {
        System.out.println("Task 1");
        invertArray();
        System.out.println("Task 2");
        fillArray();
        System.out.println("Task 3");
        changeArray();
        System.out.println("Task 4");
        fillDiagonal(7);
        System.out.println("Task 5");
        int[] arr = createArray(5,88);
        System.out.println(Arrays.toString(arr));
    }

    static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 1 ? 0 : 1;
        } 
        System.out.println(Arrays.toString(arr));
    }

    static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1, 6};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] < 6 ? arr[i]*2 : arr[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    static void showArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void fillDiagonal(int x) {
        int[][] arr = new int[x][x];
        showArray(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[arr[i].length-1-i][i] = 1;
        }
        System.out.println();
        showArray(arr);
    }

    static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}
