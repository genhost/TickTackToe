package TickTackToe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class RemotelyGameController {
	private final Replica replica = new Replica();
	private boolean canGetField = false;

	@FXML
	Group serverFormGroup;

	@FXML
	Group gameGroup;

	@FXML
	ProgressIndicator gameProgressIndicator;

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
	TextField connectHost;
	@FXML
	TextField connectPort;
	@FXML
	TextField createHost;
	@FXML
	TextField createPort;

	@FXML
	Button backBtn;

	@FXML
	public void initialize() {
		backBtn.setText(replica.back);
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
	public void connectBtnAction() throws IOException {
		gameProgressIndicator.setVisible(true);

		String outputField = "";
		Socket clientSocket;
		BufferedReader reader;
		BufferedReader in;
		BufferedWriter out;

		clientSocket = new Socket(connectHost.getText(), Integer.getInteger(connectPort.getText()));
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

		gameProgressIndicator.setVisible(false);
		serverFormGroup.setVisible(false);
		gameGroup.setVisible(true);

		while (!Game.checkDraw() && !Game.checkWin('x') && !Game.checkWin('o')) {
			if (Game.turn) {
				updateField();
				Game.lockField = false;
				while (!canGetField) {
					if (canGetField) break;
				}
				for (char[] i : Game.field) {
					for (char j : i) {
						if (j == 0) {
							outputField = outputField.concat("0 ");
							continue;
						}
						outputField = outputField.concat(String.valueOf(j) + " ");
					}
				}
				out.write(outputField);
				out.flush();
			} else {
				turnLabel.setText(replica.zeroTurn);
				Game.lockField = true;
				String fieldString = in.readLine();
				Game.field = Game.parseField(fieldString);
				Game.turn = !Game.turn;
				updateField();
			}
		}

		clientSocket.close();
		in.close();
		out.close();
	}

	@FXML
	public void createBtnAction() throws IOException {
		clickReplay();
		gameProgressIndicator.setVisible(true);

		Game.turn = new Random().nextBoolean();
		String outputField = "";
		Socket clientSocket;
		ServerSocket server;
		BufferedReader in;
		BufferedWriter out;

		server = new ServerSocket(Integer.getInteger(String.valueOf(createPort.textProperty())));
		clientSocket = server.accept();

		gameProgressIndicator.setVisible(false);
		serverFormGroup.setVisible(false);
		gameGroup.setVisible(true);

		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

		while (!Game.checkDraw() && !Game.checkWin('x') && !Game.checkWin('o')) {
			if (Game.turn) {
				updateField();
				Game.lockField = false;
				while (!canGetField) {
					if (canGetField) break;
				}
				for (char[] i : Game.field) {
					for (char j : i) {
						if (j == 0) {
							outputField = outputField.concat("0 ");
							continue;
						}
						outputField = outputField.concat(String.valueOf(j) + " ");
					}
				}
				out.write(outputField);
				out.flush();
			} else {
				turnLabel.setText(replica.zeroTurn);
				Game.lockField = true;
				String fieldString = in.readLine();
				Game.field = Game.parseField(fieldString);
				Game.turn = !Game.turn;
				updateField();
			}
		}

		clientSocket.close();
		in.close();
		out.close();
		server.close();
	}

	public void handleCellBtnAction(int x, int y) {
		x -= 1;
		y -= 1;

		if (Game.lockField) return;
		if (Game.field[x][y] != 0) return;

		Game.field[x][y] = 'x';

		canGetField = true;
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

	@FXML
	public void clickReplay() {
		Game.field = new char[3][3];
		Game.lockField = false;
		Game.turn = true;
		updateField();
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
