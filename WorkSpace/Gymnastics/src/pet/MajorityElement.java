package pet;

import java.util.Arrays;

public class MajorityElement {
	
	public static void main(String[] args) {
		int [] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		
		System.out.println(majorityElement(arr));
	}
	
	private static int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
	
	private static int majorityElement2(int[] num) {

        Arrays.sort(num);
        
        return num[(num.length/2)-1];
    }

}
