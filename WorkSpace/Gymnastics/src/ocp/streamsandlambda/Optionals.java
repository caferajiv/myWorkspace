package ocp.streamsandlambda;

import java.util.Optional;

public class Optionals {
	
	public static void main(String[] args) {
		//testEmptyOptional();
		//testOptionalGet();
		testOptionalValue();
		//testOptionalIsPresent();
		testOptionalNullable();
		testOptionalOrElse();
		testOptionalOrElseGet();
		testOtionalOrElseThrow();
		
	}

	private static void testEmptyOptional() {
		
		Optional opt = Optional.empty();
		System.out.println(opt.get());
		
		
	}

	private static void testOptionalGet() {
		Optional<Integer> opt = Optional.of(10);
		System.out.println(opt.get());
		System.out.println(Optional.of("rajiv").get());
		System.out.println(Optional.of(null));
		
	}

	private static void testOptionalValue() {

		
	}

	private static void testOptionalIsPresent() {
		Optional opt = Optional.empty();
		if(opt.isPresent()) {
			System.out.println(opt.get());
		}else {
			try {
				System.out.println(opt.orElseThrow(NullPointerException::new));
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private static void testOptionalNullable() {

		Optional opt = Optional.ofNullable(null);
		System.out.println(opt);
		if(opt.isPresent()) {
			System.out.println(opt.get());
		}else {
			try {
				System.out.println(opt.orElseThrow(NullPointerException::new));
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void testOptionalOrElse() {
		// TODO Auto-generated method stub
		
	}

	private static void testOptionalOrElseGet() {
		// TODO Auto-generated method stub
		
	}

	private static void testOtionalOrElseThrow() {
		// TODO Auto-generated method stub
		
	}

}
