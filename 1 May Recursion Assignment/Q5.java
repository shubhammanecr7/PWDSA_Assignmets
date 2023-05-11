package recursionAssignment;

import java.util.Scanner;

/*Q5. Given a number n. Print if it is an armstrong number or not. An armstrong number is a number if the sum
of every digit in that number raised to the power of total digits in that number is equal to the number.
Example : 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153 hence 153 is an armstrong number. (Easy)
Input1 : 153
Output1 : Yes
Input 2 : 134
Output2 : No*/
public class Q5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to check :");
		int num = sc.nextInt();
		// counting number of digits
		int temp = num;
		int cnt = 0;
		while (temp > 0) {
			temp /= 10;
			cnt++;
		}
		// finding armstrong number
		int sum = 0;
		int n = num;
		while (n > 0) {
			int rem = n % 10;
			int pow = (int) Math.pow(rem, cnt);
			sum += pow;
			n /= 10;
		}
		
		if (sum==num) 
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
