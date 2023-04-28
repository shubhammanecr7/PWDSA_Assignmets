package searchingAssignment;
/*Q5: Given a positive integer num, return true if num is a perfect square or false otherwise.
A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer
with itself.*/

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int num = sc.nextInt();
		boolean isPerfect = false;
		for (int i = 1; i * i <= num; i++) {
			if (i * i == num) {
				isPerfect = true;
			}
		}

		if (isPerfect) {
			System.out.println(num + " is perfect square");
		} else {
			System.out.println(num + " is not perfect square");
		}
	}
}
