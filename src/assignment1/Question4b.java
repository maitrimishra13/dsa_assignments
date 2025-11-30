package assignment1;

import java.util.Scanner;

public class Question4b {
    /*Find the matrix multiplication*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First matrix
        System.out.print("Enter rows of Matrix A: ");
        int r1 = sc.nextInt();
        System.out.print("Enter columns of Matrix A: ");
        int c1 = sc.nextInt();

        int[][] A = new int[r1][c1];
        System.out.println("Enter elements of Matrix A:");
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c1; j++){
                A[i][j] = sc.nextInt();
            }
        }

        // Second matrix
        System.out.print("Enter rows of Matrix B: ");
        int r2 = sc.nextInt();
        System.out.print("Enter columns of Matrix B: ");
        int c2 = sc.nextInt();

        int[][] B = new int[r2][c2];
        System.out.println("Enter elements of Matrix B:");
        for(int i = 0; i < r2; i++){
            for(int j = 0; j < c2; j++){
                B[i][j] = sc.nextInt();
            }
        }

        sc.close();

        // Check if multiplication possible
        if(c1 != r2){
            System.out.println("Multiplication not possible. Columns of A must equal rows of B.");
            return;
        }

        // Result matrix
        int[][] C = new int[r1][c2];

        // Multiply
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c2; j++){
                C[i][j] = 0;
                for(int k = 0; k < c1; k++){
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // Display result
        System.out.println("Result of multiplication:");
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c2; j++){
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
