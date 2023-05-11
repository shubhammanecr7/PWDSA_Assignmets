package recursionAssignment;
/*: Find the sum of the values of the array [92, 23, 15, -20, 10].*/
public class Q4 {
	public static void main(String[] args) {
		int a[] = {92,23,15,-20,10};
		int sum=0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		System.out.println("Sum = "+sum);
	}
}
