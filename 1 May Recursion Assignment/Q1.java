package recursionAssignment;

import java.util.Scanner;

/*Given an integer, find out the sum of its digits using recursion.
Input: n= 1234
Output: 10
Explanation: 1+2+3+4=10*/
public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number :");
		int num = sc.nextInt();
		
		int result = countDigitSum(num);
		System.out.println("Digit Sum = "+result);
	}

	private static int countDigitSum(int num) {
		if(num==0)
			return 0;
		else
			return num%10 + countDigitSum(num/10);
	}
}
