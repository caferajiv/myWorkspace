package hiredintech.lists;

public class ListSolution {

    public static void main(String[] args) {

	long number = 123l;
	System.out.println(is_numeric_palindrome(number));
    }

    public static int digit_sum(long number) {
	int sum = 0;
	number = Math.abs(number);
	while(number>0){
	    sum = sum + (int)(number%10);
	    number = number/10;
	}

	return sum;
    }
    
    public static boolean is_numeric_palindrome(long number) {
	int [] arr = new int[20];
	int index = 0;
	while(number>0){
	    arr[index] = (int)(number%10);
	    number = number/10;
	    index++;
	}

	for(int i=0,j=index-1; i<=j;i++,j--) {
	    if(arr[i]!=arr[j]) return false;
	}
	return true;
    }

}
