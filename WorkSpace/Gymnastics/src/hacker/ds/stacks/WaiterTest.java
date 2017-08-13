package hacker.ds.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WaiterTest {
	
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 int numPlates = in.nextInt();
		 int noOfPrimes = in.nextInt();
		 int[] plates = new int[numPlates];
		 for(int i=0;i<numPlates;i++){
			 plates[i] = in.nextInt();
		 }
		 List<Integer> list = listOfFirstNPrimes(noOfPrimes);
		 List<Integer> primePlates = new ArrayList<Integer>();
		 for(int n : list){
		 for(int i=0;i<numPlates;i++){
				 if(plates[i]!=0 && plates[i]%n==0){
					 primePlates.add(plates[i]);
					 plates[i]=0;
				 }
			 }
		 }
		 
		 for(int p : primePlates){
			 System.out.println(p);
		 }
		 for(int np : plates){
			 if(np!=0){
			 System.out.println(np);
			 }
		 }
	
	}

	private static List listOfFirstNPrimes(int n) {
		List<Integer> listOfPrimes = new ArrayList<Integer>();
					
			for(int num=2;n>0;num++){
				boolean isPrime = true;
				for(int j=2;j<=Math.sqrt(num);j++){
					if(num%j==0){
						isPrime = false;
						break;
					}
				}
				if(isPrime==true){
					listOfPrimes.add(num);
					n--;
				}
			}
		return listOfPrimes;
	}
	
	/*private static void testPrime(int i) {
	List<Integer> list = listOfFirstNPrimes(i);
	int[] arr = generate_prime_array(i);
	
	for (int n:arr){
		System.out.print(n+ " ");
	}
	System.out.println();
	for (int n:list){
		System.out.print(n+ " ");
	}
	
}*/
	
	
	private static int[] generate_prime_array(int Q){
		  int[] result = new int[Q]; 
		  ArrayList<Integer> a = new ArrayList<Integer>();
		  int status = 1;
		  int num = 3;
		  for ( int i = 2; i <=Q;){
		     for ( int j = 2 ; j <= Math.sqrt(num) ; j++ ){
		        if ( num%j == 0 ){status = 0;break;}
		     }
		     if (status != 0 ){
		        a.add(num);
		        i++;
		     }
		     status = 1;
		     num++;
		  }   
		    a.add(0,2); 
		    for(int i = 0; i < Q; i++) result[i] = a.get(i);
		    return result;
			}

}
