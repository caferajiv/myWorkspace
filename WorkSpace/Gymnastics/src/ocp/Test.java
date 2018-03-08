package ocp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	
	private final String test= "testing";
	
	public static void main(String[] args) {
		
		//System.out.print(noReturn());
		
		List<String> list =
		        Arrays.asList("a", "b", "c", "d");
		
		List<String> newList = new ArrayList<>(list);
		newList.add("4");
		
	}

	private static void noReturn() {
		// TODO Auto-generated method stub
		return ;
	}

}
