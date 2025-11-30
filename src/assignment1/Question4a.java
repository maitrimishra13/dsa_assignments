package assignment1;

import java.util.Scanner;

public class Question4a {
    /*Reverse the elements of an array*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter elements: ");
        for(int i = 0; i < size; i++){
            arr[i]= sc.nextInt();
        }

        Question4a obj = new Question4a();

        System.out.println("Reversing the array : ");
        obj.reverse(arr);
        sc.close();
    }

    public void reverse(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        System.out.println("Reversed array:");
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
}