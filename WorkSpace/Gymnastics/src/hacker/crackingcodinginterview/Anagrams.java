package hacker.crackingcodinginterview;

import java.util.Scanner;


public class Anagrams
{
    
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        String a = in.next();
        String b = in.next();
        int c  = charsToChange(a,b);
        System.out.println(c);
        
        
    }

    private static int charsToChange (String a, String b)
    {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        
        for(char c : a1){
            arr1[c-'a'] = arr1[c-'a']+1;
        }
        
        for(char c : b1){
            arr2[c-'a'] = arr2[c-'a']+1;
        }
        int sum=0;
        for(int i=0;i<arr1.length;i++){
            sum += Math.abs(arr1[i]-arr2[i]);
        }
        return sum;
    }

}