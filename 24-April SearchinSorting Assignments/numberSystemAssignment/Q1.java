package numberSystemAssignment;

import java.util.Scanner;

/*Problem 1: given a number, print its binary representation. [easy]
Input 1: number = 5
Output 1: 101
Input 2: number = 10
Output 2: 1010*/
public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to get binary format:");
		int num = sc.nextInt();
		sc.close();
		decimalToBinary(num);
	}

	private static void decimalToBinary(int num) {
		String binary = "";
		while (num > 0) {
			int rem = num % 2;
			binary = rem + binary;
			num /= 2;
		}
		System.out.println("Binary format is " + binary);
	}
}