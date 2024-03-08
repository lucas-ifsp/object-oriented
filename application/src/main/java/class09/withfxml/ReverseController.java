package class09.withfxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ReverseController {
    @FXML private Label labelResult;
    @FXML private TextField txtInput;

    @FXML // the @FXML assures that attributes and methods names in the class match the ids in the fxml file
    public void reverse(ActionEvent e) throws Exception {
        final String inputText = txtInput.getText(); // to get the text
        final String reversedText = new StringBuilder(inputText).reverse().toString();
        labelResult.setText(STR."Result: \{reversedText}"); // to set the reversed text
        InfoSceneLoader sceneLoader = new InfoSceneLoader();
        sceneLoader.show(reversedText.length());
    }
}
