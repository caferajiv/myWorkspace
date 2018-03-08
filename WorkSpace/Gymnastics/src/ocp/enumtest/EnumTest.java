package ocp.enumtest;

public class EnumTest {
	
	enum Seasons {
		Summer("sum"),
		Winter("win"),
		Spring("spring"),
		Fall("fall");
		private String value;
		private Seasons(String value) {
			this.value = value;
		}
		
		private static Seasons get(String str) {
			if(str.equals("sum")) return Seasons.Summer;
			return null;
			
		}
	}
	
	public static void main(String[] args) {
		Seasons season = Seasons.valueOf("Summer");
		System.out.println(season);
		Seasons season1 = Seasons.get("sum");
	}

}
