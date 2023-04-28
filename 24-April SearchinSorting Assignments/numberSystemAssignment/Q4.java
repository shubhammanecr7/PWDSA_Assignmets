package numberSystemAssignment;

import java.util.Scanner;

/*Q4. Given a number, count the number of set bits in that number without using an extra space.
Note : bit ‘1’ is also known as set bit.*/
public class Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int num = sc.nextInt();
		sc.close();

		int result = countSetBits(num);
		System.out.println("Total set bits are : "+result);
	}

	private static int countSetBits(int num) {
		if (num == 0)
			return 0;
		if (num == 1)
			return 1;
		
		if(num%2==0)
			return countSetBits(num/2);
		else
			return 1+countSetBits(num/2);
	}
}
