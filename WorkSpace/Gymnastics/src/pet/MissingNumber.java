package pet;

public class MissingNumber {

	public static void main(String[] args) {
		int numberOfInts = 8;
		int[] nums = {1,3,5,7,8,6,2};
		byte[] bitfield = new byte[numberOfInts/2];
		
		for(int n : nums) {
			bitfield[n/4] |= 1<<(n%4);
		}
		
		for(int i=0 ;i<bitfield.length;i++) {
			for(int j=0;j<4;j++) {
				if((bitfield[i] & (1 << j)) == 0) {
					int missing = i*4+j;
					if(missing>0 && missing<=8) {
						System.out.println(i*4+j);
						return;
					}
					
				}
			}
		}
		
	}
}
