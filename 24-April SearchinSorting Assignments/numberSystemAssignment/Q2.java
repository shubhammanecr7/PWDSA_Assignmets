package numberSystemAssignment;

import java.util.Scanner;

/*Problem 2: given a number ‘n’, predict whether it is a power of two or not. [medium]
Input 1: n = 15
Output 1: False
Input 2: n = 32
Output 2: True*/
public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int num = sc.nextInt(); sc.close();
		boolean result = isPowerOfTwo(num);
		System.out.println(result);
	}

	private static boolean isPowerOfTwo(int num) {
		if(num < 1)
			return false;
		if(num == 1)
			return true;
		if(num%2==1)
			return false;
		return isPowerOfTwo(num/2);
	}
}