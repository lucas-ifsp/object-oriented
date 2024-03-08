package class09.tableview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ProductsSceneLoader extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final Pane layout = FXMLLoader.load(getClass().getResource("products.fxml"));
        final Scene scene = new Scene(layout, 600, 500);
        stage.setTitle("Products Management");
        stage.setScene(scene);
        stage.show();
    }
}
