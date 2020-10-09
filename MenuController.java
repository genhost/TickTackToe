package TickTackToe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MenuController {
	Replica replica = new Replica();

	@FXML
	private Label chooseGameModeLabel;
	@FXML
	private Button onOnePcBtn;
	@FXML
	private Button withAiBtn;
	@FXML
	private Button remotelyBtn;

	public void initialize() {
		chooseGameModeLabel.setText(replica.gameMode);
		onOnePcBtn.setText(replica.onePcGameMode);
		withAiBtn.setText(replica.aiGameMode);
		remotelyBtn.setText(replica.remotelyGameMode);
	}

	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage;
		Parent root;

		if (event.getSource() == onOnePcBtn) {
			stage = (Stage) onOnePcBtn.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("onePcGameUI.fxml"));
		} else if (event.getSource() == withAiBtn) {
			stage = (Stage) withAiBtn.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("withAiGameUI.fxml"));
		} else {
			stage = (Stage) remotelyBtn.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("remotelyGameUI.fxml"));
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
