package assignment1;

import java.util.Scanner;

public class Question4c {
    /*Find the Transpose of a Matrix*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        int[][] A = new int[rows][cols];

        System.out.println("Enter matrix elements:");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                A[i][j] = sc.nextInt();
            }
        }

        // Create transpose matrix
        int[][] T = new int[cols][rows];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                T[j][i] = A[i][j];   // swap indices
            }
        }

        System.out.println("Transpose:");
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                System.out.print(T[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
