package recursionAssignment;

import java.util.Scanner;

/*Q2: Given a number n. Find the sum of natural numbers till n but with alternate signs.
That means if n = 5 then you have to return 1-2+3-4+5 = 3 as your answer.
Constraints : 0<=n<=1e6
Input1 : n = 10
Output 1 : -5
Explanation : 1-2+3-4+5-6+7-8+9-10 = -5
Input 2 : n = 5
Output 2 : 3*/
public class Q2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number :");
		int num = sc.nextInt();
		
		int sum = 0;
		for(int i=1 ; i<=num ;i++) {
			if(i%2!=0)
				sum += i;
			else
				sum -=i;
		}
		
		System.out.println("Sum = "+sum);
	}
}
