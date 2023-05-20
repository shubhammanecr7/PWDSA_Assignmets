package backtrackingAssignment;

/*Q5. The n-queens puzzle is the problem of placing n queens on an n x
n chessboard such tha no two queens attack each other. Given an
integer n, return the number of distinct solutions to the n-queens puzzle.
Input:n = 4
Output:2
Explanation:There are two distinct solutions to the 4-queens puzzle as shown.
Input:n = 1
Output:1
*/
public class Q5 {
	public static void printSolution(int[][] board, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean isSafe(int board[][], int row, int column, int n) {
		int i, j;
		// check on the left row
		for (i = 0; i < column; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}

		// check for the upper diagonal in left direction
		for (i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		// check for the lower diagonal in right direction
		for (i = row, j = column; i < n && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	// function to solve n queen problem
	public static boolean solvenQueen(int board[][], int column, int n) {
		// Base case if you have placed all queens then return true
		if (column >= n) {
			return true;
		}

		// consider the column and try to place all the queens in
		// all the rows one by one
		for (int i = 0; i < n; i++) {
			// check if it is safe to place the queen or not
			if (isSafe(board, i, column, n) == true) {
				// place the queen on the board
				board[i][column] = 1;

				// recursive call to place all teh queens
				if (solvenQueen(board, column + 1, n) == true) {
					return true;
				}
			}

			// if placing the queen does not lead to solution backtrack
			board[i][column] = 0;
		}

		// if it is not possible to place the queen in any row of given column
		// then return false
		return false;
	}

	public static void main(String[] args) {
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		if (solvenQueen(board, 0, board.length) == true) {
			printSolution(board, board.length);
		} else {
			System.out.println("Solution does not exist...");
		}
	}

}
