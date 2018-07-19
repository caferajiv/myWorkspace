package ocp.genericscollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCollections {
	public static void main(String[] args) {
		
		//testMethodReferences();
		
		//testMapStreamMethods();
		
		//testRemoveIf();
		
		//testForEach();
		
		//testMerge();
		
		//testCompute();
		
		testComputeIfPresent();
		
		//testComputeIfAbsent();
	}

	private static void testCompute() {

		Map<String,String> map  = new HashMap<>();
		map.put("a", "apple");
		map.put("b", "bat");
		map.put("c", "cat");
		map.put("d", "dog");
		
		String res = map.compute("a",(k,v)-> k+v);
		String res1 = map.compute("b", String::concat);
		System.out.println(res);
		System.out.println(res1);
		
		map.forEach((k,v)->map.compute(k,String::concat));
		System.out.println(map);
	
	
	}

	private static void testMapStreamMethods() {
		Map<String,String> map  = new HashMap<>();
		map.put("a", "apple");
		map.put("b", "bat");
		map.put("c", "cat");
		map.put("d", "dog");
		
		map.forEach((k,v)->System.out.println(k+v));
		
		System.out.println(map);
		
		map.replaceAll((k,v)->k+v);
		System.out.println(map);
		
	}

	private static void testComputeIfAbsent() {

		Map<String,String> map  = new HashMap<>();
		map.put("a", "apple");
		map.put("b", "bat");
		map.put("c", "cat");
		map.put("d", "dog");
		map.put("f", null);
		System.out.println(map);
		
		String s = map.computeIfAbsent("f", (a)-> null);
		System.out.println(s);
		System.out.println(map);
		
		s = map.computeIfAbsent("a", (a)-> a+"new");
		System.out.println(s);
		System.out.println(map);
		
		s = map.computeIfAbsent("e", (a)-> a+"new");
		System.out.println(s);
		System.out.println(map);
		
		s = map.computeIfAbsent("a", (a)-> null);
		System.out.println(s);
		System.out.println(map);
		
		s = map.computeIfAbsent("g", (a)-> null);
		System.out.println(s);
		System.out.println(map); 
		
		
	
	}

	private static void testComputeIfPresent() {
		Map<String,String> map  = new HashMap<>();
		map.put("a", "apple");
		map.put("b", "bat");
		map.put("c", "cat");
		map.put("d", "dog");
		map.put("f", null);
		System.out.println(map);
		
		String s = map.computeIfPresent("f", (a,b)-> a.length()>b.length()?a:b);
		System.out.println(s);
		
		s = map.computeIfPresent("a", (a,b)-> a.length()<b.length()?a:b);
		System.out.println(s);
		System.out.println(map);
		
		s = map.computeIfPresent("e", (a,b)-> a.length()<b.length()?a:b);
		System.out.println(s);
		System.out.println(map);
		
		s = map.computeIfPresent("a", (a,b)-> null);
		System.out.println(s);
		System.out.println(map);
		
		s = map.computeIfPresent("f", (a,b)-> null);
		System.out.println(s);
		System.out.println(map);
		
	}

	private static void testMerge() {

		Map<String,String> map  = new HashMap<>();
		map.put("a", "apple");
		map.put("b", "bat");
		map.put("c", "cat");
		map.put("d", "dog");
		map.put("f", null);
		map.put("g", "gg");
		
		map.merge("a", "guava", (a,b)-> a.length()>b.length()?a:b);
		System.out.println(map);
		map.merge("a", "bb", (a,b)-> null);
		System.out.println(map);
		
		map.merge("e", "ee", (a,b)-> null);
		System.out.println(map);
		
		map.merge("f", "ff", (a,b)-> null);
		System.out.println(map);
		
		map.merge("g", "ggg", (a,b)-> a.length()>b.length()?a:b);
		System.out.println(map);
		
		map.merge("h", "hh", (a,b)-> null);
		System.out.println(map);
		
		
	
	}

	private static void testForEach() {
		// TODO Auto-generated method stub
		
	}

	private static void testRemoveIf() {

		List<String> list = new ArrayList<>();
		list.add("B");
		list.add("ADF");
		list.add("abc");
		list.add("ghj");
		
		list.removeIf(a-> a.length()<2);
		System.out.println(list);
		
		list.replaceAll(a->a+"rajiv");
		
		System.out.println(list);
		
		
		
		
	}

	private static void testMethodReferences() {
		
		List<String> list = new ArrayList<>();
		list.add("B");
		list.add("ADF");
		list.add("abc");
		list.add("ghj");
		
		list.stream()
		.sorted((a,b)-> a.compareTo(b))
		.forEach(System.out::println);
		
		
	}

}
