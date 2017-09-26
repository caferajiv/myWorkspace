package hacker.crackingcodinginterview;

import java.util.Scanner;

public class ArrayLeftRotation
{
    
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int k = in.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }

        int[] arr2 = new int[size];
        rotateArrayLeft(arr, arr2, k);
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }

    private static void rotateArrayLeft (int[] arr,int[] arr2, int k)
    {
        int size = arr.length;
        int currentIndex = 0;
        int newIndex = 0;

        while (currentIndex < size) {
            newIndex = currentIndex - k;
            if (newIndex < 0) {
                newIndex += size;
            }
            arr2[newIndex] = arr[currentIndex];
            currentIndex++;
        }

    }

   

}