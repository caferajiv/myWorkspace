package hackerearth.medlife;


import java.util.Scanner;

public class TestClass1 {

	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);

		int totalNumbers = in.nextInt();

		int[] a = new int[totalNumbers];

		for (int i = 0; i < totalNumbers; i++) {
			a[i] = in.nextInt();
		}

		System.out.println(getMaxIndex(a));

	}

	private static int getMaxIndex(int[] a) {
		int[] m = new int[a.length];
		for (int i = a.length - 2; i >= 0; i--) {
			for (int j = a.length - 1; j > i; j--) {
				if (m[i] <= m[j] && a[i] > a[j]) {
					m[i] = m[i] + 1;
				}
			}
		}
		int max = m[0];
		for (int i = 0; i < m.length; i++) {
			if (max < m[i]) {
				max = m[i];
			}
		}
		
		for (int i = 0; i < m.length; i++) {
			if (max == m[i]) {
				return i;
			}
		}

		return 0;
	}

}
