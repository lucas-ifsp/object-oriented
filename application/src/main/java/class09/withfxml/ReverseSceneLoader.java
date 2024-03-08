package class09.withfxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ReverseSceneLoader extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final Pane layout = FXMLLoader.load(getClass().getResource("reverse.fxml")); // path to the fxml file
        final Scene scene = new Scene(layout, 500, 100);
        stage.setTitle("Reverse App");
        stage.setScene(scene);
        stage.show(); // opens the scene
    }
}
