public class PracticeProblem {

	public static void main(String args[]) {}

	public static int searchMazeMoves(String[][] arr) {

		int row = arr.length-1;
		int col = 0;

		int noOfMoves = 0;

		int MVOES = searchMazeMovesHelper(arr, row, col, noOfMoves);

		if (MVOES == 10000000) {
			return -1;
		}

		return MVOES;
	}

	public static int searchMazeMovesHelper(String[][] arr, int row, int col, int moves) {

		if (row < 0 || row > arr.length-1 || col > arr[row].length-1 || col < 0) {	
			return 10000000;
		}

		if (arr[row][col].equals("*")) {
			return 10000000;
		}

		if (arr[row][col].equals("F")) {
			return moves;
		}

		arr[row][col] = "*";

		int minRight = searchMazeMovesHelper(arr, row, col+1, moves+1);
		int minUp = searchMazeMovesHelper(arr, row-1, col, moves+1);
		int minLeft = searchMazeMovesHelper(arr, row, col-1, moves+1);
		int minDown = searchMazeMovesHelper(arr, row+1, col, moves+1);

		arr[row][col] = "";

		return Math.min(Math.min(minRight, minLeft), Math.min(minUp, minDown));
	}
}
