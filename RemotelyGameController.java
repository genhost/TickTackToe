package TickTackToe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class RemotelyGameController {
	private final Replica replica = new Replica();

	@FXML
	Button backBtn;
	@FXML
	Label nRealizedLabel;

	@FXML
	public void initialize() {
		backBtn.setText(replica.back);
		nRealizedLabel.setText(replica.nRealized);
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
}
