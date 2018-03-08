package hacker.crackingcodinginterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomeNote {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		String[] arr = new String[m];
		String[] brr = new String[n];
		for(int i=0;i<m;i++) {
			arr[i] = sc.next();
		}
		for(int i=0;i<n;i++) {
			brr[i] = sc.next();
		}
		
		System.out.println(checkRansom(arr,brr));
	
	}

	private static String checkRansom(String[] arr, String[] brr) {
		Map<String,Integer> map = new HashMap<>();
		for(String s : brr) {
			if(map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			}else {
				map.put(s, 1);
			}
		}
		
		for(String s: arr) {
			if(map.containsKey(s) && map.get(s)>0) {
				map.put(s, map.get(s)-1);
			}
			
		}
		
		int sum = map.values().stream().mapToInt(x->x.intValue()).sum();
		if(sum==0) {
			return "Yes";
		}
		
		
		return "No";
		
	}

}
