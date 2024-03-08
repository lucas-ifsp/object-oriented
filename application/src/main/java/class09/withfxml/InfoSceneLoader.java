package class09.withfxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InfoSceneLoader { // Only the first stage to appear need to extend application
    public void show(int reversedChars) throws Exception {
        final FXMLLoader loader = new FXMLLoader();
        // It loads the elements in the fxml and keep the stream open to also get the controller
        final Pane layout = loader.load(getClass().getResource("info.fxml").openStream());
        final Scene scene = new Scene(layout, 500, 100);
        final InfoController controller = loader.getController();
        controller.setReversedCharsInfo(reversedChars);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL); // Indicates that this stage is a modal
        stage.setTitle("Reverse App");
        stage.setScene(scene);
        stage.showAndWait(); // opens the scene and block the calling stage
    }
}
