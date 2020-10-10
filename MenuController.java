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
	}

	@FXML
	public void handleButtonAction(ActionEvent event) throws Exception {
		Stage stage;
		Parent root;

		if (event.getSource() == onOnePcBtn) {
			stage = (Stage) onOnePcBtn.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("onePcGameUI.fxml"));
		} else {
			stage = (Stage) withAiBtn.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("withAiGameUI.fxml"));
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
