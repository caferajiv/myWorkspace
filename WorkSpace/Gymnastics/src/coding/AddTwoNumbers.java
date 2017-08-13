package coding;

public class AddTwoNumbers {
	
	public static void main(String[] args) {
		int a = 758;
		int b = 678;
		
		System.out.println(a+b);
		System.out.println(sum_without_arithmetic(a,b));
		
	}

	private static int sum_without_arithmetic(int a, int b)
	{
		if(b==0) return a;
		int sum = a ^ b ; //only sum no carry
		int  carry = ( a & b )<<1;  //only carry 
		return sum_without_arithmetic(sum, carry);
	}
}
