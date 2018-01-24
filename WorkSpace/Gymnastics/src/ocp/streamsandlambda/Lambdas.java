package ocp.streamsandlambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Lambdas {
	
	public static void main(String[] args) {
		
		//testSupplier();
		//testConsumer();
		//testBiConsumer();
		//testPredicate();
		//testBiPredicate();
		//testFunction();
		//testBiFunction();
		testUnaryOperator();
		testBinaryOperator();
		
		testRunnable();
		testCallable();
		testComparable();
		testComparator();
	}

	private static void testSupplier() {
		
		Supplier ss = new Supplier<String>() {

			@Override
			public String get() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		Supplier s = String::new;
		Supplier s2 = StringBuilder::new;
		Supplier s3 = ArrayList<Integer>::new;
		Supplier s4 = ()-> new StringBuilder();
		Supplier s5 = ()-> new String();
		
		System.out.println(s==s5);
		System.out.println(s.equals(s5));
		System.out.println(s4);
		System.out.println(s3);
		
	}

	private static void testConsumer() {
		Consumer c = new Consumer<String>() {

			@Override
			public void accept(String t) {
				// TODO Auto-generated method stub
				
			}
		};
		Consumer c1 = System.out::print;
		List<String> list = new ArrayList<>();
		Consumer<String> c2 = s -> list.add(s);
		Consumer<String> c3 = list::add;
		System.out.println(list);
		
		
	}

	private static void testBiConsumer() {
		BiConsumer<String, Integer> bc = new BiConsumer<String, Integer>() {

			@Override
			public void accept(String t, Integer u) {
				// TODO Auto-generated method stub
				
			}
			
		};
				
		Map<String,Integer> map = new HashMap<>();
		BiConsumer<String, Integer> c2 = (k,v) -> map.put(k,v);
		BiConsumer<String, Integer> c3 = map::put;
		System.out.println(map);
		
		
	}

	private static void testPredicate() {
		Predicate<String> pred = new Predicate<String>() {

			@Override
			public boolean test(String t) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		
		Predicate<String> p = s-> s.startsWith("s");
		String s ="";
		Predicate<String> p1 = s::startsWith;
		Predicate<String> p2 = String::isEmpty;
		
		p1.test("ss");
		
	}

	private static void testBiPredicate() {
		BiPredicate<String, Integer> bPred = new BiPredicate<String, Integer>() {

			@Override
			public boolean test(String t, Integer u) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		BiPredicate<String, Integer> p1 = (a,b)-> a.length()>b;
		
		BiPredicate<Integer,Integer> p2 = (a,b)-> a<a;
		
	}

	private static void testFunction() {

		Function<String, Integer> f = new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		Function<String, Integer> f1 = s->s.length();
		Function<String, Integer> f2 = String::length;
		System.out.println(f2.apply(""));
		f2 = Integer::parseInt;
	}

	private static void testBiFunction() {

		BiFunction<String, Integer, Integer> Bi = new BiFunction<String, Integer, Integer>() {

			@Override
			public Integer apply(String t, Integer u) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		BiFunction<String, Integer, Integer> bi = (s,i)->s.length()+i;
		System.out.println(bi.apply("ss", 7));
		
		BiFunction<String, String, String> bi1 = String::concat;
		
		BiFunction<String, Integer, String> bi2 = String::substring;
		System.out.println(bi2.apply("rajiv", 1));
		
		TriFunction<String, Integer, Integer, String> tri = String::substring;
		System.out.println(tri.apply("rajivkumar",1,4));
	}
	
	static interface TriFunction<T,U,V,R> {
		
		R apply(T t, U u, V v);
	} 

	private static void testUnaryOperator() {

		UnaryOperator<String> un = new UnaryOperator<String>() {
			
			@Override
			public String apply(String t) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		un = s-> s+s;
		un = String::toLowerCase;
		un = String::toString;
		
		UnaryOperator<Integer> in = Integer::valueOf;
		
	}

	private static void testBinaryOperator() {
		BinaryOperator<Integer> bi = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		bi = Integer::compareTo;
		bi = (i,j) -> i+j;
		
		Comparator<Integer> comp = new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return 0;
				}
			};
		
		bi = comp::compare;
		
		class MyComparator implements Comparator<Integer>{

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			
		}
		
		bi = new MyComparator()::compare;
		
	}
	
	

	private static void testRunnable() {
		Runnable runnable = () -> System.out.println();
		runnable = System.out::println;
		runnable = StringBuilder::new;
		
		
		
	}

	private static void testCallable() {

		Callable<Integer> call = ()-> 5;
		
		
	}

	private static void testComparable() {
		
		Comparable<Integer> comp = (a) -> a-1;		
	}

	private static void testComparator() {
		
		Comparator<Integer> comp = (a,b)-> a-b;
		
		comp = Integer::compare;
		
	}

	

	

}
