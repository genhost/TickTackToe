package TickTackToe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class OnePcGameController {
	private final Replica replica = new Replica();

	@FXML
	private Label turnLabel;

	@FXML
	private Button replayBtn;

	@FXML
	private Button backBtn;

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
	public void initialize() {
		replayBtn.setText(replica.replay);
		backBtn.setText(replica.back);
		clickReplay();
	}

	@FXML
	public void updateField() {
		if (Game.turn) turnLabel.setText(replica.crossTurn);
		else turnLabel.setText(replica.zeroTurn);
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
			turnLabel.setText(replica.crossWin);
			Game.lockField = true;
		} else if (Game.checkWin('o')) {
			turnLabel.setText(replica.zeroWin);
			Game.lockField = true;
		} else if (Game.checkDraw()) {
			turnLabel.setText(replica.draw);
			Game.lockField = true;
		}
	}

	public void handleCellBtnAction(int x, int y) {
		x -= 1;
		y -= 1;

		if (Game.lockField) return;
		if (Game.field[x][y] != 0) return;

		if (Game.turn) Game.field[x][y] = 'x';
		else Game.field[x][y] = 'o';

		Game.turn = !Game.turn;
	}

	@FXML
	public void clickReplay() {
		Game.field = new char[3][3];
		Game.lockField = false;
		Game.turn = true;
		updateField();
	}

	@FXML
	public void handleBackBtnAction(ActionEvent event) throws Exception {
		Stage stage;
		Parent root;
		stage = (Stage) backBtn.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("menuUI.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void clickCellBtn1(ActionEvent event) {
		handleCellBtnAction(1, 1);
		updateField();
	}

	@FXML
	public void clickCellBtn2(ActionEvent event) {
		handleCellBtnAction(1, 2);
		updateField();
	}

	@FXML
	public void clickCellBtn3(ActionEvent event) {
		handleCellBtnAction(1, 3);
		updateField();
	}

	@FXML
	public void clickCellBtn4(ActionEvent event) {
		handleCellBtnAction(2, 1);
		updateField();
	}

	@FXML
	public void clickCellBtn5(ActionEvent event) {
		handleCellBtnAction(2, 2);
		updateField();
	}

	@FXML
	public void clickCellBtn6(ActionEvent event) {
		handleCellBtnAction(2, 3);
		updateField();
	}

	@FXML
	public void clickCellBtn7(ActionEvent event) {
		handleCellBtnAction(3, 1);
		updateField();
	}

	@FXML
	public void clickCellBtn8(ActionEvent event) {
		handleCellBtnAction(3, 2);
		updateField();
	}

	@FXML
	public void clickCellBtn9(ActionEvent event) {
		handleCellBtnAction(3, 3);
		updateField();
	}
}
