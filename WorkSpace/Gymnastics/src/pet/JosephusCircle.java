package pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import com.sun.org.apache.bcel.internal.generic.LSTORE;

public class JosephusCircle {

	public static void main(String[] args) {
		
		List<Integer> list =  new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		int last =  lastManOut(list);
		System.out.println("Winner is :"+last);
		
		
	}

	private static int lastManOut(List<Integer> list) {
		
		ListIterator<Integer> itr = null;
		int index = 0;
		while(list.size()>1){
			itr = list.listIterator();
			
		while(itr.hasNext() && index<3){
			index++;
			Integer val = itr.next();
			if(index==3){
				itr.remove();
				System.out.println(val);
				index=0;
			}
		}
		itr = null;
		}
		return list.get(0);
	}
	
}
