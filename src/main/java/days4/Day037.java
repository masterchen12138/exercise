package days4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yec
 * @date 2021-08-27
 * 解数独
 */
public class Day037 {
	private static final boolean[][] line = new boolean[9][9];
	private static final boolean[][] column = new boolean[9][9];
	private static final boolean[][][] block = new boolean[3][3][9];
	private static boolean valid = false;
	private static final List<int[]> spaces = new ArrayList<>();

	public static void solveSudoku(char[][] board) {
		//记录空格的位置和已经填好的数字及其位置
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					spaces.add(new int[]{i, j});
				} else {
					int digit = board[i][j] - '1';
					line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
				}
			}
		}
		dfs(board, 0);
	}

	public static void dfs(char[][] board, int pos) {
		//如果所有空格都能填满，代表问题解决
		if (pos == spaces.size()) {
			valid = true;
			return;
		}
		int[] space = spaces.get(pos);
		int i = space[0], j = space[1];
		//往空格中填入符合条件的数字并递归，若无法完成所有空格，则回溯
		for (int digit = 0; digit < 9 && !valid; digit++) {
			if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
				line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
				board[i][j] = (char) (digit + '1');
				dfs(board, pos + 1);
				line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
			}
		}
	}

	public static void main(String[] args) {
		char[][] chs = new char[][]{
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		solveSudoku(chs);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(chs[i][j] + " ");
			}
			System.out.println();
		}
	}
}
