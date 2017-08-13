package mission.amazon.test.concept.chapter1Basics;

 /*static */interface TestInterface {  //static not allowed
	 
	 static interface InnerInterface {  //static allowed
		 
		 class InnerClass {  //allowed
			 
		 }  //inner class inside static interface
		 static class StaticInnerClass { //allowed
			 
		 }  //static inner class inside static interface
		 
	 }  //static inner interface
	 
	 class InnerClass {  //class inside interface allowed
		 
	 }
	 static class StaticInnerClass { //static class inside interface allowed
		 
	 }

}


 /*static */class  TestClass {  //static not allowed
	 
	 static class StaticInnerClass { //allowed
		 
	 }
	 
	 class InnerClass {  //allowed
		 
	 } 
	 
	 interface TestInterface {  // inner interface allowed
		 
		 static interface InnerInterface {  //static inner interface allowed
			 
			 class InnerClass {  //allowed
				 
			 }
			 static class StaticInnerClass { //allowed
				 
			 }
			 
		 }
		 
		 
		

	}
	 
	 static interface InnerInterface {  //static interface inside class allowed
		 
		 class InnerClass {  //allowed
			 
		 }
		 static class StaticInnerClass { //allowed
			 
		 }
		 
	 }

}