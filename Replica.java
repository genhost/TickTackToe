package TickTackToe;

import java.util.Locale;

public class Replica {
	public String language, gameMode, onePcGameMode, aiGameMode, remotelyGameMode,
			draw, crossTurn, zeroWin, crossWin, zeroTurn, replay, nRealized, back;

	Replica() {
		Locale.setDefault(new Locale("ru"));
		language = Locale.getDefault().getLanguage();
		if (language.equals("ru")) {
			gameMode = "Выберите режим игры";
			onePcGameMode = "На одном компьютере";
			aiGameMode = "С искуственным интелектом";
			remotelyGameMode = "Удалённо";
			draw = "Ничья";
			crossTurn = "Ходит крестики:";
			crossWin = "Крестики победил!";
			zeroTurn = "Ходит нолики:";
			zeroWin = "Нолики победил!";
			replay = "Переиграть";
			nRealized = "Данная функция ещё не реализована";
			back = "Назад";
		} else {
			gameMode = "Choose Game Mode";
			onePcGameMode = "On one pc";
			aiGameMode = "AI";
			remotelyGameMode = "Remotely";
			draw = "Draw";
			crossTurn = "Cross player turn:";
			crossWin = "Cross player Win!";
			zeroTurn = "Zero player turn:";
			zeroWin = "Zero player Win!";
			replay = "Replay";
			nRealized = "This game function isn't realized yet";
			back = "Back";
		}
	}
}
