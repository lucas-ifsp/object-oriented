package class09.withcode;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ViewReverser extends Application { // Now ViewReverser "is-an" Application
    @Override
    public void start(Stage stage) {
        // create an object of each element in the scene
        Label labelInput = new Label("Input:");
        TextField textInput = new TextField();
        Button buttonExecute = new Button("Revert");
        Label labelResult = new Label("Result:");

        textInput.setPromptText("Input text"); // configure hint for input field

        // create a layout to organize the elements in the scene
        HBox layout = new HBox();
        //VBox layout = new VBox();
        layout.setSpacing(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setAlignment(Pos.BASELINE_LEFT);
        layout.getChildren().addAll(labelInput, textInput, buttonExecute, labelResult);

//        BorderPane layout = new BorderPane();
//        layout.setLeft(labelInput);
//        layout.setCenter(textInput);
//        layout.setRight(labelResult);
//        layout.setBottom(buttonExecute);
//        layout.setPadding(new Insets(10,10,10,10));

//        GridPane layout = new GridPane();
//        layout.setVgap(6); // vertical distance between components
//        layout.setHgap(10); // horizontal distance between components
//        layout.setPadding(new Insets(10, 10, 10, 10));
//        layout.add(labelInput, 0, 0);
//        layout.add(textInput, 1, 0);
//        layout.add(labelResult, 0, 1, 2, 1); // this component uses two horizontal cells
//        layout.add(buttonExecute, 2, 0);


        Scene scene = new Scene(layout, 450, 80); // create a scene with the configured layout and elements
        stage.setTitle("String Reverser");
        stage.setScene(scene); // add the scene to stage (SO window)
        stage.show();
    }
}
