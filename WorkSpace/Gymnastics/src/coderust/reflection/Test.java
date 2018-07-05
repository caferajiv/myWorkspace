package coderust.reflection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Type;

public class Test {
	
	private static Map<Class<?>, List<Type>> map = new HashMap<>();
	
	public static void main(String[] args) {
		List<Class<?>> classList = new ArrayList<>();
		classList.add(A.class);
		classList.add(C.class);
		classList.add(B.class);
		classList.add(D.class);
	    classList.add(E.class);
		classList.add(F.class);
		classList.add(K.class);
		classList.add(J.class);
		classList.add(I.class);
		
		
		
		
				
		
		System.out.println("Before Sorting");
		System.out.print(classList);
		sortClasses(classList);
		System.out.println();
		System.out.println("After Sorting");
		System.out.print(classList);
	}


	private static void sortClasses(List<Class<?>> classList) {
		
		Collections.sort(classList,new ClassComparator());
	}
	

	static class ClassComparator<T> implements Comparator<Class<T>>{

		@Override
		public int compare(Class<T> a, Class<T> b) {
			
			
			List<Type> superTypesOfA = getAllSuperTypes(a);
			
			List<Type> superTypesOfB = getAllSuperTypes(b);
			
			if(superTypesOfA.contains(b)) {
				return 1;
			}else if(superTypesOfB.contains(a)){
				return -1;
			}else {
				return 0;
			}
			
		}

		private List<Type> getAllSuperTypes(Class<T> a) {
			
			if(map.containsKey(a)) {
				return map.get(a);
			}
			List<Type> superTypes =  getAllSuperClasses(a);
			superTypes.addAll(getAllSuperInterfaces(a));
			map.put(a,superTypes);
			return superTypes;
		}

		private List<Type> getAllSuperClasses(Type a) {
			List<Type> allSuperClasses = new ArrayList<>();
			Type superClass = ((Class<T>)a).getGenericSuperclass();
			if(superClass!=null && !superClass.getTypeName().endsWith("java.lang.Object")) {
				allSuperClasses.add(superClass);
				allSuperClasses.addAll(getAllSuperClasses(superClass));
			}
			
			return allSuperClasses;
		}

		private List<Type> getAllSuperInterfaces(Type a) {
			List<Type> allSuperInterfaces = new ArrayList<>();
			Type [] interfaces =  ((Class<T>)a).getGenericInterfaces();
			for(Type ifce : interfaces) {
				allSuperInterfaces.add(ifce);
				allSuperInterfaces.addAll(getAllSuperInterfaces(ifce));
			}
			return allSuperInterfaces;
		}
		
	}
	static class A {
		
	}
	
	static class B {
		
		
	}
	static class C extends B {
		
	}
	
	static interface I {
		
	}
	
	static class D implements I {
		
	}
	
	static class E extends C implements I {
		
	}
	
	static interface J extends I {
		
	} 
	
	static interface K extends I, J {
		
	}
	
	static class F extends D implements K {
		
	}
	
}
