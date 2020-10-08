package TickTackToe;

import java.util.Locale;

public class Replica {
	String language;
	String draw;
	String crossTurn;
	String zeroWin;
	String crossWin;
	String zeroTurn;

	Replica() {
		language = Locale.getDefault().getLanguage();
		if (language.equals("ru")) {
			draw = "Ничья";
			crossTurn = "Ходит Игрок-крестики:";
			crossWin = "Игрок-крестики победил!";
			zeroTurn = "Ходит Игрок-нолики:";
			zeroWin = "Игрок-нолики победил!";
		} else {
			draw = "Draw";
			crossTurn = "Cross player turn:";
			crossWin = "Cross player Win!";
			zeroTurn = "Zero player turn:";
			zeroWin = "Zero player Win!";
		}
	}
}
