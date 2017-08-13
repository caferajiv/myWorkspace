package coding;

public class BinaryNumberGeneration {
	
	private final void doit()
	{}

	public static void main(String[] args) {
		int num=4;
		int binaryNumbers = 1<<num; 
		for(int i=0;i<binaryNumbers;i++)
		{
			System.out.println("num: "+i+" -> Binary: "+Integer.valueOf(i).toBinaryString(i));
		}
	}
}
