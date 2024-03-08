package class09.tableview;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class ProductsController {
    @FXML private TableView<Product> table; // <EntityType, AttributeType>
    @FXML private TableColumn<Product, String> clSku;
    @FXML private TableColumn<Product, String> clName;
    @FXML private TableColumn<Product, Double> clPrice;
    @FXML private TableColumn<Product, Integer> clQuantity;
    @FXML private TableColumn<Product, Double> clTotal;
    private ObservableList<Product> data; // List that will hold the table content

    @FXML // the initialize method is called whenever the fxml is loaded
    private void initialize(){
        bindColumnsToAttributes();
        bindTableToData();
        loadData();
    }

    private void bindColumnsToAttributes() {
        clSku.setCellValueFactory(new PropertyValueFactory<>("sku")); // Product must provide a getSku() method
        clName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        clQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        clTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    private void bindTableToData() {
        data = FXCollections.observableArrayList(); // Static factory method for ObservableList subtype
        table.setItems(data); // Binds the list to the TableView. Any element added to the list will appear in the table
    }

    private void loadData() {
        final List<Product> products = List.of(
                new Product("SCL001", "Computer", 3, 4999.99),
                new Product("SCL002", "Monitor", 5, 1999.99),
                new Product("SCL003", "Keyboard", 7, 239.99)
        );
        data.clear(); // clear all elements to avoid duplicates
        data.addAll(products); //Add all elements in the observable list so that they will be shown in the table
    }
}

