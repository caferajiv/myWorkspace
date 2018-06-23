package ocp.streamsandlambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.IntSupplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
	
	public static void main(String[] args) {
		//testStreams();
		
		//testStreamTerminalOperations();
		
		//testStreamIntermediateOperations();
		
		//testPrimitiveStreams();
		
		//testCollectorMethods();
		
		testParallelStreams();
		
	}

	private static void testParallelStreams() {

		Stream<String> s = Arrays.asList("aa","bbx","cc","dd", "aa").parallelStream();
		//Stream<String> p = s.parallel();
		s.peek(System.out::print).count();
		System.out.println();
		 s = Arrays.asList("aa","bbx","cc","dd", "aa").parallelStream();
		 
		 s.forEachOrdered(System.out::print);
		 System.out.println();
		 s = Arrays.asList("aa","bbx","cc","dd", "aa").stream().parallel();
		 s.unordered().peek(System.out::print).count();
		 
		 System.out.println();
		 
		 s = Arrays.asList("aa","bbx","cc","dd", "aa").parallelStream();
		 
		 System.out.println(s.unordered().findAny());
		 
		 //parallel reduce and collect
		 s = Arrays.asList("aa","bbx","cc","dd", "aa").parallelStream().unordered();
		 
		 //System.out.println(s.reduce(String::concat));
		 
		 //System.out.println(s.reduce("", (l,k)->l+k));
		 
		 System.out.println(s.reduce("", (x,y)->x+y, (a,b)->a+b));
		 s = Arrays.asList("aa","bbx","cc","dd", "aa").parallelStream().unordered();
		 System.out.println(s.collect(ConcurrentSkipListSet::new , Set::add,Set::addAll));
		 
		 s = Arrays.asList("aa","bbx","cc","dd", "aa").parallelStream().unordered();
		 System.out.println(s.collect(Collectors.toConcurrentMap(String::length,k->k ,(a,b)->a+b)));
		 
		 s = Arrays.asList("aa","bbx","cc","dd", "aa").parallelStream().unordered();
		System.out.println(s.collect(Collectors.groupingByConcurrent(String::length,Collectors.toSet())));
		
		 s = Arrays.asList("aa","bbx","cc","dd", "aa").parallelStream().unordered();
			System.out.println(s.collect(Collectors.groupingByConcurrent(String::length,ConcurrentHashMap::new ,Collectors.toList())));
		
	
	}

	private static void testCollectorMethods() {

		Stream<String> s = Arrays.asList("aa","bbc","cc","dd", "aa").stream();
		
		System.out.println(s.collect(Collectors.joining()));
		
		s = Arrays.asList("aa","bbc","cc","dd", "aa").stream();
		System.out.println(s.collect(Collectors.joining(",")));
		
		s = Arrays.asList("aa","bbc","cc","dd", "aa").stream();
		System.out.println(s.collect(Collectors.joining(",", "pre", "post")));
		
		s = Arrays.asList("aa","bbc","cc","dd", "aa").stream();
		//double d = s.collect(Collectors.averagingInt(String::length));
		System.out.println((double)s.collect(Collectors.averagingInt(String::length)));
		
		s = Arrays.asList("aa","bbc","cc","dd", "aa").stream();
		System.out.println((long)s.collect(Collectors.counting()));
		
		s = Arrays.asList("aa","bbc","cc","dd", "aa").stream();
		System.out.println(s.collect(Collectors.maxBy((a,b)->b.length()-a.length())));
		
		s = Arrays.asList("aa","bbc","cc","dd", "aa").stream();
		System.out.println(s.collect(Collectors.minBy(String::compareTo)));
		
		s = Arrays.asList("aa","bbc","cc","dd", "aa").stream();
		System.out.println(s.collect(Collectors.toSet()));
		
		s = Arrays.asList("aa","bbc","cc","dd", "aa").stream();
		System.out.println(s.collect(Collectors.toMap(String::length,k->k,(a,b)->a+","+b)));
		
		s = Arrays.asList("aa","bbc","cc","dd", "aa").stream();
		System.out.println(s.collect(Collectors.groupingBy(String::length)));
		
		s = Arrays.asList("aa","bbc","cc","dd", "aa").stream();
		System.out.println(s.collect(Collectors.groupingBy(String::length, Collectors.toCollection(TreeSet::new))));
		
		s = Arrays.asList("aa","bbc","cc","dd", "aa").stream();
		System.out.println(s.collect(Collectors.groupingBy(String::length,Collectors.toList())));
		
		s = Arrays.asList("aa","bbc","cc","dd", "aa").stream();
		System.out.println(s.collect(Collectors.partitioningBy(a->a.length()<2)));
		
		s = Arrays.asList("aa","bbc","cc","dd", "aa").stream();
		System.out.println(s.collect(Collectors.partitioningBy(String::isEmpty, Collectors.toCollection(TreeSet::new))));
		
		s = Arrays.asList("aa","bbc","cc","dd", "aa").stream();
		System.out.println(s.collect(Collectors.mapping(String::length, Collectors.maxBy((a,b)->b-a))));
		
	}

	private static void testPrimitiveStreams() {
		Stream<Integer> i = Arrays.asList(1,2,3,4,5,6,9).stream();
		System.out.println(i.mapToDouble(a->(double)a).average().getAsDouble()
				);
		
		IntStream ins = IntStream.of(1,2,3,4,5,6);
		
		
		
	}

	private static void testStreamIntermediateOperations() {
		Stream<Integer> i = Arrays.asList(1,2,3,4,5,6,9).stream();
		i.filter(a->a%2==0).peek(System.out::print).count();
		
		Stream<String> s = Arrays.asList("aa","bb","cc","dd").stream();
		s.filter(p->p.length()>1).forEach(System.out::print);
		
		 i = Arrays.asList(1,2,3,4,4,6,9).stream();
		i.distinct().forEach(System.out::print);
		
		 s = Arrays.asList("aa","bb","cc","aa").stream();
		System.out.println(s.distinct().count());
		
		System.out.println("limit");
		i = Arrays.asList(1,2,3,4,4,6,9).stream();
		System.out.println(i.skip(2).limit(4).peek(System.out::print).count());
		
		 s = Arrays.asList("aa","bb","cc","aa").stream();
		 s.map(String::isEmpty).forEach(System.out::print);
		 
		 s = Arrays.asList("aa","bb","cc","aa").stream();
		 s.map(String::length).forEach(System.out::print);
		 
		 System.out.println();
		 i = Arrays.asList(10,2,6,4,4,6,9).stream();
		 i.sorted().peek(System.out::print).count();
		 
		 i = Arrays.asList(10,2,6,4,4,6,9).stream();
		 System.out.println(i.sorted(Integer::compareTo).findFirst());
		 
		 i = Arrays.asList(10,2,6,4,4,6,9).stream();
		 System.out.println(i.sorted((a,b)->b-a).findFirst());
		 
		 
		
	}

	private static void testStreamTerminalOperations() {

		long count = Arrays.asList(1,2,3,4,5,6,9).stream().count();
		System.out.println(count);

		Stream<String> s = Arrays.asList("aa","bb","cc","dd").stream();

		System.out.println(s.min(
				(a,b)->a.compareTo(b)
				));

		s = Arrays.asList("aa","bb","cc","dd").stream();

		System.out.println(s.max(
				String::compareTo
				));

		s = Arrays.asList("aa","bb","cc","dd").stream();

		System.out.println(s.findAny()); 

		s = Arrays.asList("aa","bb","cc","dd").stream();

		System.out.println(s.findFirst());


		s = Arrays.asList("aa","bb","cc","dd").stream();

		System.out.println(s.allMatch(
				a -> a.isEmpty() //String::isEmpty
				));
		
		s = Arrays.asList("aa","bb","cc","dd").stream();

		System.out.println(s.allMatch(
				a -> a.length()==2
				));
		s = Arrays.asList("aa","bb","cc","dd").stream();
		
		System.out.println(s.noneMatch(
				String::isEmpty
				));
		
		s = Arrays.asList("aa","bb","cc","dd").stream();
		
		System.out.println(s.reduce("rajiv", String::concat));
		
		s = Arrays.asList("aa","bb","cc","dd").stream();
		
		System.out.println(s.reduce("", (a,b)->a+b));
		
		System.out.println(Stream.of(1,2,3,4).reduce(1,(a,b)->a+b));
		
		System.out.println(Stream.of(1,2,3,4).reduce((a,b)->a+b));
		System.out.println("test");
		System.out.println(
				Stream.of(1,2,3,4).parallel()
				.reduce(1,(a,b)->a+b,(a,b)->a-b)
		          );
		
		
		s = Arrays.asList("aa","bb","cc","dd").stream();
		List<String> list = s.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(list);
		
		s = Arrays.asList("aa","bb","cc","aa").stream();
		Set<String> set = s.collect(Collectors.toSet());
		System.out.println(set);
		
		s = Arrays.asList("aa","bb","cc","dd").stream();
		Map map = s.collect(Collectors.toMap((k)->k, 
				(v)->v.length()));
		System.out.println(map);
		
		
		s = Arrays.asList("aa","bb","cc","dd").stream();
	System.out.println(s.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append));

		s = Arrays.asList("aa","bb","cc","dd").stream();
		System.out.println(s.collect(TreeSet::new,TreeSet::add,TreeSet::addAll));
		
		
		

	}

	private static void testStreams() {

		Stream s = Stream.of(1);
		s.forEach(System.out::print);
		
		s = Stream.of(1,2,3);
		s.peek(System.out::print);
		
		s = Stream.empty();
		s.forEach(System.out::print);
		
		s = Stream.generate(Math::random);
		//s.limit(10).peek(System.out::println).count();
		
		s = Stream.iterate(1, (i)-> i+1);
		s.limit(10).peek(System.out::println).count();
		
		
	}

}
