package TickTackToe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
	@FXML
	private Label turnLabel;

	@FXML
	private Button replayBtn;

	@FXML
	private Button cellBtn1;
	@FXML
	private Button cellBtn2;
	@FXML
	private Button cellBtn3;
	@FXML
	private Button cellBtn4;
	@FXML
	private Button cellBtn5;
	@FXML
	private Button cellBtn6;
	@FXML
	private Button cellBtn7;
	@FXML
	private Button cellBtn8;
	@FXML
	private Button cellBtn9;

	@FXML
	public void updateField() {
		if (Game.turn) turnLabel.setText(Main.replica.crossTurn);
		else turnLabel.setText(Main.replica.zeroTurn);
		cellBtn1.setText(String.valueOf(Game.getCell(1, 1)));
		cellBtn2.setText(String.valueOf(Game.getCell(1, 2)));
		cellBtn3.setText(String.valueOf(Game.getCell(1, 3)));
		cellBtn4.setText(String.valueOf(Game.getCell(2, 1)));
		cellBtn5.setText(String.valueOf(Game.getCell(2, 2)));
		cellBtn6.setText(String.valueOf(Game.getCell(2, 3)));
		cellBtn7.setText(String.valueOf(Game.getCell(3, 1)));
		cellBtn8.setText(String.valueOf(Game.getCell(3, 2)));
		cellBtn9.setText(String.valueOf(Game.getCell(3, 3)));

		if (Game.checkWin('x')) {
			turnLabel.setText(Main.replica.crossWin);
			Game.lockField = true;
		} else if (Game.checkWin('o')) {
			turnLabel.setText(Main.replica.zeroWin);
			Game.lockField = true;
		} else if (Game.checkDraw()) {
			turnLabel.setText(Main.replica.draw);
			Game.lockField = true;
		}


	}

	@FXML
	public void clickReplay(ActionEvent event) {
		Game.field = new char[3][3];
		Game.lockField = false;
		Game.turn = true;
		updateField();
	}

	@FXML
	public void clickCellBtn1(ActionEvent event) {
		Game.handleAction(1, 1);
		updateField();
	}

	@FXML
	public void clickCellBtn2(ActionEvent event) {
		Game.handleAction(1, 2);
		updateField();
	}

	@FXML
	public void clickCellBtn3(ActionEvent event) {
		Game.handleAction(1, 3);
		updateField();
	}

	@FXML
	public void clickCellBtn4(ActionEvent event) {
		Game.handleAction(2, 1);
		updateField();
	}

	@FXML
	public void clickCellBtn5(ActionEvent event) {
		Game.handleAction(2, 2);
		updateField();
	}

	@FXML
	public void clickCellBtn6(ActionEvent event) {
		Game.handleAction(2, 3);
		updateField();
	}

	@FXML
	public void clickCellBtn7(ActionEvent event) {
		Game.handleAction(3, 1);
		updateField();
	}

	@FXML
	public void clickCellBtn8(ActionEvent event) {
		Game.handleAction(3, 2);
		updateField();
	}

	@FXML
	public void clickCellBtn9(ActionEvent event) {
		Game.handleAction(3, 3);
		updateField();
	}
}
