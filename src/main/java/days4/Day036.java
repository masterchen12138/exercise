package days4;

/**
 * @author Yec
 * @date 2021-08-27
 * 有效的数独
 */
public class Day036 {
	public static boolean isValidSudoku(char[][] board) {
		int[][] a = new int[9][9];
		int[][] b = new int[9][9];
		int[][] c = new int[9][9];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '1';
					int boxId = (i / 3) * 3 + j / 3;
					if (a[i][num] == 1) return false;
					else a[i][num] = 1;
					if (b[j][num] == 1) return false;
					else b[j][num] = 1;
					if (c[boxId][num] == 1) return false;
					else c[boxId][num] = 1;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValidSudoku(new char[][]{
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		}));
	}
}
