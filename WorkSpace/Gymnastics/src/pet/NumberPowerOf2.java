package pet;

public class NumberPowerOf2 {
    
    public static void main(String[] args) {
	
	int number = 64;
	
	System.out.println(isPowerOf2WithBits(number));
    }

    private static boolean isPowerOf2(int number) {
	
	if(number%2!=0) return false;
	
	while(number!=1) {
	    if(number%2!=0) return false;
	    
	    number = number /2;
	}
	return true;
    }
    
 private static boolean isPowerOf2WithBits(int number) {
	
	if(number%2!=0) return false;
	if(number==1) return false;
	
	System.out.println(number>>7);
	return true;
    }

}
