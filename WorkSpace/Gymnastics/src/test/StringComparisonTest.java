package test;

import java.util.Arrays;

public class StringComparisonTest {
	
	public static void main(String[] args) {
		
		String[] arr = {"GLOBAL", "ENABLED"};
		Arrays.sort(arr);
		System.out.println(Arrays.binarySearch(arr, "Enabled",String.CASE_INSENSITIVE_ORDER));
		
	}

}
