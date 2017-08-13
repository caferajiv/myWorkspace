package hacker.ds.stacks;

import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
	
	public static void main(String[] args) {
		 Stack<String> undoStack = new Stack<String>();
		 Scanner in = new Scanner(System.in);
		 int testcases = in.nextInt();
		 String baseString = "";
		 for(int i=0;i<testcases;i++){
			 int command = in.nextInt();
			 if(command==1){
				 String item = in.next();
				 undoStack.push(baseString);
				 baseString = baseString+item;

			 }else if(command ==2){
				 int item = in.nextInt();
				 undoStack.push(baseString);
				 int length = baseString.length();
				 baseString = baseString.substring(0,length-item);

			 }else if(command ==3){
				 int item = in.nextInt();
				 System.out.println(baseString.charAt(item-1));
				 
			 }else if(command ==4){
				 baseString = undoStack.pop();
			 }
		 }
		
	
	}

}
