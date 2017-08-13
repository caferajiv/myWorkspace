package hacker.ds.stacks;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class PoisonousPlants {
	
	public static void main(String[] args) {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Scanner in = new Scanner(System.in);

		try {
			int testcases = Integer.parseInt(in.readLine());

			String nextLine = in.readLine();
			String[] strArry = nextLine.split(" ");
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<testcases; i++){
				list.add(Integer.parseInt(strArry[0]));
			}

			boolean immortal = false;
			int days = 0;
			while(!immortal){
				List<Integer> indexes = new ArrayList<Integer>();
				for(int i = list.size()-1;i>=0;i--){
					int index = i;
					int second = list.get(i);
					int first=Integer.MAX_VALUE;
					if(i!=0){
						first = list.get(i-1);
					}
					if(second-first>0){
						indexes.add(index);
					}
				}
				if(indexes.size()>0){
					days++;
					for(int i : indexes){
						list.remove(i);
					}
				}else{
					immortal = true;
				}

			}

			System.out.println(days);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void testListIterator() {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		 ListIterator<Integer> iter = list.listIterator(list.size());
		 List<Integer> indexes = new ArrayList<Integer>();
		 while(iter.hasPrevious()){
			int index = iter.previousIndex();
			int second = iter.previous();
			int first=Integer.MAX_VALUE;
			if(iter.hasPrevious()){
				 first = iter.previous();
			}
			if(second-first>0){
				indexes.add(index);
			}
		 }
		 for(int i : indexes){
			 list.remove(i);
		 }
		
	}

}
