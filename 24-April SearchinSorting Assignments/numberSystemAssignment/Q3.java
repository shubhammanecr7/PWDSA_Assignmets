package numberSystemAssignment;

import java.util.Scanner;

/*Q3. Problem 1: Given a number. Using bit manipulation, check whether it is odd or even.
Input 8, Even
3, False*/
public class Q3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int num = sc.nextInt(); sc.close();
		
		if((num&1)==0)
			System.out.println("Even");
		else
			System.out.println("Odd");
	}
}