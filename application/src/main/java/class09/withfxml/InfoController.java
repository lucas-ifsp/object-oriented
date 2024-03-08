package class09.withfxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InfoController {
    @FXML private Label labelResult;
    public void setReversedCharsInfo(int reversedChars) {
        labelResult.setText(String.valueOf(reversedChars));
    }
    @FXML
    public void close(ActionEvent actionEvent) {
        // Get the scene where the label is located. Then, get the stage of this scene.
        final Stage stage = (Stage) labelResult.getScene().getWindow();
        stage.close();
    }
}
