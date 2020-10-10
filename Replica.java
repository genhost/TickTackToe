package TickTackToe;

import java.util.Locale;

public class Replica {
	public String language, gameMode, onePcGameMode, aiGameMode,
			draw, crossTurn, zeroWin, crossWin, zeroTurn, replay, back;

	Replica() {
		language = Locale.getDefault().getLanguage();
		if (language.equals("ru")) {
			gameMode = "Выберите режим игры";
			onePcGameMode = "На одном компьютере";
			aiGameMode = "С искуственным интелектом";
			draw = "Ничья";
			crossTurn = "Ходит крестики:";
			crossWin = "Крестики победил!";
			zeroTurn = "Ходит нолики:";
			zeroWin = "Нолики победил!";
			replay = "Переиграть";
			back = "Назад";
		} else {
			gameMode = "Choose Game Mode";
			onePcGameMode = "On one pc";
			aiGameMode = "AI";
			draw = "Draw";
			crossTurn = "Cross player turn:";
			crossWin = "Cross player Win!";
			zeroTurn = "Zero player turn:";
			zeroWin = "Zero player Win!";
			replay = "Replay";
			back = "Back";
		}
	}
}
