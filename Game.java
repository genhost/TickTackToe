package TickTackToe;

import java.util.Arrays;
import java.util.Random;

public class Game {
	private static final Random random = new Random();
	public static char[][] field = new char[3][3];
	public static boolean lockField = false;
	public static boolean turn = true;

	public static boolean checkWin(char sign) {
		for (int i = 0; i < 3; i++)
			if ((field[i][0] == sign && field[i][1] == sign &&
					field[i][2] == sign) ||
					(field[0][i] == sign && field[1][i] == sign &&
							field[2][i] == sign))
				return true;
		return (field[0][0] == sign && field[1][1] == sign &&
				field[2][2] == sign) ||
				(field[2][0] == sign && field[1][1] == sign &&
						field[0][2] == sign);
	}

	public static boolean checkDraw() {
		if (checkWin('x') || checkWin('o')) return false;
		for (char[] i : field) {
			for (char j : i) {
				if (j == 0) return false;
			}
		}
		return true;
	}

	public static char getCell(int x, int y) { return field[x - 1][y - 1]; }

	public static boolean isCellValid(int x, int y) {
		if (x < 0 || y < 0 || x >= 3|| y >= 3)
			return false;
		return field[y][x] == 0;
	}

	public static void turnAI() {
		int x, y;
		do {
			x = random.nextInt(3);
			y = random.nextInt(3);
		} while (!isCellValid(x, y) && !checkDraw());
		field[y][x] = 'o';
	}
}
