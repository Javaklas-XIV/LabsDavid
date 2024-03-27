package trainee.david.other.H5;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("5 || 4 : " + greatest(5, 4));
        System.out.println("Hoi || Hallo : " + greatest("Hoi", "Hallo"));
        System.out.println("1 || 2 || 3 : " + greatest(1, 2, 3));

        System.out.println("5! = " + factorial(5));

        System.out.println("Fib(4, 6): ");
        long[] fiboResult = Fibo.run(6);

        sudokuArray();
    }

    private static int greatest(int a, int b) {
        return Math.max(a, b);
    }

    private static String greatest(String a, String b) {
        return (a.length() > b.length()) ? a : b;
    }

    private static int greatest(int... numbers) {
        OptionalInt max = Arrays.stream(numbers).max();
        if (max.isPresent()) return max.getAsInt();
        return -1;
    }

    private static int factorial(int start) {
        if (start == 1) return 1;
        else return factorial(start - 1) * start;
    }

    private static void sudokuArray() {
        int[][] sudoku = new int[3][3];

        // Readr numbers from the console
        Scanner input = new Scanner(System.in);
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                try {
                    System.out.print("Enter a number (1-9): ");
                    int next = Integer.parseInt(input.nextLine());
                    sudoku[row][column] = next;
                } catch (NumberFormatException formatException) {
                    System.out.println("Not a valid number, try again");
                    column--;
                }
            }
        }

        // Print the sudoku
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                System.out.printf("| %d ", sudoku[row][column]);
            }
            System.out.println("|");
        }
    }

}
