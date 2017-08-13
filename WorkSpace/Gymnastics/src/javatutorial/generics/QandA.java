package javatutorial.generics;

import java.util.Collection;
import java.util.List;

public class QandA {
	
	public static void main(String[] args) {
		
	}

	
	
	
	/**
	 * Write a generic method to count the number of elements in a collection 
	 * that have a specific property (for example, odd integers, prime numbers, palindromes).
	 */
	
	public <T extends Comparable<T>> int countElements(Collection<T> list){
		
		return list.size();
	}
	
	/**
	 * How to compare
	 * @param x
	 * @param y
	 * @return
	 */
	 public static <T extends Comparable<T>> T max(T x, T y) {
	        return x.compareTo(y)>0 ? x : y;
	    }
	 
	 /**
	  * Write a generic method to exchange the positions of two different elements in an array.
	  */
	 
	 public static<T> void swap(T[] array, int i, int j){
		 
		 T temp;
		 temp = array[i];
		 array[i]= array[j];
		 array[j]=temp;
		 
	 }
	 
	 /**
	  * print all numbers in a list
	  * @param list
	  */
	 public static void print(List<? extends Number> list) {
		    for (Number n : list)
		        System.out.print(n + " ");
		    System.out.println();
		}
	 
	 /**
	  * Write a generic method to find the maximal element in the range [begin, end) of a list.
	  */
	 
	 public static<T extends Comparable<T>>  T findMaximal(List<T> list , int begin, int end){
		 T max = list.get(begin);
		 
		 for(int i=begin;i<end-1;i++){
			 max = list.get(i).compareTo(list.get(i+1)) > 0 ? list.get(i):list.get(i+1);	 
		 }
		 
		 
		 return max;
	 }
	 
	 class Node<T> implements Comparable<T> {
		    public int compareTo(T obj) { return 0; }
		    // ...
		}
	 
	 
	 Node<String> node = new Node<String>();
	 Comparable<String> comp = node;
	 
}
