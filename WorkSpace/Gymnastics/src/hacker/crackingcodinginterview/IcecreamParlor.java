package hacker.crackingcodinginterview;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class IceCream implements Comparable{
    int flavor;
    int index;

    public IceCream(int flavor, int index) {
      this.flavor = flavor;
      this.index = index;
    }
   
    @Override
    public int compareTo(Object o) {
        if(o instanceof IceCream){
          return ((Integer)this.flavor).compareTo(((IceCream)o).flavor);
       }
       return 0;
    }

    @Override
    public boolean equals(Object o){
       if(o instanceof IceCream){
          return this.flavor == ((IceCream)o).flavor;
       }
        return false;
    }
        
}

public class IcecreamParlor {
   
    public static int binarySearch(int first, int last, IceCream[] arr, int search) {
        if(first>last) return -1;
        
        int mid = first + (last-first)/2;
        if(arr[mid].flavor==search) return mid;
        if(arr[mid].flavor>search){
        	return binarySearch(first,mid,arr,search);
        }else {
        	return binarySearch(mid+1,last,arr,search);
        }
        
    }
    
    public static void  findSumOf2EqualsK(int low, int high,IceCream[] arr,  int K) {
		if(low>high) return;
		int mid = (high-low)/2 + low;
		while(low<high && high>low){
			if(arr[low].flavor+arr[high].flavor>K) high--;
			else if(arr[low].flavor+arr[high].flavor<K)low++;
			else if(arr[low].flavor+arr[high].flavor==K){ System.out.println("low: "+arr[low]+ " high: "+arr[high]); return;}
		}
	}

    public static void main(String[] args) {
        
        int t;
        int n, m;
 
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
       for(int test = 0; test < t; test++) {       
            
            m = in.nextInt();
            n = in.nextInt(); 
            IceCream[] arr = new IceCream[n];
    
            for (int i = 0; i < n; i++)
                arr[i] = new IceCream(in.nextInt(), i + 1);
            
            Arrays.sort(arr);
            int firstIndex = 100000, secondIndex = 100000;
            findSumOf2EqualsK(0,n-1,arr,m);
          /*  for(int i = 0; i < n - 1 ; i++) {
                int search = m - arr[i].flavor;
                if(search >= arr[i].flavor) {
                    int index = binarySearch( i + 1, n - 1, arr, search);
                    if( index != -1 ) {
                        System.out.println( Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
                        break;

                    }
                }
            } */
            
        }
        
    }
                        
}

