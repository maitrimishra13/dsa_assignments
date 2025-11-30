package assignment1;

import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] arr = new int[rows][cols];
        System.out.println("Enter elements:");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                arr[i][j] = sc.nextInt();

        Question5 obj = new Question5();
        int option;

        do {
            System.out.println("\n--MENU--");
            System.out.println("1. ROW SUM");
            System.out.println("2. COLUMN SUM");
            System.out.println("3. EXIT");
            System.out.print("Enter option number: ");

            // Validate input
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number 1-3.");
                sc.next(); // discard invalid input
            }
            option = sc.nextInt();

            if (option < 1 || option > 3) {
                System.out.println("Please choose a valid option (1-3).");
                continue;
            }

            switch (option) {
                case 1 -> obj.rowSum(arr);
                case 2 -> obj.colSum(arr);
                case 3 -> System.out.println("EXIT");
            }
        } while (option != 3);

        sc.close();
    }

    public void rowSum(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int x : arr[i]) sum += x;
            System.out.println("Sum of row " + (i + 1) + " = " + sum);
        }
    }

    public void colSum(int[][] arr) {
        int cols = arr[0].length;

        for (int j = 0; j < cols; j++) {
            int sum = 0;
            for (int[] row : arr)  // for-each over rows
                sum += row[j];       // pick the element in column j
            System.out.println("Sum of column " + (j + 1) + " = " + sum);
        }
    }

}