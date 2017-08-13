package hacker.ds.stacks;

import java.util.Scanner;
import java.util.Stack;

public class EqualStacks {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        int sum1=0,sum2=0,sum3=0;
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        Stack<Integer> stack3 = new Stack<Integer>();
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
            sum1=sum1+h1[h1_i];
        }
        
        for(int h1_i=n1-1; h1_i >=0; h1_i--){
        	stack1.push(h1[h1_i]);
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
            sum2=sum2+h2[h2_i];
        }
        for(int h2_i=n2-1; h2_i >=0; h2_i--){
        	stack2.push(h2[h2_i]);
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
            sum3=sum3+h3[h3_i];
        }
        for(int h3_i=n3-1; h3_i >=0; h3_i--){
        	stack3.push(h3[h3_i]);
        }
        
        //sum1 = 8, sum2 = 7, sum3 = 9
        
        while( !(stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()) && (sum1!=sum2 || sum1!=sum3 || sum2!=sum3)){
        	if(sum1>sum2 || sum1>sum3){
        		sum1 = sum1-stack1.pop();
       
        	}else if(sum2>sum1 || sum2>sum3){
        		sum2 = sum2-stack2.pop();
        		
        	}else if(sum3>sum1 || sum3>sum2){
        		sum3 = sum3-stack3.pop();
        	}
        }
        
        if((stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty())){
        	System.out.println(0);
        }else {
        	System.out.println(sum1);
        }
	}

}
